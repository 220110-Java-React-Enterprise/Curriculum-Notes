## JavaScript

JavaScript is the most commonly used **client-side** scripting language. It is a **high-level, multi-paradigm, interpreted**, **weakly-typed** programming language used to create dynamic webpages. When the browser loads a webpage, the browser interprets javascript code in it and executes it.

 - High-level: Abstracted away from low level systems and hardware.
 - Interpreted: some system interprets the script and translates it to machine executable instructions - in the case of JS it is part of the browser.
 - multi-paradigm: just means that JS doesn't fit neatly into a single type of language (imperitive, declarative, object-oriented, functional, etc.)
 - client-side: JS used to be only run on client side, but this is no longer true with Node.js, a software package designed to make server-side javascript possible.

When we say JavaScript is a client-side language, we mean that it runs in the user's web browser and not on a server. However, although JavaScript originated as a scripting language that runs in the browser, the Node.js runtime environment does allow JavaScript code to be run on servers as the backend program for an application.

When we say JavaScript is a high level language, we mean that it abstracts away many implementation details that relate to computer hardware - like allocating memory or garbage collection of objects. When we say it is multi-paradigm, that means it supports many programming paradigms like procedural, object-oriented, and functional programming.

ECMAScript is the official name for JavaScript. It is used for language specification. The versions of a Javascript are defined by ECMAScript (ES). The versions of JavaScript are ES5, ES6, ES7, and so on.

In HTML, JavaScript code is written inside the `<script> `and `</script>` tags. You can place any number of scripts in an HTML document. Scripts can be placed in the `<body>`, or in the `<head>` section of an HTML page, or in both.

```html
<script>
 JavaScript code
</script>
```

**Internal JavaScript** - When the javascript code placed anywhere within the HTML page using `<script> `tags, then it called  Internal JavaScript.

**External Javascript** -  When the same JavaScript code used for many webpages then we place the JavaScript code in a separate file. When JavaScript code placed in a separate file from the HTML code is called External JavaScript. These files are saved with the ". js" extension and imported into the HTML page using the `src` attribute. The src attribute specifies the URL/path of an external JavaScript file. (Eg: `<script src="./script.js"></script>`)

## Syntax

JavaScript is case sensitive. Every statement in JavaScript is separated using a semicolon (;). JavaScript ignores multiple spaces and tabs.

**JavaScript Comments**: JavaScript support single-line as well as multi-line comments.  Single line comment starts with `//` and multi-line comments are wrapped between `/*` and `*/`.

**JavaScript Literals**: Literals are the fixed values, it can be numbers, strings, boolean values, etc. The number type stores integer, float, and hexadecimal value. Strings are text, enclosed within single or double quotes (' or "). If the number is enclosed with single or double quotes, then it is considered as a string.

**JavaScript Keywords**: Keywords are tokens that have special meaning in JavaScript. The keywords supported by JavaScript are 
 - break
 - case
 - catch
 - continue
 - do
 - else
 - finally
 - for
 - function
 - if
 - in
 - new
 - return
 - switch
 - this
 - throw
 - try
 - typeof
 - var
 - void
 - while
 - AND MORE!

## JavaScript Variables

Variables are used to store data values. It uses the `var` keyword to declare variables. An equal sign (=) is used to assign values to variables.
Variable names are identifiers that should not be a JavaScript keyword. It starts only with the alphabet, underscores (_) or dollar ($). It cannot start with a number and also there shouldn't be spaces in-between.

*Example:*
```html
<script>
    var x, y ; //declaring the variable
    x = 6; y = 6; // assigning values
    var name = 'John';
</script>
```
# let and const keywords

In ES6, `const` and `let` keywords allow developers to declare variables in the block scope, which means those variables exist only within the corresponding block.

Variables declared with the `let` and `const` keyword can have **Block Scope**.

## `let` Keyword

The variables declared inside a block {} have Block Scope, so it can not be accessed from outside the block.

**Example:**
```javascript
{
  let y = 2;
}
// y can NOT be used here

var x = 10;
// Here x is 10
{
  let x = 2;
  // Here x is 2
}
// Here x is 10

```

## `const` Keyword

`const` is block-scoped, much like variables defined using the `let` keyword. The value of a `const` variable can't be changed through reassignment, and it can't be redeclared.

**Example:** We cannot change the primitive value of constant variable.
```javascript
const a = 12;
a = a+11; //error
a="hello"; //error
```

**Example:** We can change the properties of a constant object but we can't reassign the constant object.
```javascript
//const object
const person = { name: "Johnson" , age: "23", gender: "male"};

// change a property
person.age = "21";

console.log(person); // prints " {name: "Johnson", age: "21", gender: "male"} " in the console.

//reassigning const object
person = { name: "Mercy" , age: "23", gender: "female"}; //error
```


## Operators

Javascript Operators performs some operation on single or multiple operands  and produces a result. The categories of operators and the operators  used in JavaScript are listed below:

* Arithmetic operators -  `+, -, *, /, %, ++, --`
* Comparison Operators - `==, ===, !=, >, <, >=, <=`
* Logical Operators  - `&&, ||, !`
* Assignment Operators - ` =, +=, -=, *=, /=, %= `
* Ternary Operator -  `<condition> ? <value1> : <value2>;`

### Control Flow

JavaScript uses the following control flow statements:
* `if/else`
* `for`
* `for-in`
* `for-of`
* `while`
* `do-while`

The important difference between `for-in` and `for-of` is that the first allows iteration over the **keys** of any object, while `for-of` allows iteration over an array or array-like object. The syntax is demonstrated below.

```javascript
let person = {
  name: 'Bob',
  age: 25
};

for (let prop in person) {
  console.log(person[prop]); // prints 'Bob' and then 25
}

let people = [
{
  name: 'Alice',
  age: 30
},
{
  name: 'Charlie',
  age: 29
}
]

for (let pers of people) {
  console.log(pers.name); // prints 'Alice' then 'Charlie'
}
```

### Compared to Other Languages (Java/C#)
When comparing to other languages, it's interesting to note that JavaScript was originally developed to be a scripting language with similar syntax to Java. While this means that some of the syntax bears a resemblence to the C-derived languages of Java and C#, JavaScript is very different from them in more meaningful ways.

* As a dynamically-typed language, JavaScript does not declare types and a variable you had previously stored a string in might hold a number. This also means that that there is no static type checking available, leading to potential issues where a function can return a value of multiple types. In Java or C#, this is far less likely as you usually declare a specific type for each variable, and static type checking is a feature leading to less confusion in utilizing an API.
* JavaScript is single-threaded and runs off of an event-loop. Java and C# support multi-threading.
* JavaScript can run on a server or on a browser. Java and C# would have to be compiled to WebAssembly in order to run on modern-day browsers.
* JavaScript is a multi-paradigm language, meaning we can solve our problems in a variety of ways, functionally, object-oriented, or event-driven. With Java and C#, while many of those paradigms have support in the language, Object-oriented solutions are preferred. In JavaScript, functions are first-class variables, meaning that they are treated like any other variable and can be passed as arguments to other functions.
* JavaScript utilizes prototype-based objects. Java and C# utilize class-based objects. In ES6, JavaScript introduced class-based syntax which allows us to interface with our prototypes in a similar manner to Java and C#. However, OOP in JavaScript is accomplished very differently than in these other languages. For example:
  1. An "overridden" method is merely shadowed on the prototype and is therefore still accessible.
  2. JavaScript has no concept of overloading.
  3. Encapsulation is possible in JavaScript but there are no access modifiers and is not as simple as in other languages.
