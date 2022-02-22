# Props and State
- [React Components and Props](https://reactjs.org/docs/components-and-props.html)
- [State and Lifecycle](https://reactjs.org/docs/state-and-lifecycle.)
- [Using the state hook](https://reactjs.org/docs/hooks-state.html)

## Props

In React, components can be nested in other components (often referred to as parent and child components). **Props** are passed from parent to child. For example here is a Kangaroo component that had a child component called Joey:

```JS
function Kangaroo(props){
    return (
        <div>
            <h3>I am a kangaroo and I have a child called 'Joey'</h3>
            <Joey secret="property to be passed..."/> {/*The parent Kangaroo Component is passing a prop called 'secret' to its child, Joey*/}
        </div>
    );
}
```

```JS
function Joey(props){
    return(
        <div>
            {props.secret /*this evaluates to 'property to be passed...'*/}
        </div>
    )

}
```

Joey is receiving a prop called 'secret' with a value 'property to be passed...' from its parent, Kangaroo. In React, props are immutable, and cannot be changed by the child.



## State

If there was a situation where you wanted to change data that is being used, you would use **state**. You can set state in class components by either using a constructor or by declaring a field called 'state' inside of the class. In general, you do not mutate state directly. To change state in a class component, you would use `this.setState()`.

If you wanted to use state inside of a functional component, you would need to use hooks. To mutate state, you would need to use the mutator function that you declare while using the hook.

## Immutability

State is defined either by declaring a property of this.state (class components) or by defining state using a lifecycle hook (function components). In either case, you should never be mutating state directly. This value, while able to be changed, should only ever be done so by the appropriate mutator.

_Mutating State in Function Based Components_

```javascript
import React, { useState } from "react";

const TodoList = () => {
  let [items, setItems] = useState([
    /*some items*/
  ]);

  let count = 0;

  const addItem = () => {
    setItems([
      ...items,
      { id: ++count, value: "new item" },
    ]); /* new item here is arbitrary*/
  };

  return (
    <div>
      <button onClick={addItem}>Add Item</button>
      <ul>
        {items.map((item) => (
          <li key={item.id}>{item.value}</li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
```


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

### Limitations of Lifting State

While the strategy of lifting state accomplished what we needed in the above example, this strategy gets difficult to manage as the need for shared data grows. In the context of the component hierarchy, the shared data in each of the child components is declared in the immediate parent. This makes managing this data relatively straightforward. However, think of this approach as the application scales. If the application has many components and two unrelated components require some of the same data, this data needs to be unnecessarily present in many components. The only common component may even be the root component. In this case, alternative approaches for sharing state, such as Redux should be considered.
