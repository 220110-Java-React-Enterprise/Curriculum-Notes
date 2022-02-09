### Encapsulation via Closures

Encapsulation means hiding information or data.The simplest a way to create encapsulation in JavaScript is using closures. A closure can be created as a function with private state. When creating many closures sharing the same private state, we create an object.

**Example:**
```javascript
const Book = function(t, a) {
   let title = t; 
   let author = a; 
   
   return {
      summary : function() { 
        console.log(`${title} written by ${author}.`);
      } 
   }
}
const book1 = new Book('Hippie', 'Paulo Coelho');
book1.summary(); // Returns Hippie written by Paulo Coelho.
```

### Prototypical inheritance

Object Prototypes (`__proto__` )-  All JavaScript objects have a prototype. Browsers implement prototypes through the `__proto__` property.

Function prototypes (`prototype` )  - In JavaScript, all functions are also objects, which means that they can have properties.Any time you create a function, it will automatically have a property called `prototype`.Thus, Functions also have a `prototype` property.

When we call a function with new, it sets the returned object’s `__proto__` property equal to the function’s `prototype` property. This is the key to inheritance.

Inheritance in JavaScript is implemented through the **prototype chain**. Every normally created object, array, and function has a prototype chain of `__proto__` properties ending with `Object.prototype` at the top.

**Example:** Here, we can say that "animal is the prototype of rabbit" or "rabbit prototypically inherits from animal". The animal properties and methods are  become automatically available in rabbit. Such properties are called “inherited”.
```javascript
let animal = {
  eats: true
walk() {
    alert("Animal walk");
  }
};
let rabbit = {
  jumps: true
  __proto__: animal	// sets animal to be a prototype of rabbit.
};

// we can find both properties in rabbit now:
alert( rabbit.eats ); // true 
alert( rabbit.jumps ); // true
// walk is taken from the prototype
rabbit.walk(); // Animal walk
```

In the above example, when alert tries to read property `rabbit.eats`, it’s not in rabbit but JavaScript follows the prototype reference and finds it in animal.Also the `walk()` method is automatically taken from the prototype.



## JavaScript this keyword

The `this` keyword is a reference variable that refers to the current object.


* **`this` alone**: refers to a global Object.

Example:
```javascript
var x = this;
``` 

* **`this` in function**: refers to the Global object [object Window].

Example:
```javascript
function myFunction() {
  return this;
}
```

* **`this` in `strict` mode**:  

Example:
```javascript
"use strict";
var x = this; //Here, this refers to the Global object [object Window]

"use strict";
function myFunction() {
  return this; //Here,  this is undefined.
}
```

* **`this` in Event Handlers**: refers to the HTML element that received the event

Example:
```html
<button onclick="this.style.backgroundColor= 'green'">
    Click Me!
</button>
```

* **`this` in Object Method Binding**: refers to the object. In the below example, `this` refers to people object.

Example:
```javascript
let people = function(name, age) { 
         this.name = name; 
         this.age = age; 
  
    this.displayInfo = function() { 
       document.write(this.name + " is " + this.age + " years old"); 
      } 
    } 
```

* **The call() and apply() method**: allows us to write a method that can be used on different objects. Here, person1 object writes its fullName function on person2 object using call() method

Example:
```javascript
var person1 = {
  fullName: function() {
    return this.firstName + " " + this.lastName;
  }
}
var person2 = {
  firstName:"John",
  lastName: "Wilson",
}
document.write("Hello, "+ person1.fullName.call(person2));
```


## Arrays

An array is a variable that allows the programmer to store more than one value. Arrays in JavaScript are objects and thus consist of key/value pairs and inherit from the Array prototype. Like objects, array values can consist of JavaScript primitives, or other JavaScript objects, including arrays and functions.

### Creating an Array
In JavaScript, arrays can be created using square brackets, using what is known as an array literal. They can also be created using the ```new``` keyword, but it is best practice to use array literals.
```html
// array literal
let cheeses = ['bleu', 'cheddar', 'parmesan', 'brie']
// ["bleu", "cheddar", "parmesan", "brie"]
// new keyword
let primes = new Array(2, 3, 5, 7, 11, 13)
// [2, 3, 5, 7, 11, 13]
```

Both methods create an array object based on the Array Prototype.

### Array Structure
All array objects share a common structure. Each array has a `length` field that stores the current length of the array. In addition, the prototype of an array is `[]`, giving each array access to certain functions that we will cover later.

```html
let array = [1, 2, 3]
console.log(array.length) // 3
console.log(array.__proto__) // []
```

#### Accessing an Array

Arrays in JavaScript are **zero-indexed**, meaning that the first element in an array is represented by the key `0`. In order to access our array, we can use Array Notation:

```javascript
let cheeses = ['bleu', 'cheddar', 'parmesan', 'brie']
console.log(cheeses[0]) // bleu
```
Here, we gave the zero-index to obtain the first element in the array, which is the string `bleu`. The string `cheddar` would be represented by the key `1`, `parmesan` would be `2`, and `brie` would be `3`. The length of the array is `4`. The last key of an array is normally `array.length - 1`, however, be aware that there might not be data at this location.

```javascript
//access the last element of the array
console.log(cheeses[cheeses.length-1])
```

#### Modifying an Array

You can also assign a different value by using the index and an assignment operator.

```javascript
cheeses[2] = 'american' // changes parmesan to american
```

**Changing the Array Length** - JavaScript is a dynamic language and arrays are no different. the length of an array can be changed in several ways.

**Adding an Item** - To add an item to an array you can specify an index

```javascript
// create an empty array
let arr = []
console.log(arr.length) // 0
// add an element at a specific index
arr[0] = 'duck'
console.log(arr.length) // 1
console.log(arr) // ["duck"]

arr[3] = 'chicken'
console.log(arr.length) // 4
console.log(arr) // [ "duck", <2 empty slots>, "chicken"]
```
In the above example, we first added the string `duck` to an empty array, changing the length of that array from 1 to 0. Note however, that this can be dangerous, as we can specify any index we wish. We then added the string `chicken` at index 3, changing the length of our array to 4, with two empty indexes. One way around this would be to use the `length` field to determine what the next index should be.

```javascript
arr[arr.length] = 'pigeon'
console.log(arr.length) // 5
console.log(arr) // [ "duck", <2 empty slots>, "chicken", "pigeon"]
```

An easier and safer way to add a new element to an array is the `push()` method inherited from the Array Prototype.

```javascript
let students = []
students.push('Timothy')
students.push('Zach')
console.log(students.length) // 2
console.log(students) // ["Timothy", "Zach"]
```

**Removing an Item** - Removing an item from an array in JavaScript can result in unexpected behavior if done incorrectly. When removing a key from an object, you might use the `delete` keyword. When you do this with an array, the length field will not be updated, resulting in an empty slot.

```javascript
let arr = [1, 2, 3]
// [1, 2, 3]
console.log(arr.length) // 3
delete arr[0]
// [<empty slot>, 2, 3]
console.log(arr.length) // 3
```

In order to remove elements we turn to the methods `splice()`, `pop()`, and `shift` from the Array Prototype. The `splice()` method allows us to remove a number of elements at a specific index. It can also allow us to replace those elements with something else.  `splice()` returns an array containing all the values removed from the array.

**NOTE**: In most browers, if you do not specify the number of elements to remove, it will remove all elements starting at the index specified.

```javascript
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr.splice(2, 1) // returns [3]
console.log(arr)
// [1, 2, 4, 5, 6, 7, 8, 9]
arr.splice(4, 3) // returns [6, 7, 8]
console.log(arr)
// [1, 2, 4, 5, 9]
```

The `pop()` method removes and returns the last element in an array and the `shift()` method removes and returns the first element in an array.

```javascript
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
arr.pop() // returns [9]
console.log(arr)
// [1, 2, 3, 4, 5, 6, 7, 8]
arr.shift() // returns [1]
console.log(arr)
// [2, 3, 4, 5, 6, 7, 8]
```

**NOTE:** - The `length` field can be modified directly. This can lead to arrays behaving a little oddly. If you change the `length` field to a value less than the actual length of the array, JavaScript will remove elements from the array in most browsers. If you set the field to a greater value, it will "add" empty fields. The fields that are added only exist in the `toString` method, as no keys are created.

### Iterating Through an Array

You can use a for loop to iterate through an array in JavaScript:
```javascript
let list = [1, 2, 3, 4, 5];

// standard for
for(let i = 0; i < list.length; i++){
    console.log(list[i]);
}
```

Arrays are iterable, and so you can use a `for-in` or `for-of` loop to iterate through an array. `for-in` will iterate through the keys of an array. `for-of` will iterate through the values of the array.
```javascript
// for-in
for(key in list) {
    // an enhanced for-in loop in JS iterates through
    // the keys not the values
    console.log(key);
    console.log(list[key]);
}

// for-of
for(element of list) {
    // if you say of, it will iterate through the values
    console.log(element);
}
```

There is also the `forEach()` method on the Array Prototype. This function is a functional array method that takes in a callback function and runs that function for each element in the array. The `forEach()` method returns undefined.
```javascript
// forEach()
list.forEach(
    function(value, index) {
        console.log(index + ' ' + value);
    }
)
```
### Array Methods
The Array Prototype includes many useful methods. Above, we covered the `splice()`, `shift()`, `push()`, `pop`, and `forEach()`. Here we will talk about a few other useful methods.
#### sort()
The `sort()` method will sort an array "in-place". This means that the array will be modified and the original array will be sorted. The `sort()` method can take in a function that will compare objects and sort them to your preference. If no callback function is provided, each element is converted to a string and sorted in ascending order.

```javascript
let list = ['tiger', 'panda', 'giraffe', 'cat', 'owl', 'bird']
list.sort()
// this will sort alphabetically
console.log(list)
// [ "bird", "cat", "giraffe", "owl", "panda", "tiger" ]

// This will sort by size of the string
list.sort(function(item1, item2) {return item1.length - item2.length})
console.log(list)
// [ "cat", "owl", "bird", "panda", "tiger", "giraffe" ]
```

#### indexOf() & lastIndexOf()
The `indexOf()` method returns the first index at which an element is present. `lastIndexOf()` returns the last index at which an element is present. If the element can't be found in the list, both will return the value `-1`.
```javascript
let list = [1, 1, 2, 3, 3, 5, 6, 1]
list.indexOf(3) // returns 3
list.lastIndexOf(3) // returns 4
list.indexOf(1) // returns 0
list.lastIndexOf(1) // returns 7
list.indexOf('cat') // returns -1
list.lastIndexOf('cat') // returns -1
```
#### find() & findIndex()
The `find()` method returns the first element in an array for which the callback function returns a truthy value. The `findIndex()` method does the same but returns that element's index. For example, if I were to try to find the first string in an array that had a length greater than or equal to 7, I could write a function that tested for that and pass it to the `find()` method:

```javascript
let words = ['the', 'small', 'fox', 'ate', 'a', 'largish', 'breakfast', 'and', 'slept']
words.find(function(word) {return word.length >= 7}) //returns 'largish'
words.findIndex(function(word) {return word.length >= 7}) //returns 5
```

#### filter()
The `filter()` function takes a callback function and creates a new array that is the made up of elements for which the callback function returns a truthy value. This can be useful in situations where you wish to perform an operation on only a subset of elements in an array. The original array is not modified. For example, I may wish to get only even numbers from an array:

```javascript
let list = [4, 67, 34, 55, 79, 12]
let evens = list.filter(function(n) { return n%2 === 0 })
console.log(evens)
// [ 4, 34, 12 ]
```

#### map()
The `map()` function takes a callback function and creates a new array that is the result of calling the function on each element of the array. The original array is not modified. For example, if I were to have an array of numbers and I wished to have an array of the squares of those numbers, I could use the `map()` function to accomplish this:

```javascript
let numbers = [1, 2, 3, 4, 5, 6, 7]
let squares = numbers.map(function(n) {return n*n})
console.log(squares)
// [ 1, 4, 9, 16, 25, 36, 49 ]
```

#### reduce()
The `reduce()` function takes a callback function and returns a single value that is the result of calling the function for each value in the array. For example, if we wished to have the sum of each element in an array, we could do the following:

```javascript
let numbers = [1, 2, 3, 4, 5, 6, 7]
let result = numbers.reduce(function(previousValue, currentValue) {return previousValue + currentValue})
console.log(result) // 28
```

# JavaScript Functions

A function is a group of reusable code which can be called anywhere in the program. A JavaScript function is defined using the `function` keyword. The syntax for creating a function:
```javascript
function name(parameter1, parameter2, parameter3) {
  // code to be executed
}
```

A simple JavaScript Function:
```javascript
function showMessage() {
  alert( 'Hello everyone!' );
}

//function call
showMessage();  // outputs "Hello everyone!" in alert box.
```

JavaScript can return a value by executing the code after the function call. To return a value, we use the `return` keyword.

```javascript
var product = multiplyFunc(4, 3);   // Function called and the return value is stored in 'product' variable.

function myFunction(a, b) {
  return a * b;             // Function returns the product of a and b
}
```

Simple Snippet : To convert centimeter to feet using JavaScript Functions
```html
<!DOCTYPE html>
<html>
<body>

<h2>JavaScript Function for converting centimeter to feet</h2>

<p id="demo"></p>

<script>
function toFeet(cm) {
  return (cm/30.48);
}
document.getElementById("demo").innerHTML = toFeet(180);
</script>

</body>
</html>
```
The output will be:
```
JavaScript Function for converting centimeter to feet
5.905511811023622
```

## Pass by value
In JavaScript, all function arguments are passed by value. This means that the value of any variable passed to a function is copied into the argument of the function. Any changes you make to the argument will not be reflected in the variable outside of the function.

### Primitives
With primitive values this behavior is straightforward. The primitive value is copied to a new variable:

```
function changeValue(number) {
  console.log(number) // 20
  number = 42
  console.log(number) // 42
}
let myNumber = 20
changeValue(myNumber)
console.log(myNumber) // 20
```

In the above example, we defined a primitive value `myNumber` to be 20. When we passed this variable into the `changeValue` function, it copied the value 20 into the new `number` variable. When we changed `number` it did not affect `myNumber` because those are two different variables, each with their own value.

### Objects
If you pass an object into a function, the story is slightly different. The value that is stored in a variable containing an object is not the object itself. Instead, an object reference is being stored inside of that variable. When you pass a variable containing a reference to an object, that reference is copied into the arguments of the function. Since the new variable has a copy of that object reference, we can use this variable to modify the object.

```
let myObject = {'pet': 'Cat'}
console.log(myObject.pet) // 'Cat'
function adoptDog(obj) {
  obj.pet = 'Dog'
}
adoptDog(myObject)
console.log(myObject.pet) // 'Dog'
```

It is tempting to conclude that objects are pass by reference, because you can modify the object that we pass into the function. However, if we attempt to change the value of the variable by assigning a new object we see that this isn't true:

```
let myObject = {'pet': 'Cat'}
console.log(myObject.pet) // 'Cat'
function adoptDog(obj) {
  obj = {'pet': 'Dog'}
}
adoptDog(myObject)
console.log(myObject.pet) // 'Cat'
```

Here, we see that because we reassigned the variable `obj` to a new object, the value of the variable changed and so the value of the variable `myObject` did not change. JavaScript is pass by value.

## Function Expression / Anonymous Function

Function Expressions also are known as a named or anonymous function.  An anonymous function is a function declared without any identifier refer to it. It is an expression that the variable holds a function. For example: `var x = function (a, b) {return a * b};` 

Example:
```javascript
var anon = function() {
  alert('I am anonymous');
};
var prd = function (a, b) {
    return a * b;
    
};
anon();
alert("prd = " + prd(2,4));
```
The above example results in two alert boxes on the current browser. The first alert box has "I am anonymous" inside it. The second alert box has "prd = 8" inside it. 


## Self-Invoking Functions / IIFE Functions

A self-invoking function is an anonymous function that is invoked immediately after its definition. It is also known as the IIFE (Immediately Invoked Function Expression) function.
It holds an anonymous function inside a set of parentheses (), which does the execution.

Syntax : `(function(){ code goes here...})();`

Example:
```javascript
(function(){
    // do this right now
    console.log("Look at me, I'm running");
})();
```


## Callback Functions

A callback function is a function that gets executed after another function completes it's own execution. This can be useful for asynchronous programming. All functions in JavaScript are objects and thus a function can be given another function as an argument. In this way we pass a callback function to our function.

A callback function can be created by using the `callback` keyword as the last parameter.

Example for callback functions:
```javascript
function funcOne(x) { alert("x = " + x); }

function funcTwo(y, callback) {
    callback(y);		
}

funcTwo(2, funcOne);
```

In the above example, `funcOne` is the callback function. When `funcTwo(2, funcOne);` is called, `funcTwo` takes in a variable (y) and a function (funcOne). `funcTwo` then passes the variable (y=2)  to the function it took in, i.e. `funcOne(2)` is called. Then, issues an alert with `x=2` on the current browser.

We can also pass an anonymous functions as a callback function.

Example:
```javascript
function funcTwo(y, callback) {
    callback(y);	
    callback(y);	
}

functionTwo(10, function(x) { alert("x = " + x); })
```
The above example issues an alert two times, saying `x = 10` on the current browser.


## Closures

A closure is a function that remembers and accesses the variables and arguments of its outer function even after the function return. The closure able to access the variables defined between its curly brackets, the outer function’s variables and the global variables.

Example:
```javascript
function greeting() {
    var message = 'Hi';

    function sayHi() {
        console.log(message);
    }

    return sayHi;
}
let hi = greeting();
hi(); // prints "hi" in the console.
```
Normally, when the `greeting()` function has completed executing, the `message `variable is no longer accessible. In this case, we execute the `hi()` function that references the `sayHi()` function, the `message` variable still exists. Hence, the `sayHi()` function is a closure.

## Hoisting of Functions and Variables

Hoisting is a JavaScript mechanism where variables and function declarations are moved to the top of their scope before code execution.

**Hoisting of Variables:**

The JavaScript compiler moves all the declarations of variables to the top so that there will not be any error.

Example:
```html
<script>
	//line 1
	x = 1; 
	document.getElementById("p1").innerHTML = x ;
	var x;
</script>
```


> **NOTE:** var x; declaration moved to the top (at line 1) of their scope. 

JavaScript Hositing only moves the variable declaration to the top, not the variables that are declared and initialized in a single line. 

Example:
```javascript
alert('x = ' + x); // displays x = undefined
        
var x = 1;
```

> **NOTE:** Since hoisting is only possible with the declaration but not the initialization, `var x = 1;` not moved to the top of their scope. 

**Hoisting of Functions:**

JavaScript compiler moves the function definition to the top in the same way as a variable declaration.

Example:
```javascript
alert(Sum(5, 5)); // output: 10

function Sum(val1, val2)
{
    return val1 + val2;
}
```

Javascript compiler moves only the Function declaration to the top, not the function expression.

Example:
```javascript
add(5, 5); // Results an error

var add = function sum(a, b)
{
    return a+b;
}
```

**Hoisting Functions Before Variables:**

JavaScript compiler moves a function's definition before the variable declaration.

Example:
```javascript
alert(UseMe); // displays the UseMe Function definition 

var UseMe = "UseMe Variable";

function UseMe()
{            
    alert("UseMe function called");
}
```

The above example will display "UseMe" function definition because JavaScript compiler moves the function before variables.Therefore, the alert box displays `function UseMe() { alert("UseMe function called");}`. 


>  **NOTE:**  The above code doesn't display "UseMe Variable" in the alert box due to hoisting functions before variables.


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

