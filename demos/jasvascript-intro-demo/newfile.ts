const pi: number = 3.14159;

function myFunc() {
    console.log("myFunc");
}

class MyClass {
    num: number = 5;
    memberFunc(): void {
        console.log("memberFunc");
    }
}


function frozen(constructor: Function) {
    console.log('-- decorator function invoked --');
    Object.freeze(constructor);
}

@frozen
class Greeter {
    name: string;
    constructor(name: string) {
	    console.log('-- this constructor invoked --');
        this.name = name;
    }
    greet() {
        console.log("Hello, " + this.name);
    }
}

let greeter = new Greeter("Kyle");
greeter.name = "Brian";

console.log(greeter);
