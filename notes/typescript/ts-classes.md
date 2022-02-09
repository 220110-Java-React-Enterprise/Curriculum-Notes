## Classes in TypeScript

We know that TypeScript is an object-oriented programming language. The `class` keyword is used to declare a class in TypeScript. An instance of the class can be created using the `new` keyword.

Let's take a look at a simple class example:

```typescript
class Greeting {
    //fields
    name: string;
    //constructor
    constructor(name: string) {
        this.name = name;
    }
    //methods
    greet() : string {
        return "Hello, " + this.name;
    }
}
//creating an object
let greeter = new Greeting("James");
greeter.greet(); //returns "Hello, James"
```

### Inheritance

In TypeScript, we can implement an inheritance hierarchy using the `extends` keyword, similar to other object-oriented programming languages.

```typescript
class Animal {
    move(distanceInMeters: number = 0) {
        console.log(`Animal moved ${distanceInMeters}m.`);
    }
}

class Dog extends Animal {
    bark() {
        console.log('Woof! Woof!');
    }
}

const dog = new Dog();
dog.bark();  // returns 'Woof! Woof!'
dog.move(10); // returns 'Animal moved 10m.'
```
### Access Modifiers

* **public** -  In TypeScript, each member is `public` by default. We can still mark a member `public` explicitly.
* **private** -  We can mark a member as `private` that cannot be visible outside of the class.
* **protected** -  If a member marked as `protected`, then the member can be accessed only by its containing class and deriving classes.

### Readonly modifier

We can make properties accessible but immutable by using the `readonly` keyword. Readonly properties must be initialized at their declaration or in the constructor.

```typescript
class Employee {
    readonly name: string;
    readonly dept_id: number = 123;
    constructor (name: string) {
        this.name = name;
    }
}

let e1 = new Employee("Grace");
e1.dept_id = "543"; // error! dept_id is readonly.
```

### Modules

In TypeScript, the code we write is globally scoped by default. TypeScript provides modules and namespaces to restrict scopes and also to organize and maintain a large codebase. All variables, classes, and functions declared in a module are not accessible outside the module. A module is created using the `export` keyword and used in another module using the `import` keyword.

To export a class, function or variable, add the `export` keyword at the begining.

```typescript
// 'module.ts' file
export function sayHello(){
    console.log("hello");
}

export class Employee{
    empCode: number;
    empName: string;
    constructor(name: string, code: number) {
        this.empName = name;
        this.empCode = code;
    }
    displayEmployee(){
    console.log(`Employee Code: $ {this.empCode} , Employee Name: ${this.empName} `);
  
    }
}

export const maxLength : number = 1200;

```

The syntax for importing a module: `import { export name } from "file path without extension";`. For example , `import { Employee } from "./module";`

```typescript
//'main.ts' file
//importing the Entire Module into a Variable

import * as Emp from "./module";

console.log(Emp.maxLength); // returns '1200'

Emp.sayHello(); //returns 'hello'

let empObj = new Emp.Employee("Gavin" , 2);
empObj.displayEmployee(); // returns 'Employee Code: 2 , Employee Name: Gavin'

```


### Accessors and Mutators

TypeScript supports getter and setter methods to access and set class members. The getter and setter methods are created using  the `get` and `set` keywords.

```typescript
class MyClass { 
    private _width: number; 
    private _height:number; 
    get area() { 
        return this._width * this._height; 
    } 
    set width(newWidth : number){
        console.log("setting width for square...");
        this._width = newWidth;
    }
    set height(newHeight : number){
        console.log("setting height for square...");
        this._height = newHeight;
    }
} 
let obj = new MyClass();

obj.width = 10;
obj.height = 5;

console.log("area: " + obj.area);

//output will be:
//setting width for square...
//setting height for square...
//area: 50
```

## Interfaces

Interfaces allow us to create **contracts** that other classes/ objects can implement. Interfaces are defined using the `interface` keyword that includes properties and methods. We can have **optional properties**, marked with a "?" that do not have to be implemented.

The TypeScript compiler **does not convert the interface** to JavaScript. Instead they are only used for **type checking**.

**Example:**

```typescript
interface User {
    username: string;
    password: string;
    confirmPassword?: string; 
}

let user: User;

user = {username: 'Jack', password: 'supersecret'};  

user = {username: 'Jack', password: 'supersecret' confirmPassword: 'supersecret'};

// Compilation error : anything and anynumber doesn't exists in User
// The property name should be same
// user = { anything: 'anything', anynumber: 5};

// Compilation error 
// the password property value should be string
//user = {username: 'max', password: 123};

```

Interfaces can also contain **functions without the function body** which is used to ensure the function signature.

```typescript
interface CanDrive {
    accelerate(speed:number): void;
}

let car:CanDrive = {
    accelerate: function (speed:number) {
        // ...
    }
};

```


## References

* [TypeScript Docs - Classes](https://www.typescriptlang.org/docs/handbook/classes.html)
* [TypeScript Docs - Interfaces](https://www.typescriptlang.org/docs/handbook/interfaces.html)
