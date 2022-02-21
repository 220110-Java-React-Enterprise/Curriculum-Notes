### Arrow Functions

Arrow functions, introduced in ES6, provides a concise way to write functions in JavaScript. They save developers time and simplify function scope.

* **One-line arrow functions** have implict return and defined without curly braces.

```
let func = (arg1, arg2, ...argN) => expression;
```

**Example:** 
```javascript
var hello = () => "Hello World!";
hello(); // output: "Hello World!"
```

* **Multiline arrow functions** have multiple statements inside the function, enclosed with curly braces and need an explicit return to return something.

```
let func = (arg1, arg2, ...argN) =>{
stament1;
...
statementn;
return value;
}
```

**Example:**
```javascript
var sum = (a, b) => {
      let result =  a + b;
    return "Sum is" + result;
};

sum(5, 3);  //output: "sum is 8"
```


# Spread and Rest Operator
The spread operator and the rest parameter was introduced in ES6. Both the spread operator and the rest parameter uses three consecutive dots (…).

## Spread Operator 

The spread operator provides the ability to expand iterable objects into multiple elements. 

*  The spread operator expands the contents of the array into individual elements. 

**Example:**
```javascript

// spread operator for copying  
let arr = ['a','b','c']; 
let arr2 = [...arr]; 
console.log(arr); // [ 'a', 'b', 'c' ] 

const arr =[1,2,3,4,5,6];
console.log(...arr);    //output: 1 2 3 4 5 6

const days = ["mon", "tue", "wed", "thurs", "fri", "sat", "sun"];
console.log(...days);    //output: mon tue wed thurs fri sat sun
```

*  The spread operator used for combining arrays.

**Example:**
```javascript
const arr1 = [2, 4, 6, 8, 10];
const arr2 = [3, 6, 9, 12, 15];

//combining arr1 and arr2 using spread operator
const arr = [...arr1, ...arr2];
console.log(arr);       // output: [2, 4, 6, 8, 10, 3, 6, 9, 12, 15]

//without spread operator
const array = [arr1, arr2];
console.log(array);     //output: [Array(5), Array(5)]

let merged = [0, ...arr1, 0, ...arr2];
console.log(merged);    //output: [0, 2, 4, 6, 8, 10, 0, 3, 6, 9, 12, 15]
```
## Rest Parameter

The rest parameter used to represent an indefinite number of arguments as an array.
 
**Syntax:** The rest parameter (...) should be at the end of the function parameter. If the rest parameter(...) is at the beginning or in the middle of the function parameter list, it will result in an error.
```
function functionname[...parameters]//... is the rest parameter
{
statement;
}
```

**Example:**
```javascript
//using spread operator
function addition(...input){ 
    let sum = 0; 
    for(let i of input){ 
        sum+=i; 
    } 
    return sum; 
} 
console.log(addition(5,6));             //output: 11
console.log(addition(4,6,3));           //output: 13
console.log(addition(2,5,8,3,4,1));     //output: 23
```
In the below example, we are passing the rest parameter as the third parameter which can store n number of function parameter.

**Example:**
```javascript
function myFun(a, b, ...manyMoreArgs) {
  console.log("a - ", a)
  console.log("b - ", b)
  console.log("manyMoreArgs - ", manyMoreArgs)
}

myFun("one", "two", "three", "four", "five", "six"); 
```
Output on the console:
```
a -  one
b -  two
manyMoreArgs -  (4) ["three", "four", "five", "six"]
```

# Destruction assignment

Destructuring is the process of breaking a structure.  In JavaScript, destructuring can be applied to an Object or an Array. Destructuring assignment is a special syntax that allows us to “unpack” arrays or objects into a bunch of variables

## Array destruction


*  In Array destruction, variables declared on the left side, and the array is on the right side. It assigns a value for the variables with the array value on the same index.

**Example:** In the below example, we have an 'name' array with the first name and last name. Destruction assignment is used to split the first name and last name seperately.

```javascript
let name = ["Jacob", "Noah"];
// destructuring assignment sets firstname = arr[0] and lastname = arr[1]
let [firstname, lastname] = name;
console.log(firstname); // output: Jacob
console.log(lastname); //output: Noah
```


*  If the number of variables declared on the left side is more than a number of elements on the right side, then excess items are not assigned. The unwanted elements of the array can be ignored by using an extra comma.

**Example:**
```javascript
let arr = [1,2,3,4,5]
const [var1, var2] = arr;
console.log(`var1: ${var1}, var2: ${var2}`);  //output: var1: 1, var2: 2    

let [firstName, , title] = ["Charles", "Dickens", "David Copperfield", 2002];
console.log( title );     //output: David Copperfield
```

*  Variables with default values are mapped to the values from Array. If no matching index element found in array, default values are initialized.

**Example:**
```javascript
let arr =[1,2]
const [ a = 3, b, c = 5] =arr; 
console.log(`a =  ${a}, b = ${b}, c = ${c} `);    //output: a =  1, b = 2, c = 5 
```


*  Rest operators used to assign to variables for destructing. 

**Example:**
```javascript
var [a, b, ...args] = [1,2,3,4,5];
console.log(`a: ${a}, b: ${b}, args: ${args}`); //output: a: 1, b: 2, args: 3,4,5
```

## Object Destruction


*  The right-hand side of an equal operator is Object and destruct/break it and assigned with variables.

**Example:** The variables declared on the left side should have the same name as an object's key name *like book and author in the below example*.
```javascript
var bookObj = {
  book: "The Three Musketeers",    
  author: "Alexander Dumas"
};

var {book , author} = bookObj; 

console.log(`Book: ${book}, Author: ${author}`);//output: Book: The Three Musketeers, Author: Alexander Dumas
```


*  Variables declared in the left side can be declared with default values.

**Example:** Here newEmployee is empty and local variable newId is created and the default value is 12, if id property not found in the object, the newId value is assigned with a default value. 
```javascript
var newEmployee = {};  
var { newId = 12 } = newEmployee;  
console.log(newId);      // Output: 12  
```

### Nested Object destruction 

An object has child object can be destructed. In the below example, city local variable is created and assigned with NewYork, address variable is not created and it just serves as a locators for mapping child elements.

**Example:**
```javascript
var employee = {  
    id: 11,  
    name: "Tom",  
    address: {  
        city: 'NewYork',  
        Country:'USA'  
    }  
};  
var { address: { city} } = employee;  
console.log(city);      // outputs Newyork
```

### Destructuring looping/iteration 

`Object.entries()` method is used to destructuring/break the key and pair values of an object during an iteration of for loop.

**Example:**
```javascript
var student = {  
    id: 10,  
    name: "Alexander",  
};  
for (let [key, value] of Object.entries(student)) {  
  console.log(`${key}:${value}`); // id:10 name:Alexander  
}  
```
