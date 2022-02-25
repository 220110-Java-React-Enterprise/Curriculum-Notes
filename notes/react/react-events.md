# Events in React

Handling events is syntactically similar to handling events with inline HTML. When using JSX, however, event names use camelCase, rather than lowercase, and the event handler is passed in as a JavaScript reference rather than just a string.

```javascript
const MyButton = () => {
  const doSomething = () => {
    // event functionality
  };

  return <button onClick={doSomething}>Click me to do the thing!</button>;
};
```

In HTML, the equivalent would be:

```HTML
<button onclick="doSomething()">
  Click me to do the thing!
</button>
```

For more on React events see React's ["handling events" docs](https://reactjs.org/docs/handling-events.html).

## Passing Event Handlers as Props

Generally you cannot modify state in a parent component, but by passing an event handler into a child component, the handler method has access to the parent's state. This behavior is similar to that of a closure. More on this in the [Lifting State](./state-lifting.md) section.

## Synthetic Events

A SyntheticEvent is a cross-browser wrapper around the browser’s native event. When an event occurs in React, this wrapper is used rather than just a normal JavaScript event. It has the same interface as a browser's native event, but using SyntheticEvent allows for additional benefits such as event pooling. This means that SyntheticEvent objects will be reused to improve the performance of the application. However, this can cause issues if events are intended to be handled asynchronously, because once a callback is called, all of the properties of the event are nullified. In this case the persist() method can be used to remove the event from the pool.
