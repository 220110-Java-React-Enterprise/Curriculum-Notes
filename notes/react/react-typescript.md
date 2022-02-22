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
