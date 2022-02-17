# Variable Scope:


The Variable scope defines the lifetime and visibility of a variable. Each variable associated with a scope. The variable can be accessed only within its scope.

## Global Scope

Variables defined outside any function, block, or module have global scope. The global scope variables are accessed everywhere in the application.

Example:
```javascript
var a = 'Hello World!'; // This is a global variable
function greeting() {
    console.log(a);
}
greeting(); // Outputs 'Hello World!'
```

The global variable's lifetime is throughout the application.

Example:
```javascript
var app = {}; // A global object
app.foo = 'Homer';
app.bar = 'Marge';
function func() {
    console.log(app.foo);
}
func(); // Outputs 'Marge'
```

We can declare the global variables in a browser using the global `window` object.

Example:
```javascript
window.app= { value: 1 };
window.b = "Hello!!!"
```
### Local Scope
Local Scope used to refer to Function-local scope, but following the introduction of block scope, this term is considered ambiguous and should not be used. The local scope has divided into the function scope, the block scope and the lexical scope. The block scope concept is introduced in ECMA Script 6 (ES6) together with the new ways to declare variables - `const` and `let`.

## Function Scope

The variable declared in a function is only visible inside that function. `var` is the keyword to define variable for a function-scope accessibility. These variables cannot be accessed or modified.

```javascript
//global scope
function func1(){
    //functoin scope 1
    function func2(){
        //function scope 2
    }
}

//global scope
function func3(){
    //function scope 3
}

//global scope
```

Example:
```javascript
function func(){
    var animal ='Lion'; //exist in function scope
    console.log('inside function: ',animal);
}

func();                    //Output: "inside function: Lion"
console.log(animal);       //error: animal is not defined
```

##  Block Scope

Block scope is the scope of the variables declared inside the {} (curly brackets). In ES6, `const` and `let` keywords allow developers to declare variables in the block scope, which means those variables exist only within the corresponding block.

Example:
```javascript
function func(){
    if(true){
        var fruit1 = 'apple';        //exist in function scope
        const fruit2 = 'banana';     //exist in block scope
        let fruit3 = 'strawberry';   //exist in block scope

    }
    console.log(fruit1);
    console.log(fruit2);    // results error - due to it exist in block scope
    console.log(fruit3);    // results error - due to it exist in block scope
}

foo();
```
The result will be:
```
apple
error: fruit2 is not defined
error: fruit3 is not defined
```

## Lexical Scope

Lexical scope is that a variable defined outside a function can access the inside another function defined after the variable declaration. The inner functions are lexically bound to the execution context of their outer functions.

Example:
```javascript
function func1(){
    var animal1 = "Lion";   //exist in Lexical scope

    function func2(){    //Inner Function

        var animal2 = "Tiger"; //exist in function scope
        console.log(animal1);
        console.log(animal2);

    }
    func2();
    console.log(animal2); // results error - due to it exist in function scope
}

foo1();
```
The result will be:
```
Lion
Tiger
error: animal2 is not defined
```

### Hoisting

In JavaScript, variable declarations made with `var` and function declarations made with the `function` keyword are **hoisted** - or moved - to the top of the scope in which they are declared when the JavaScript interpreter parses the code. This means that variables and functions can be used **before they are even declared** as shown below.

```javascript
function example() {
  // var a declaration hoisted here
  a = 4;
  var a;
  a++;
  console.log(a); // prints 5
}
// anotherExample declaration hoisted to here
anotherExample(); // no error thrown!

function anotherExample() {
  console.log('it works!');
}

```

## strict mode

JavaScript is a loosely typed scripting language. JavaScript allows strictness of code by using `"use strict";` statement at the top of JavaScript code or in a function. 

For example, When we expect the compiler to give an error if we have used a variable before defining it, then we apply "strict mode" to the javascript code. 
```html
<!DOCTYPE html>
<html>
<body>
	<h1>strict mode</h1>
	
	<p id="errorMessage"></p>
	
	<script>
		"use strict";
		try
		{
			var x = 16; // valid in strict mode
			y = 10; // error
		}
		catch(ex)
		{
			document.getElementById("errorMessage").innerHTML = ex;
		}

    </script>
</body>
</html>
```

The output will be:
```
strict mode
ReferenceError: y is not defined
```

The strict mode in JavaScript does not allow us to use undefined variables, reserved keywords as variable or function name, duplicate properties of an object, duplicate parameters of the function, assign values to read-only properties, Modifying arguments object, and Deleting an undeletable property.

Example:
```html
<script>
try
{
	"use strict";

	x = 1; // error
	var for = 19; // error
	var break = 5; // error

	var person = { name: "John", name: "Ben" }; //error
	function divide(val, val){return val / val }; //error

	var arr = [1 ,2 ,3 ,4, 5];
	arr.length = 10; //error

}
catch(ex)
{
    document.getElementById("errorMessage").innerHTML = ex;
}
</script>
```

Strict mode can be applied to function level in order to implement strictness only in that particular function.

Example:
```javascript
x = 1; //valid

function sum(val1, val2){
    "use strict";

     result = val1 + val2; //error

    return result;
}
```

# Errors
Sometimes things go wrong. When things go wrong in JavaScript, the result usually involves the creation of an error object. There are two ways an error object can be created:
1) Runtime error: An error that is created as a result of something wrong with the code, such as a SyntaxError or ReferenceError.
2) User-defined error: An error built as part of your code to represent a problem that can occur.
Errors can have many fields depending on the implementation, however the standard defines an error as having a `name` and `message` field.

## Error Handling Statements
In order to work with an error, you need to utilize statements that will allow you to handle the error. There are two constructs we need to be aware of.

### try...catch
A `try` block allows you to execute code. If that code would cause an error to occur, code execution would switch to an attached `catch` block so that you can handle the error. The below example has us catch an error where we tried to access a variable that does not exist.

```JavaScript
try {
    let x = y; // y has not been declared
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```
Output:
```
ReferenceError
y is not defined
```
### `throw`
If you define your own error, you'll have to throw the error so that it can be handled. A `throw` statement causes the thrown object to be sent to an attached catch block. If there is no catch block, this will cause your code to cease execution entirely.

_Note_: You can throw anything, not just an error. However, when people look at your code and see that you threw the string "hello", they will not have any idea why you did that. Other people will expect you to be throwing errors.

```JavaScript
try {
    throw new Error('Something bad happened!');
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```
Output:
```
Error
Something bad happened!
```
## Custom Errors
If you're going to be throwing your own errors, it would be best to make your own error object, so that it has a descriptive name.

### Prototype
```JavaScript
function MyError(message) {
    this.name = 'MyError';
    this.message = message;
}
MyError.prototype = new Error;
try {
    throw new MyError('My message');
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```
### Class
```JavaScript
class MyError extends Error {
    constructor(message) {
        super(message);
        this.name = 'MyError';
    }
}
try {
    throw new MyError('My message');
} catch(error) {
    console.log(error.name);
    console.log(error.message);
}
```

# Timing Events

In JavaScript we make use of timing events when we are looking to automate tasks or run tasks after waiting a specific length. There are two key timing event methods in JavaScript and both are functions of the `window` object. These methods are `setTimeout()` and `setInterval()`.

## setTimeout
The `setTimeout()` function has the following signature:

```window.setTimeout(callbackFunction, milliseconds)```

This function executes the given callback function after waiting a specified number of milliseconds.

Example:

`index.html`
```
<html>
<body>
<div id="myDiv" style="background-color:grey">
Welcome to Timing Events.
<button id="myButton">Click Me</button>
</div>
<script src="index.js"></script>
</body>
</html>
```

`index.js`
```
// Global variable representing the current color of the div
let color = 'grey'

window.onload = () => {
	// Set the initial color of the div
	document.getElementById('myDiv').style.backgroundColor = color
	document.getElementById('myButton').onclick = waitForLoading
}

// This function will change the button text to "Loading..."
// and then swap the background color of the div from grey to green or vice versa.
function waitForLoading() {
	console.log('Loading...')
	document.getElementById('myButton').innerHTML = 'Loading...'
	// Wait two seconds and then change color
	setTimeout(changeColor, 2000)
}

// This function switches the color of the div
function changeColor() {
	document.getElementById('myButton').innerHTML = 'Click Me'
	
	color = color == 'grey' ? 'green' : 'grey'
	
	document.getElementById('myDiv').style.backgroundColor = color
}
```

In the above example, if the user clicks the button and waits two seconds, the color of the div changes from grey to green. If they press the button a second time, it will wait two seconds and then change back.

### Canceling Timeouts
If you are waiting on a `setTimeout()` to execute and then change your mind, you can do so with the `clearTimeout()` function. This function has the following signature:

```window.clearTimeout(timeoutVariable)```

If the callback function has not been executed when clearTimeout is called, the execution will be cancelled. For this to work, however, we need the `timeoutVariable`, which is the return value of the `setTimeout()` function.

Example:
`index.html`
```
<html>
<body>
<div id="myDiv" style="background-color:grey">
Welcome to Timing Events.
<button id="myButton">Click Me</button>
</div>	
<script src="index.js"></script>
</body>
</html>
```

`index.js`
```
// Global variable representing the current color of the div
let color = 'grey'
// Global variable representing the button so we don't have to select it every time.
let myButton = document.getElementById('myButton')

window.onload = () => {
	// Set the initial color of the div
	document.getElementById('myDiv').style.backgroundColor = color
	myButton.onclick = waitForLoading
}

// This function will change the button text to "Loading..."
// and then swap the background color of the div from grey to green or vice versa.
function waitForLoading() {
	console.log('Loading...')
	myButton.innerHTML = 'Cancel!'
	myButton.onclick = cancelTimeout
	// Wait two seconds and then change color
	let timeout = setTimeout(changeColor, 2000)
	
	function cancelTimeout() {
		console.log('Cancel the color change')
		clearTimeout(timeout)
		myButton.innerHTML = 'Click Me'
		myButton.onclick = waitForLoading
	}
}

// This function switches the color of the div
function changeColor() {
	myButton.innerHTML = 'Click Me'
	myButton.onclick = waitForLoading
	
	color = color == 'grey' ? 'green' : 'grey'
	
	document.getElementById('myDiv').style.backgroundColor = color
}
```

The above example is almost identical to the previous example, except that if the user clicks the button again prior to the color changing, we will cancel the color change. The user is then free to try to change the color again.

## SetInterval
What if instead of needing to wait a specific time before executing a function once, we actually needed to execute a function every few seconds? This is where `setInterval()` comes in. It has the following signature:

```window.setInterval(callbackFunction, milliseconds)```

`setInterval()` will execute it's callback repeatedly with an *interval* or pause in milliseconds between executions. Like `setTimeout()`, if we wish to cancel the execution, we can use the function `clearInterval()`.

```window.clearInterval(intervalVariable)```

Example:

`index.html`
```
<html>
<body>
<div id="myDiv" style="background-color:grey">
<h1 id="time">0:00</h1>
<button id="start">Start</button>
<button id="stop">Stop</button>
</div>
<script src="index.js"></script>
</body>
</html>
```

`index.js`
```
let seconds = 0
// declare the intervalVariable for later use.
let intervalVariable = null

window.onload = () => {
	// Set the initial color of the div
	document.getElementById('start').onclick = start
	document.getElementById('stop').onclick = stop
}

// This function will create the interval
function start() {
	seconds = 0
	document.getElementById('time').innerHTML = '0:00'
	intervalVariable = setInterval(tickUp, 1000)
}

// This function will iterate the timer.
function tickUp() {
	seconds = seconds + 1
	timer = `${Math.floor(seconds/60)}:${new String(seconds%60).padStart(2, '0')}`
	document.getElementById('time').innerHTML = timer
}

// This function clears the interval
function stop() {
	clearInterval(intervalVariable)
}
```

In this example, the user is operating a simple stopwatch. It ticks up the stopwatch every second, until the user hits the stop button.
