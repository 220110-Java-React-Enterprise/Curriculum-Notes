# JSX

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
There is also a shorthand for React fragments, you can simply use empty tags `<>`, `</>`.

## JS in JSX
You can embed any valid JavaScript expression in your JSX using `{`curly braces`}`. In the example below, we embed the result of calling a JavaScript function, formatName(user), into an `<h1>` element:

```javascript
function formatName(user) {
  return user.firstName + ' ' + user.lastName;
}

const user = {
  firstName: 'Harper',
  lastName: 'Perez'
};

const element = (
  <h1>
    Hello, {formatName(user)}!
  </h1>
);

ReactDOM.render(
  element,
  document.getElementById('root')
);
```


# Using TypeScript with React

React offers the flexibility to use either JavaScript and TypeScript to build components. If you create your own React environment, you may need to make additional consideration in your bootstrapping process. However, frameworks like Create React App support TypeScript out of the box.

Being a typed superset of JavaScript, TypeScript can catch errors and bugs at build time, before they would have been otherwise.

## Integrating

In order to add TypeScript, it needs to first be a dependency of your application. Once compiler options are configured, you can add definitions for libraries you're using in our application, and include them in .tsx files.

If you're using Create React App, you can either initialize your application with the template flag `--template typescript`, or to add to an existing Create React App first install it

```
npm install --save typescript @types/node @types/react @types/react-dom @types/jest
```

From here, create your TypeScript config using

```
npx tsc --init
```

Set any necessary config options and then convert your .js files to .tsx files. You'll probably want to set the `rootDir` property to a src folder, and the `outDir` to a build folder. This tells TypeScript which directory to build from and which directory to build to.

If you're using a development environment other than Create React App, you can find the steps to incorporating TypeScript [here](https://reactjs.org/docs/static-type-checking.html#adding-typescript-to-a-project).

## Using Type Definitions

Type definitions for common libraries are generally available through DefinitelyTyped, a crowd-sourced project by Microsoft and open source contributors. Although, React does not define its own types, we can pull in the necessary types from DefinitelyTyped. Because these types do not persist beyond the development mode, as jsx and TypeScript need both be transpiled into JavaScript to run in the browser, we install types as dev dependencies.

```
npm i --save-dev @types/react
```

If you are working with packages which have not been already typed, you can define local declarations in a declarations.d.ts. This file would be in the root of your source directory and would define a module including all of the relevant types.

From there, you can start using TypeScript types in your React components like so:

```javascript
import * as React from "react";

const Count: React.FunctionComponent<{
  count: number,
}> = (props) => {
  return <h1>{props.count}</h1>;
};

export default Count;
```



- [JSX according to React Docs](https://reactjs.org/docs/introducing-jsx.html)
- [Babel compiling JSX to JS](https://babeljs.io/repl#?browsers=defaults%2C%20not%20ie%2011%2C%20not%20ie_mob%2011&build=&builtIns=false&spec=false&loose=false&code_lz=GYVwdgxgLglg9mABAQQA6oBQEoDeAoASACcBTKEIpAHgAsBGAPgAkSAbVuKgenobwF8gA&debug=false&forceAllTransforms=false&shippedProposals=false&circleciRepo=&evaluate=false&fileSize=false&timeTravel=false&sourceType=module&lineWrap=true&presets=env%2Creact%2Cenv&prettier=false&targets=&version=7.9.6&externalPlugins=)
