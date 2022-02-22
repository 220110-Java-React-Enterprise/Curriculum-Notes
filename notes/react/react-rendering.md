# Rendering Elements on the DOM

With traditional JavaScript and HTML, we need a base HTML file and we may have elements we can dynamically create using JavaScript. This rendering process still holds true for React. In fact, we'll still need to use a document element selector method at least once to access an element in our HTML file to insert our React components.

```javascript
function HelloWorld() {
  return <h2>Hello World!</h2>;
}
ReactDom.render(<HelloWorld />, document.getElementById("root"));
```

When we create a SPA, this render method need only be invoked once. Otherwise we nest components within each other and use a [router]()
to navigate between them.

## Conditional Rendering

In React, you can create several different components and then only render the components that you want the user to see. It is similar to conditional rendering with plain JS. Because the template for each component is returned in the scope of a function (either a functional component or the render method), you can include any rendering logic you'd like. With conditional rendering, the state of your application determines whether components render.

- [More](https://reactjs.org/docs/conditional-rendering.html) on conditional rendering

## Virtual DOM

React uses a Virtual DOM. Technically, with React, you don't actually write HTML. Instead, you generate HTML views using JS. For every DOM object, react has a corresponding "virtual DOM object" that represents the actual DOM object.

Why is using a Virtual DOM useful? Updating the DOM is costly in terms of performance. React greatly improves performance by minimizing changes to the DOM - it only updates what's necessary. The Virtual DOM much more lightweight than the actual DOM, so the virtual DOM is updated whenever we make a change, but React will decide when it is most efficient to actually make the real DOM reflect the changes seen in the Virtual DOM. Since rendering the page is costly (performance wise), minimizing unnecessary renders is one way that React improves performance. This update process is referred to as reconciliation, and you can read more about it [here](https://reactjs.org/docs/reconciliation.html).

- [React Docs - Virtual DOM](https://reactjs.org/docs/faq-internals.html)
- [React:The Virtual DOM](https://www.codecademy.com/articles/react-virtual-dom)
