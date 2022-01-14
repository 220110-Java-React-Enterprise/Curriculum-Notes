# Classes
* Classes are complex data types
* Classes are blueprints for objects
* Describe the state and behavior of a data type
* Example: A Person has a name and a age.

```
class Person {
  String name;
  int age;
}
```

# Objects
* An object is an instance of a class
* John is a Person instance
* use the `new` keyword to create an object

```
Person john = new Person();
```

# More on classes
* There are 4 types of classes
  * We will only talk about **outer** classes

in file `Person.java`

```
public class Person {

  //variables
  String name;
  int age;

  //methods  
  void methodOne() {

  }

  void methodTwo() {

  }
}
```

create Person object

```
Person john = new Person();
```

access instance variables

```
john.name = "John";
```

invoke instance methods

```
john.methodOne();
```

each instance gets its own set of instance variables

```
Person john = new Person();
Person amy  = new Person();

john.name = "John";
amy.name = "Amy";

System.out.println(john.name); //prints John
```

# Methods
* a block of code that I can invoke / call
* black box
  * give it *input* and get back *output*
  * I do not know what happened inside
* **Method Signature**
  * return type
  * method name
  * parameters

examples
```
void someMethod() {

}

someMethod(); //invoke method
```

```
int someMethod() {
  return 5;
}

int a = someMethod(); //invoke method. a is 5
```  

```
int add(int x, int y) {
  return x + y;
}

int a = add(3, 4); //invoke method. a is 7
```

notice the **arguments** do not have to have the same names as the **parameters**
* where are the **arguments**?
* where are the **parameters**?

```
int add(int x, int y) {
  return x + y;
}

int first  = 3;
int second = 4;

int a = add(first, second); //invoke method. a is 7
```

# Constructors
* special method
* does not have a return type
  * the return type is *implicitly* an object
* must have the same name as the class
  * case matters
* Constructors are invoked when we use the `new` keyword

example of no arg constructor

```
public class Person {

  public Person() {

  }

}
```

more verbose example
* `this` points to this object
* it essentially gives you a reference to yourself

```
public class Person {

  String name;
  int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }  
}
```

we can invoke that constructor as follows

```
Person john = new Person("John", 28);
```

we can also overload constructors
* **method overloading** is when you define two or more methods with the same name in the same class
  * we cannot be ambiguous, so either the number of parameters or the parameter data types must be different
* you can overload normal methods too  

```
public class Person {

  String name;
  int age;

  public Person(String name) {
    this.name = name;
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }  
}
```

invoke the first constructor

```
Person john = new Person("John");
```

invoke the second constructor

```
Person john = new Person("John", 28);
```

How were we able to create instances without defining a constructor?
* When Java sees there are no constructors in a class, Java will insert a **default constructor**
* the **default constructor** is a no arg constructor: `public Person(){}`

# Pass by value
* Learn [stack vs heap](stack-vs-heap.md) first
* Other languages have concepts of *pass by value* and *pass by reference*
* Java does not allow us access to pointers
* Java is only *pass by value*

what is the output?

```
public static void main(String[] args) {
  int x = 1;
  someMethod(x);
  System.out.println(x);
}

static void someMethod(int a) {
  a = 100;
}
```

what is the output?
* tricky

```
public static void main(String[] args) {
  int x = 1;
  someMethod(x);
  System.out.println(x);
}

static int someMethod(int a) {
  a = 100;
  return a;
}
```

what is the output?

```
public static void main(String[] args) {
  int x = 1;
  x = someMethod(x);
  System.out.println(x);
}

static int someMethod(int a) {
  a = 100;
  return a;
}
```

that's pretty much the same behavior in other languages
* what about objects?

what is the output?

```
public static void main(String[] args) {
  Person john = new Person("John", 28);
  someMethod(john);
  System.out.println(john);
}

static void someMethod(Person someone) {
  someone.age = 100;
}
```

ok... how is that not **pass by reference**?
* technically we are passing the value of the memory address of john

what is the output?

```
public static void main(String[] args) {
  Person john = new Person("John", 28);
  someMethod(john);
  System.out.println(john);
}

static void someMethod(Person someone) {
  someone = new Person("Amy", 27);
}
```

# Static
* something that belongs to the class
  * you can have static **methods** and **variables**
  * you can have static classes, but that's a discussion for another day
* you do not need an instance to use it

class with static members

```
class MyClass {
  static int x;

  static void someMethod() {
    System.out.println("allo");
  }
}
```

accessing those static members

```
MyClass.x = 1;
MyClass.someMethod();
```

Each instance gets its own set of instance variables.
There is only ever one set of static variables.
* static variables are allocated memory at *class loading time* i.e. right before the code runs

```
class Test {
  int x;
  static int y;
}
```

If I create 100 instances of `Test`
* how many `x`s exist in memory?
* how many `y`s exist in memory?

If I create 0 instances of `Test`
* how many `x`s exist in memory?
* how many `y`s exist in memory?
