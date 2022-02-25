# Routing in React

Despite an application being a SPA, we'll still want users to have the experience of navigating to different web pages. In order to accomplish this, we want different URI paths to correspond to different views, allowing React to swap out different components based on the desired URI.

A common misconception is that you React apps are SPA by default, but the truth is that it does not. There are multiple ways you can make your React application an SPA. The most popular way currently is to use `React Router`. After you have already created a react application (with `create-react-app`), you can follow these steps to set up a Single Page Application with React Router:

## React Router

React Router is a declarative model for navigational components within your application. It provides support for web applications (react-router-dom) or applications using react native (react-router-native).

## React Router DOM

React Router DOM provides several solutions for creating a router in your application, depending on the relationship you want your UI to have with the URL.

The `BrowserRouter` uses the HTML5 history API to keep the UI in sync with the URL. We can wrap this tag around `Route` tags, where each `Route` represents a renderable component.

```javascript
import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Router>
        <Switch>
          <Route path="/" exact></Route>
          <Route path="/directory" exact>
            <ItemDirectory></ItemDirectory>
          </Route>
          <Route path="/new" exact>
            <NewItem></NewItem>
          </Route>
          <Route>
            <NotFound></NotFound>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}
```

When using a `Route`, the corresponding component can be provided using nested children, like is seen in the example above. This is the recommended way, but you may also see a children, component, or render prop provided to a `Route`.

In the example above, `Switch` is used to assure that a single route is rendered exclusively. Without it, a request to "/new" would render both the NewItem component and the NotFound component. Other issues arise without using a `Switch` when using parameterized routes and they are satisfied by static routes.

Once the Router is set up, we are able to link to these different URL's. The Link tag can then be used to refer to the URL. You may have `<Link to="/new">New</Link>` or `<Link to="/">Home</Link>` in your `Header` component.



## React-router-dom V6
The new version 6 of react-router-dom has more features and slightly different syntax. Instead of `<Switch>` we use `<Routes>` and instead of nesting the component to display inside `<Route>` tags, the component is included in the `<Route>` tag as an attribute called `element`.

```javascript
import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path="/" exact />
          <Route path="/directory" exact element={<ItemDirectory />} />
          <Route path="/new" exact element={<NewItem />} />
          <Route element={<NotFound />} />
        </Routes>
      </Router>
    </div>
  );
}
```

# Additional Resources

- [React Router Docs](https://github.com/ReactTraining/react-router)
