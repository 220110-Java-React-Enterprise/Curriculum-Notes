# ES6 Classes
In ES6, JavaScript introduced class syntax for creating object templates. This allows us to quickly create multiple objects with similar attributes, and more easily take advantage of inheritance through the extends keyword. You even get access to the `static` keyword, which allows you to add a field or function to the class itself, rather than an instance of the class.

## Example
```JavaScript
class Animal {
    constructor(name){
        this.name = name;
    }
    static breathe() {
        console.log("breathes");
    }
    speak(){
        console.log('Hello, my name is'+this.name);
    }
}

class Cat extends Animal {
    constructor(name, color){
        super(name);
        this.color = color;
    }
    speak(){
        console.log('Meow');
    }
}

let animal = new Animal('Doug')
console.log(animal);
animal.speak();
Animal.breathe();
console.log(animal instanceof Animal);
console.log(animal instanceof Cat);
let cat = new Cat('Mister', 'Grey');
console.log(cat);
cat.speak();
Cat.breathe();
console.log(cat instanceof Animal);
console.log(cat instanceof Cat);
```

This code will output the following:
```
Animal { name: 'Doug' }
Hello, my name isDoug
breathes
true
false
Cat { name: 'Mister', color: 'Grey' }
Meow
breathes
true
true
```

So then we don't have to worry about prototypes anymore? Incorrect, the class syntax is merely abstracting this for us.
```JavaScript
console.log(cat.__proto__)
```
will output:
```
Animal {}
```
So we can see that the objects being created are just like any other JS object. Equivalent ES3 code for our example would look like this:

```JavaScript
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Animal = /** @class */ (function () {
    function Animal(name) {
        this.name = name;
    }
    Animal.breathe = function () {
        console.log("breathes");
    };
    Animal.prototype.speak = function () {
        console.log('Hello, my name is' + this.name);
    };
    return Animal;
}());
var Cat = /** @class */ (function (_super) {
    __extends(Cat, _super);
    function Cat(name, color) {
        var _this = _super.call(this, name) || this;
        _this.color = color;
        return _this;
    }
    Cat.prototype.speak = function () {
        console.log('Meow');
    };
    return Cat;
}(Animal));
var animal = new Animal('Doug');
console.log(animal);
animal.speak();
Animal.breathe();
console.log(animal instanceof Animal);
console.log(animal instanceof Cat);
var cat = new Cat('Mister', 'Grey');
console.log(cat);
cat.speak();
Cat.breathe();
console.log(cat instanceof Animal);
console.log(cat instanceof Cat);
```
_note_: This code was generated via the TypeScript compiler.
