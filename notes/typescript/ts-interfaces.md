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

* [TypeScript Docs - Interfaces](https://www.typescriptlang.org/docs/handbook/interfaces.html)
