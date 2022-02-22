## High Order Components

High order components are functions that take a component and return a new component. The traditional component model transforms props into a portion of the UI. High order components take a component as a parameter and transforms it, returning a new component with added functionality. The idea is based on the idea of a high-order function in JavaScript, where a function is taken as an argument, and another function is returned.

High order components can handle cross cutting concerns and allow for even more reusability. [Composition](https://reactjs.org/docs/composition-vs-inheritance.html) is used to wrap a component in a container component.

HOCs add features to a component. Examples can be seen when using withRouter in [React Router](../02-react-fundamentals/routing.md) and when using connect with [Redux](../07-redux).

With React Router, you can use the withRouter high-order component to provide your component with additional routing functionality. By passing in your component, you are able to use the history API, through the history object provided as a prop. The HTML history API gives you access to browser navigation history via JavaScript.

You can also create your own high-order components. A high-order component can be created to handle cross cutting concerns, such as authentication, by creating a function which wraps your component with auth logic.

```javascript
import React from "react";

export default function withAuth(Component) {
  return function AuthenticatedComponent(props) {
      isAuthenticated(){
          //returns true or false based on some auth logic
      }

    if (isAuthenticated()) {
      return <Component {...props}></Component>
    } else {
      return <div> Please login to access the application </div>;
    }
  };
}
```

You can then use your HOC to wrap any component with its functionality.

```javascript
import React from "react";
import withAuth from "./withAuth";

function TestComponent() {
  return <p>Hello World</p>;
}

export default withAuth(TestComponent);
```

You could also create HOCs that provide your components with a particular styling, that pass in certain props, or handle any other common compositional concern.

Additional Resources:

- [Higher-Order Components React Docs](https://reactjs.org/docs/higher-order-components.html)
- [Higher-Order Components In React Blog Post](https://www.smashingmagazine.com/2020/06/higher-order-components-react/)
