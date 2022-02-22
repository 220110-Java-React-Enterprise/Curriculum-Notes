# Routing in React
 - [React Router Tutorial](https://reactrouter.com/docs/en/v6/getting-started/tutorial#add-some-routes)

Despite an application being a SPA, we'll still want users to have the experience of navigating to different web pages. In order to accomplish this, we want different URI paths to correspond to different views, allowing React to swap out different components based on the desired URI.

A common misconception is that you React apps are SPA by default, but the truth is that it does not. There are multiple ways you can make your React application an SPA. The most popular way currently is to use `React Router`. After you have already created a react application (with `create-react-app`), you can follow these steps to set up a Single Page Application with React Router:



### Install React Router
`npm install react-router-dom@6 history@5`
This will add `react-router-dom` to your package.json dependencies.




## React Router

React Router is a declarative model for navigational components within your application. It provides support for web applications (react-router-dom) or applications using react native (react-router-native).

## React Router DOM

React Router DOM provides several solutions for creating a router in your application, depending on the relationship you want your UI to have with the URL.

The `BrowserRouter` uses the HTML5 history API to keep the UI in sync with the URL. We can wrap this tag around `Route` tags, where each `Route` represents a renderable component.

Note: In previous versoins of Reacr Router Dom the `<Switch>` element was used to nest `<Route>` elements, however this has changed to the `<Routes>` element. 
`<Switch></Switch>` -> `<Routes></Routes>`

```javascript
//index.js

import App from './App';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import First from "./components/first";
import Second from "./components/second";

ReactDOM.render(
    <BrowserRouter>
        <Routes>
            <Route path="/" element={<App />} >
                <Route path="first" element={<First />} />
                <Route path="second" element={<Second />} />
            </Route>
        </Routes>
    </BrowserRouter>,
  document.getElementById('root')
);
```
Here in index.js we define the routes. Each `<Route>` element contains a path attribute, which is the URI path that "navigates" to that component. These elements also contain an element attribute, which indicates the component which should be shown when we "navigate" to that path.


```javascript
//App.js

import './App.css';
import {Link, Outlet} from "react-router-dom";

export default function App() {
    return (
        <div>
            <h1>Test!</h1>
            <nav
                style={{
                    borderBottom: "solid 1px",
                    paddingBottom: "1rem"
                }}
            >
                <Link to="/first">First</Link>
                {" | "}
                <Link to="/second">Second</Link>
            </nav>
            <Outlet />
        </div>
    );
}
```
Here in App.js we have placed `<Link>` elements which can be clicked to "navigate" to that route. Note, when we say "navigate" we mean that React shows different components based on the URI. We are still operating in a single page application, but the browser behaves like we are navigating around many pages.


When using a `Route`, the corresponding component can be provided using nested children, like is seen in the example above. This is the recommended way, but you may also see a children, component, or render prop provided to a `Route`.

In the example above, `Routes` is used to assure that a single route is rendered exclusively. Without it, a request to "/new" would render both the NewItem component and the NotFound component. Other issues arise without using `Routes` when using parameterized routes and they are satisfied by static routes.

Once the Router is set up, we are able to link to these different URL's. The Link tag can then be used to refer to the URL. You may have `<Link to="/new">New</Link>` or `<Link to="/">Home</Link>` in your `Header` component.

# Additional Resources

- [React Router Docs](https://github.com/ReactTraining/react-router)
