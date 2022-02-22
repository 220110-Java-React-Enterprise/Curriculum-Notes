## One Way Data Flow

In React, data only moves in one direction. Each component is functional, meaning just like how a function is provided everything it needs to execute through its parameters, components are provided everything it should need to render based on its [props](../02-react-fundamentals/props-and-state.md). For a component to be parameterized it is passed read-only properties from a parent component.

However, things get a little more complicated when you want something in a child component to affect a parent component. Let's say, for example, you have components representing field inputs, and you have a disabled submission button. If you want the submission button to be enabled based on valid field input data, you'll need some way to indicate change to a parent component. We could have state held in your form component which represents whether or not the data is valid, but when we pass that state to the children, it would be done by passing read-only props. We must use another approach to accomplish this while still adhering to React's unidirectional data flow.

Just as parent's variables can be passed down to their children using props, so can parent functions. When we pass a parent component's functions to a child, it's used as a callback and can affect change in the parent function. Like any closure, the inner executing function has access to the variables declared in its own declared scope. For this reason, functions passed to child components from a parent component have access to parent variables, including their state. This allows us to modify state of a parent component, even though we are not able to manipulate the values through props directly.

Following the example mentioned earlier, we could have a `ValidatedForm` component with `ValidatedField` children components.

```javascript
import React from "react";

export default function ValidatedField(props) {
  return (
    <React.Fragment>
      <label>{props.name}:</label>
      <input
        name={props.name}
        type={props.type || "text"}
        onChange={props.onChange}
      ></input>
    </React.Fragment>
  );
}
```

```javascript
import React, { useState } from "react";
import ValidatedField from "./ValidatedField";

export default function ValidatedForm() {
  let [validOptions, setValidOptions] = useState({ name: false, age: false });

  const validateName = (e) => {
    if (e.target.value.length > 2) {
      setValidOptions({ age: validOptions.age, name: true });
    } else {
      setValidOptions({ age: validOptions.age, name: false });
    }
  };

  const validateAge = (e) => {
    if (e.target.value > 18 && e.target.value < 150) {
      setValidOptions({ name: validOptions.name, age: true });
    } else {
      setValidOptions({ name: validOptions.name, age: false });
    }
  };
  return (
    <form>
      <ValidatedField name="name" onChange={validateName}></ValidatedField>
      <ValidatedField name="age" onChange={validateAge}></ValidatedField>
      <button disabled={!validOptions.name && !validOptions.age}>Submit</button>
    </form>
  );
}
```

In this case, we could not modify `validOptions` in the `ValidatedField` component directly. Instead, we pass in the `validateName` and `validateAge` from the parent component to the child component. Then, when each field is changed, the callback function is executed in the scope of the parent function.
