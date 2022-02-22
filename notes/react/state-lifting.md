## Lifting State

State is encapsulated by the component that contains it. Because of this, a component cannot access the state of another component directly. However, as we've seen from the one way data flow, we can pass state from a parent component to a child component. Using this strategy, we are able to have components share data if they are provided this data from a shared parent or "ancestor." Because of the [one way data flow](./one-way-data-flow.md), though, this data passed down as props is [read-only](https://reactjs.org/docs/components-and-props.html#props-are-read-only); props are used to handle data that isn't expected to be changed by the component.

Let's take a look at an example to examine this further. Let's say we have a tool in which we enter two values that represent two sides of a right triangle. Based on these values, the hypotenuse is calculated and presented to the user. Let's start by taking a look at all of this functionality in one component.

```javascript
import React, { useState } from "react";

export default function HypotenuseCalculator() {
  let [values, setValues] = useState({ first: 0, second: 0, result: 0 });

  const calculateResult = (e) => {
    const numInputs = {
      first: values.first,
      second: values.second,
      [e.target.name]: e.target.value,
    };

    const result = Math.sqrt(
      Math.pow(numInputs.first, 2) + Math.pow(numInputs.second, 2)
    );

    numInputs.result = Math.round(result * 100) / 100;

    setValues(numInputs);
  };

  return (
    <div>
      <h3>Calculator</h3>
      <div>
        Enter first side value:
        <input name="first" type="number" onChange={calculateResult} />
      </div>
      <div>
        Enter first second value:
        <input name="second" type="number" onChange={calculateResult} />
      </div>
      <p>
        {values.first && values.second
          ? `Result is: ${values.result}`
          : `Enter both numbers above for a value`}
      </p>
    </div>
  );
}
```

In the component above, we collect input, perform calculations and display the result all in the same component so we have no issues sharing state. However, if we are ["thinking in react"](https://reactjs.org/docs/thinking-in-react.html#step-1-break-the-ui-into-a-component-hierarchy), we wouldn't want to structure our application in this way. We would want to follow the single responsibility model, creating a component to encapsulate each functionality. Doing so, we can create a component to represent a side input, a component to display the result, and a parent component of the two which is responsible for the calculations. (This representation also applies the idea of [presentational and container components](https://medium.com/@dan_abramov/smart-and-dumb-components-7ca2f9a7c7d0), where we have components to handle functionality and display separately). Of course, if we have this hierarchy, we end up needing to share state between two children components. This state is "lifted" to the parent component.

First, we can create a component for the result. This one should be rather simple, as it's a great candidate for a container component (also referred to as "dumb" or "pure"). Its only responsibility is to text based on three read-only values. We can pass these values in as props.

```javascript
import React from "react";

export default function ResultDisplay(props) {
  return (
    <p>
      {props.values.first && props.values.second
        ? `Result is: ${props.values.result}`
        : `Enter both numbers above for a value`}
    </p>
  );
}
```

Next, we can think about our parent component, which passes its values to the ResultDisplay component.

```javascript
import React, { useState } from "react";

export default function HypotenuseCalculator() {
  let [values, setValues] = useState({ first: 0, second: 0, result: 0 });

  const calculateResult = (e) => {
    const numInputs = {
      first: values.first,
      second: values.second,
      [e.target.name]: e.target.value,
    };

    const result = Math.sqrt(
      Math.pow(numInputs.first, 2) + Math.pow(numInputs.second, 2)
    );

    numInputs.result = Math.round(result * 100) / 100;

    setValues(numInputs);
  };

  return (
    <div>
      <h3>Calculator</h3>
      <div>
        Enter first side value:
        <input name="first" type="number" onChange={calculateResult} />
      </div>
      <div>
        Enter first side value:
        <input name="second" type="number" onChange={calculateResult} />
      </div>
      <ResultDisplay values={values}></ResultDisplay>
    </div>
  );
}
```

We're not yet done, as we want to refactor each input as a component. However, this component must behave a little differently. It cannot function properly if the state is handled in the same manner; we cannot just pass in `first` and `second` as props and expect them to be updated, as our props are read-only. What we can do, however, is pass down a function as a prop that is responsible for changing the parent state.

```javascript
import React from "react";

export default function SideInput(props) {
  return (
    <div>
      Enter {props.name} side value:
      <input name={props.name} type="number" onChange={props.onChange} />
    </div>
  );
}
```

The parent component becomes:

```javascript
import React, { useState } from "react";
import ResultDisplay from "./ResultDisplay";
import SideInput from "./SideInput";

export default function HypotenuseCalculator() {
  let [values, setValues] = useState({ first: 0, second: 0, result: 0 });

  const calculateResult = (e) => {
    const numInputs = {
      first: values.first,
      second: values.second,
      [e.target.name]: e.target.value,
    };

    const result = Math.sqrt(
      Math.pow(numInputs.first, 2) + Math.pow(numInputs.second, 2)
    );

    numInputs.result = Math.round(result * 100) / 100;

    setValues(numInputs);
  };

  return (
    <div>
      <h3>Calculator</h3>
      <SideInput name="first" onChange={calculateResult}></SideInput>
      <SideInput name="second" onChange={calculateResult}></SideInput>
      <ResultDisplay values={values}></ResultDisplay>
    </div>
  );
}
```

Because our numeric data is needed by two sibling components, "lifting" the state to a common parent component allows us to access this data in both. Any other shared data in our application would also need to be lifted to a common ancestor, most effectively, the closest common component in the hierarchy.

### Limitations of Lifting State

While the strategy of lifting state accomplished what we needed in the above example, this strategy gets difficult to manage as the need for shared data grows. In the context of the component hierarchy, the shared data in each of the child components is declared in the immediate parent. This makes managing this data relatively straightforward. However, think of this approach as the application scales. If the application has many components and two unrelated components require some of the same data, this data needs to be unnecessarily present in many components. The only common component may even be the root component. In this case, alternative approaches for sharing state, such as (Redux)[../07-redux] should be considered.
