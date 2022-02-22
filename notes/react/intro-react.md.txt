# React Overview

React is a JavaScript **library** that was created in 2011 by Facebook for the purpose of creating front end user interfaces for web applications. React by itself is very small and lightweight. It is meant to be used in conjunction with other modules such as **React Router** and **Redux**. This gives developers a lot of freedom and options in how they want to go about assembling the tools that they need to develop UIs. While it is primarily used to make front-ends for web applications, React theoretically has other use cases. You can also use React to help build static websites, mobile applications (using React Native), desktop applications, and Virtual Reality (React VR).

React uses a [component based architecture](../02-react-fundamentals/components-and-lifecycle.md) making front end applications much more modular and maintainable. React also uses a virtual dom, rendering elements on the page much more efficiently than direct DOM manipulation.

- [React Docs](https://reactjs.org/)
- [Why React is taking over front-end](https://jscomplete.com/learn/why-react)

## "Not a Framework"

Technically, React is a _library_ and not a _framework_. How is not being a framework a good thing? A framework is usually an entity that takes your code and executes a lot of abstracted away processes. Typically, frameworks offer limited flexibility because they do things in their own way and they expect the developer to closely conform to the intended way of doing things. As a consequence, they run the risk of being very large and full of features. In some cases, you are forced to use the entire thing, and sometimes, they can be hard to customize. This can be cumbersome, if you only wanted to use a small piece of the framework without having to use the whole thing. React is "not a framework" because it it small and is really only designed to do one thing: enable users to declaratively describe their user interfaces (and model the state of these interfaces). This is one of the main ways that React differs from other popular frameworks that are used for web development (Angular, Vue, Ember, etc.). You will find that React was ground-breaking because its approach to web development was so fundamentally different from other solutions.

## Tradeoffs

React is a Library, not a framework. This means that it doesn't get to benefit from the opinionated nature of frameworks that make it easier to make less choices and set up the application. React trades conciseness for a more explicit approach to web development. Rather than allowing a framework to hook everything up for you, you wire everything explicitly with React. Another tradeoff is that rather than simply using templates like in more traditional front-end frameworks, React is basically "using html in your JS". This does require you to understand JS to a greater depth than with other frameworks. React's components structure doesn't follow the traditional MVC file separation of other frameworks. All of the data regarding a component is in the same file. React does follow the principle of "Separation of Concerns", but rather than doing so by separating HTML,CSS,JS, it separates them based on component functionality.

## Downsides to React

In the interest of fairness, here are some of the major downsides to React: JSX differs from HTML, the inclusion of a build step, potential version conflicts, old features of React in searches, decision fatigue. JSX is mostly similar to HTML, but there are a few differences such as having to use "className" instead of "class" (remember that `class` is a keyword in JS). Nowadays, most methods of creating front-end clients have some learning curve, unless you are using vanilla HTML, CSS, JS. Also, because React versioning is updated frequently, version changes and forward compatibility need to taken into account. Since React is a popular tool, there are a lot of posts online, regarding React, which might also mean that you will have a hard time distinguishing which methods are relevant now and which ones are outdated. Finally, the fact that React is so flexible results in a lot of decision fatigue. There are a lot of choices you have to make, which usually falls into the these categories: Dev Environment, Classes or Functional components, Types, State, Styling.

## Creating a new React Application

There are many ways of setting up your environment to start writing a UI with React. The simplest and most popular way is to use `create-react-app`:

> npx create-react-app "name-of-react-application"

or if you install create-react-app globally,

> create-react-app "name-of-react-application"

This will generate a new React application that comes preconfigured with dependencies such as: babel, webpack, jest, etc.

Note that this is a shortcut and you could always manually set up your dev environment if you wanted to.

- [create-react-app](https://create-react-app.dev/docs/getting-started)

# More resources

- [Practice React on CodePen](https://codepen.io/pen?&editable=true&editors=0010)
