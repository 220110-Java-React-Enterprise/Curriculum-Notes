var num = 5; //perfectly valid javascript, which means it's also perfectly valid typescript
var num2 = 5; //not valid JS, but valid TS
var str = "test";
console.log(num, str);
var someString = num.toString();
var someNum = parseInt("5");
console.log(someString, someNum);
var undef = undefined;
var undef2;
undef = null; //so we can assign a null value to an undefined type
var nul = null;
var nul2; //we can also leave a null type undefined, so that it's value = undefined.
nul = undefined; //we can even reassign a null type as undefined.
console.log(undef, undef2, nul, nul2);
//This is valid JS, but in TS it is given an implicit type, based on the original assignment.
var a = 1;
//a = "hello"; //doesn't work because a is implcitly a number
var b;
b = 1;
b = "hello"; //this works because there is no implicit type given. This is implicitly of type "any"
var c = "anything goes.";
c = undefined;
c = 5.5;
c = "That all worked!";
var d;
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
var col = Color.Red;
var colorName = Color[2];
console.log("colorName: ", colorName);
var AClass = /** @class */ (function () {
    function AClass() {
        this.prop = { g: "g" };
    }
    return AClass;
}());
var obj = new AClass();
obj.prop.g = "something else";
console.log(obj);
var Greeting = /** @class */ (function () {
    //constructor
    function Greeting(name) {
        this.name = name;
    }
    //methods
    Greeting.prototype.greet = function () {
        return "Hello, " + this.name;
    };
    return Greeting;
}());
;
var greeting = new Greeting(str);
console.log(greeting.greet());
var user = { username: 'max', password: "123" };
console.log(user);
