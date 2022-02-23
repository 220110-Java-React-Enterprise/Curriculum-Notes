//let num = 5; //perfectly valid javascript, which means it's also perfectly valid typescript
let num2: number = 5; //not valid JS, but valid TS
let str: string = "test";
console.log(num, str);


let someString = num.toString();
let someNum: number = parseInt("5");
console.log(someString, someNum);

let undef: undefined = undefined;
let undef2: undefined;

undef = null; //so we can assign a null value to an undefined type

let nul: null = null;
let nul2: null; //we can also leave a null type undefined, so that it's value = undefined.

nul = undefined; //we can even reassign a null type as undefined.

console.log(undef, undef2, nul, nul2);

//This is valid JS, but in TS it is given an implicit type, based on the original assignment.
let a = 1;
//a = "hello"; //doesn't work because a is implcitly a number

let b;
b = 1;
b = "hello"; //this works because there is no implicit type given. This is implicitly of type "any"

let c: any = "anything goes.";
c = undefined;
c = 5.5;
c = "That all worked!";

let d: void;
d = null;
d = undefined;
console.log(d);


enum Color {Blue = 2, Green = 1, Red, Yellow = 3};
let col: Color = Color.Red;
let colorName: string = Color[2];
console.log("colorName: ", colorName);

class AClass {
    readonly prop: any = {g: "g"}
}

let obj: AClass = new AClass();
obj.prop.g = "something else"
console.log(obj);



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
};

let greeting: Greeting = new Greeting(str);
console.log(greeting.greet());

interface User {
    username: string;
    password: string;
    confirmPassword?: string; 
}
let user: User = {username: 'max', password: "123"};
console.log(user);


interface CanDrive {
    accelerate(speed:number): void;
}

let car:CanDrive = {
    accelerate(speed:number): void {
        //must be like this
    }
};