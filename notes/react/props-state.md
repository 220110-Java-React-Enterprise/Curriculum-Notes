# Intro to Props and State

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

- [React Components and Props](https://reactjs.org/docs/components-and-props.html)

## State

If there was a situation where you wanted to change data that is being used, you would use **state**. You can set state in class components by either using a constructor or by declaring a field called 'state' inside of the class. In general, you do not mutate state directly. To change state in a class component, you would use `this.setState()`.

If you wanted to use state inside of a functional component, you would need to use hooks. To mutate state, you would need to use the mutator function that you declare while using the hook.

- [State and Lifecycle](https://reactjs.org/docs/state-and-lifecycle.)
- [Using the state hook](https://reactjs.org/docs/hooks-state.html)
