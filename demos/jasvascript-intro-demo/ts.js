//let num = 5; //perfectly valid javascript, which means it's also perfectly valid typescript
let num2 = 5; //not valid JS, but valid TS
let str = "test";
console.log(num, str);
let someString = num.toString();
let someNum = parseInt("5");
console.log(someString, someNum);
let undef = undefined;
let undef2;
undef = null; //so we can assign a null value to an undefined type
let nul = null;
let nul2; //we can also leave a null type undefined, so that it's value = undefined.
nul = undefined; //we can even reassign a null type as undefined.
console.log(undef, undef2, nul, nul2);
//This is valid JS, but in TS it is given an implicit type, based on the original assignment.
let a = 1;
//a = "hello"; //doesn't work because a is implcitly a number
let b;
b = 1;
b = "hello"; //this works because there is no implicit type given. This is implicitly of type "any"
let c = "anything goes.";
c = undefined;
c = 5.5;
c = "That all worked!";
let d;
d = null;
d = undefined;
console.log(d);
var Color;
(function (Color) {
    Color[Color["Blue"] = 2] = "Blue";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Red"] = 2] = "Red";
    Color[Color["Yellow"] = 3] = "Yellow";
})(Color || (Color = {}));
;
let col = Color.Red;
let colorName = Color[2];
console.log("colorName: ", colorName);
class AClass {
    constructor() {
        this.prop = { g: "g" };
    }
}
let obj = new AClass();
obj.prop.g = "something else";
console.log(obj);
class Greeting {
    //constructor
    constructor(name) {
        this.name = name;
    }
    //methods
    greet() {
        return "Hello, " + this.name;
    }
}
;
let greeting = new Greeting(str);
console.log(greeting.greet());
let user = { username: 'max', password: "123" };
console.log(user);
let car = {
    accelerate(speed) {
        //must be like this
    }
};
