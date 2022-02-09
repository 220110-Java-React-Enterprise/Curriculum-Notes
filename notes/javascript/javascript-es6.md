# ES6 Template Literals

Template literals are a new feature introduced in ECMAScript 2015/ ES6. It provides an easy way to create multiline strings and perform string interpolation. Template literals are the string literals and allow embedded expressions.

Template literals are strings that enclosed within the backtick character``(`)``. Template literals allow for embedded expressions (placeholders), which are indicated by the dollar sign and curly braces (`$(expression}`). These expressions can be used to evaluate code. 

**Syntax**: `` var str = `string value` ``

## Multiline strings

We use the escape character, represented as `\n`, to give a new line for creating a multiline string. In Template Literals, there is no need to add `\n `at the end when the string enclosed within the backtick (`` ` ``) character. Template literals used to create the new line by literally moving a string to a new line without using any character.

**Example:**
```javascript
console.log(`I am the first line
     I am the second line
      I am the third line`);
```

**Output:**
```javascript
I am the first line
I am the second line
I am the third line
```

## String Interpolation

In JavaScript, the template literals give support for string interpolation. Template literals perform string interpolation using embedded expressions, `${}`, which are replaced with the value of the code within it.

**Example:**
```javascript
function sayHello(){
    return "Hello World!!!"
}
var x = 10;  
var y = 20;  
document.write(`${sayHello()}, The product of the variables ${x} and ${y} are
 ${x*y}`);  
```

**Output on the console:**
```
Hello World!!!, The product of the variables 10 and 20 are 200.
```

## Tagged templates:

Tagged templates are one feature provided by ES6.  Tagged templates allow us to parse template literals with a function.

The following is a tagged template:

`` tagFunction`Hello ${firstName} ${lastName}!` ``

Putting a template literal after an expression triggers a function call, similar to how a parameter list triggers a function call. 

The above code is equivalent to the following function call:

`tagFunction(['Hello ', ' ', '!'], firstName, lastName)`

Thus, the name before the content in backticks is the name of a function to call, the tag function. The first argument of the tag function contains an array having string values, like `['Hello ', ' ', '!']` in the above tag Function. The remaining arguments are substitutions delimited by `${}`, such as `firstName` and `lastName` in the above tag Function.

**Example:**
```javascript
function printAll(literalArray, operator1, operator2, result){
 console.log(literalArray);
 console.log(operator1);
 console.log(operator2);
 console.log(result);
}
a = 3;
b = 4;
printAll `Addition:  ${a} + ${b} = ${a+b}`;
```

**Output on the console:**
```
(4) ["Addition:  ", " + ", " = ", "", raw: Array(4)]
3
4
7
```

## Raw Strings

The template literal raw method allows the accessing of raw strings as they were entered.

The `String.raw()` is a built-in function which accepts a string literal argument and returns raw string. It returns the strings without any interpretation of backslashed characters.

**Example:**
```javascript
var a =3;
var b =4;
var myString = String.raw`sum:\n ${a+b}`;
console.log(myString);
```

**Output on the console:**
```
sum:\n 7
```

The `raw` is a special built-in property which can be used on the first function argument of tagged templates. This allows us to access the raw strings as they were entered.

**Example:**
```javascript
function indexTest(literalArray){
 console.log(literalArray.raw[0]);
 console.log(literalArray[0]);
}
indexTest `"finding \n errors"`;
```

**Output on the console:**
```
"finding \n errors"
"finding 
 errors"
```

## Promises

Promises are used to handle asynchronous operations in JavaScript.

The constructor syntax for a promise object is:
```
let promise = new Promise(function(resolve, reject) {
  // executor (the producing code, "singer")
});
```

The function passed to `new Promise` is called the **executor**. When a `promise` object is created, the executor runs automatically. It contains the code which produces the result. The arguments `resolve` and `reject` are callbacks.

When the executor obtains the result, it should call one of these callbacks:

* `resolve(value)` — if the job finished successfully, with the result `value`.
* `reject(error)` — if an error occurred, the error is the `error` object.


The `Promise.status` property, gives information about the state of the `Promise` object. The promise object can have three states: **pending**, **fulfilled**, and **rejected**.

A Promise object connects the executor and the consuming functions  which will receive the result or error. Consuming functions can be registered using methods `.then`, `.catch` and `.finally`.

**Example:**
```javascript
var promise = new Promise(function(resolve, reject) { 
  const x = 5; 
  const y = 3;
  if(x >= y) { 
    resolve(); 
  } else { 
    reject(); 
  } 
}); 
  
promise. 
    then(function () { 
        console.log('Sucess! x have grater value'); 
    }). 
    catch(function () { 
        console.log('Error'); 
    }); 
```

# async and await keyword

Async and Await are extensions of promises.

**async** -An async function is a function that operates asynchronously via the event loop, returns a Promise object implicitly. `async` ensures that the function returns a `promise`.

**await** - The `await` keyword is only valid inside `async` functions. `await` makes JavaScript wait until that promise settles and returns its result.

*Example:*  Returns a promise object
```javascript
async function asyncFunc() {
  let response = await fetch(protectedUrl);
  let text = await response.text(); // response body consumed
  document.write(text);
}

asyncFunc();
```
