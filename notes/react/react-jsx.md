## JSX

JSX stands for JavaScript XML and it allows you to write what looks like HTML inside of your JS code in React. Think of it as a convenient way of conceptualizing what your view will look like without having to leave your JS file. For example, the following element can be created using JSX in a regular JS file:

```JS
const myElement =(
  <div>
    <h1>Hello</h1>
    <p>Have a great day!</p>
  </div>
);
```

Here is equivalent JS for a situation where you wanted to create an element without JSX:

```JS
const myElement = React.createElement("div", null, React.createElement("h1", null, "Hello"),React.createElement("p", null, "Have a great day!"));
```

It is kind of like the concept of how you can either create an element using HTML, or by using the createElement() DOM function to achieve the same goal. In addition, JSX works by utilizing Babel to compile the JSX into regular ES5 or ES6 JavaScript before everything is rendered. Note that if you want to write any JS in JSX, you must enclose it in curly braces {}.

JSX will render each tag provided with an HTML element or with another component. This is determined based on the casing of the tag. HTML itself is not case sensitive, although it's good practice to always use lowercase. JSX is case sensitive, in that if the tag provided is capitalized, it will be rendered as a component, while if it's lowercase, it'll be rendered as an HTML element.

When using JSX, it's important to remember, that only one root tag can be returned from a component. This is the case because of the way React handles reconciling the DOM.

```javascript
const myElement = (
  <h1>Hello</h1>
  <p>Have a great day!</p>
);
```

- this element cannot be returned from a component

```javascript
const myElement = (
  <div>
    <h1>Hello</h1>
    <p>Have a great day!</p>
  </div>
);
```

- this element can be returned from a component

Because of this, there may be times where you need to wrap your JSX fragment in a `<div>` or a `<span>`. If you don't want to do this, React actually provides a React.fragment component which provides the ability to return multiple elements without any explicit wrapper element.

```javascript
const myElement = (
  <React.fragment>
    <h1>Hello</h1>
    <p>Have a great day!</p>
  </React.fragment>
);
```

### See Also:
 - [Introducing JSX](https://reactjs.org/docs/introducing-jsx.html)
 - [Babel compiling JSX to JS](https://babeljs.io/repl#?browsers=defaults%2C%20not%20ie%2011%2C%20not%20ie_mob%2011&build=&builtIns=false&spec=false&loose=false&code_lz=GYVwdgxgLglg9mABAQQA6oBQEoDeAoASACcBTKEIpAHgAsBGAPgAkSAbVuKgenobwF8gA&debug=false&forceAllTransforms=false&shippedProposals=false&circleciRepo=&evaluate=false&fileSize=false&timeTravel=false&sourceType=module&lineWrap=true&presets=env%2Creact%2Cenv&prettier=false&targets=&version=7.9.6&externalPlugins=)
