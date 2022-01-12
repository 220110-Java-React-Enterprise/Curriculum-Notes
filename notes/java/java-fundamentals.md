# Java Fundamentals
  
## Comments
Often when writing code we want to include information that the compiler and JVM should ignore. These are called comments. In Java there are several ways to write comments:
```
//This is a single line comment, text is considered a comment until the next line.

/*
This is a
multi-line comment
and can go on as long as we want
*/
```

Note that these comments do not need to be on their own line. For instance:
```
//MyClass.java
public class MyClass {
   public MyClass(/*ADD PARAMETER LIST LATER*/) { //constructor
       //ADD CONSTRUCTOR IMPLEMENTATION LATER
   }
}
```
  
## Classes & Objects
A class is the logical bundling of data and behaviors (fields and methods) into a single logical unit. Often, however, we will deal with objects instead of classes. Objects and classes are tightly related concepts, but we should understand the difference. **Objects are instances of classes.** Classes are a sort of blueprint for objects. We often take a class and "**instantiate**" an objcet from it. This just means we create an object using the class as a blueprint. Sometimes a class can exist on its own, not as an object instance. This is where the `static` keyword comes in. 

## Methods
When we bundle data and behaviors into classes, the behavior parts are called **methods**. A method is part of a class and can be invoked to preform it's behavior. A method has several parts: modifiers, return type, name, and parameter list make up the method's **signature**. For example, here is the main method signature in Java:
```
public static void main(String[] args);
```
`public` is an **access-modifier**, `static` is another modifier (bot not an access modifier). The return type is `void` which means this methos returns nothing. The method is named `main` and it's parameter list includes an array of `String` objecs called `args`.
  
The last thing a method needs is an implementation, or the code that actually does stuff. Here is an example of a public static method with a void return type which takes in a String object and prints it to the console:  
```
public class MyClass {
    public static void printText(String str) {
        System.out.pritln(str);
    }
}
```
  
Methods are invoked via a class or object by using the dot operator (sometimes called the de-reference operator). We use the class or object name, followed by the dot operator, and then the method name. We also include the required parameters when invoking a method. Below we will invoke the `printText` method:
```
String sentence = "This is a string!";
MyClass.printText(sentence);
//This should output "This is a string!" to the console.
```
Note that this method is invoked using the class name, there is no object instantiated from that class in the example. This can be done because the method is `static`.

## Static Keyword
`Static` denotes a method, or field to be part of the class itself, rather than part of an object instantiated from the class. This means that all objects of that class share a single method or field. Consider the class below:
  
```
public class Example {
    public static int x = 5;
}
```
  
That ststic int x will be shared among all instances of this class. If we create two different objects from the class and print the value of x for each, they will both be 5. If we change one to 10 and then print them both again, both will show 10. There is only one version of x, which is kept in memory with the class itself.
  
Likewise we can classify methods as static as well. Static methods can be invoked on a class itself, and do not have access to non-static fields and methods. Consider a class with a non-static field, y. If you never instantiate an object from the class, y never exists. If you can invoke a static method without ever instantiating an object, and that method tries to access the field y, it would throw an error. Static methods can be invoked on a class object as well, and can be invoked on sub-classes as though inherited. 
  
Lastly, we can modify some classes to be static as well. We can't make a top-most class static (every .java file must contain one top-most class which the file is named after) but we can "nest" a class inside another. These nested classes can be made static. Static nested classes can only access static members of the outer class. Nested classes can access even private members of the outer class.
  
## Return Type
Many methods return some data upon completion. Almost all methods must specify a return type. The only methods that do not are constructors. A method which does not return any data must have the `void` return type. When a method is invoked, it is eventually resolved as a returned value.
  
## Constructors
Constructors are a special type of method used to instantiate an object of a class. A constructor is called with the `new` keyword and may optionally include a parameter list. Constructors have **no return type**, not even void. Typically constructors are `public` access so that they can be instantiated from anywhere. Constructors must have the same name as the class, which means it breaks the typical naming convention of camelCase method and PascalCase class names. A typical constructor has a sgnature like this:
```
public MyClass();
```
The implementation of a constructor typically sets up everything a class object needs to work.
  
## Inheritance
In Java, a class inherits data and behavior from a parent class using the `extends` keyword. A class can only extend one other class. Java is a language that only supports "single-inheritance". In fact every class (except one) in Java inherits from exactly one parent class. If a class is not specified with `extends` then it implicitly extends the `Object` class. The only class which does not have a parent is the `Object` class itself. **`Object` is the class from which all other Java classes are derived.**
  
Java is single-inheritance, but does have a way to inherit behavior from multiple sources: **interfaces**. Interfaces are a special type of class which can not be instantiated into an object. Interfaces generally lack any implementation details, instead interfaces generally only provide method **signatures**. We will cover interfaces in greater details in week 3.
  
## Overriding & Overloading
Some of the most common examples to demonstrate the concept of polymorphism are overloading and overriding.
  
### Overriding
Method overriding is the practice of modifying a method that a child class inherits from a parent. This is done by implementing the method with the exact same signature in the child class, but writing a different implementation.

```
//Animal.java
public class Animal {
    public void makeSound() {
        System.out.println("Aaaahhhhhh!");
    }
}

//Dog.java
public class Dog extends Animal{
    public void makeSound() {
        System.out.println("Woof!");
    }
}
```
Note that both Dog and Animal have a method with the same signature: `public void makeSound();`. A method signature is the method name, parameter list, return type, and modifiers but without any implementation details. Dog extends Animal (it inherits from) and the Dog implementation includes a method which replaces or **overrides** the one inherited from Animal.  
  
### Overloading
Method overloading is the practice of implementing methods with the same name, but with different parameter lists. This allows us to provide multiple similar implementations that are invoked depending on different parameters. Consider a sum method that adds numbers together, but one version has ints as parameters, and one has longs (extra large integers).
  
```
public int sum(int a, int b) {
    return a + b;
}


public long sum(long a, long b, long c) {
    return a + b;
}

```
Note that the return type changes between these two methods, however that alone is not enough for the compiler to be able to choose one. In order to overload a method we must change the parameter list. 


