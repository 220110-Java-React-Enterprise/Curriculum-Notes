# Packages & Access
Java has a very large ecosystem around it. The JRE comes with numerous libraries that help us do all sorts of things. Beyond that there are uncountable libraries and frameworks we can use that are not included with the JRE. In order to keep these organized and to avoid problems, we use the concept of **packages**. Even our own projects can get so large and complex that we use packages to organize them. A Java package is a group of similar types of classes, interfaces, and sub-packages. The directory structure within our own Java projects are also packages.  
  
The primary benefits of Java's packages are:
 - Categorization
 - Access protection
 - Avoid naming collisions
  
## Importing Packages
We `import` packages into our java files in order to use the classes and methods defined in those packages. 
```
//MyClass.java
package myclass;
public class MyClass {
    public static void printText(String str) {
        System.out.println(str);
    }
}

//MyOtherClass.java
import myclass;
public class MyOtherClass {
    public void invokeOtherMethod() {
        MyClass.printText("This is a sentence!");
    }
}
```
  
## Access modifiers 
The following table lists the Java access modifiers from least to most restrictive. These modifiers are used to control what has access to our class members and are fundemental to the concepts of abstraction and encapsulation.
 - Class - The member can be accessed from within the same class.
 - Package - The member can be accessed from within another class in the same package.
 - Sub-class - The member can be accessed from within a sub-class defined in another package.
 - Global = The member can be accessed from anywhere.

| **Modifier** | **Class** | **Package** | **Sub-class** | **Global** |
| ------------ | --------- | ----------- | ------------- | ---------- |
| `public` | Y | Y | Y | Y |
| `protected` | Y | Y | Y | N |
| ***default*** | Y | Y | N | N |
| `private` | Y | N | N | N |
  
Note that "default" is also sometimes referred to "package-private". This is the level of access given to members where another level of access is not specified.

It is important to remember these access modifiers and what they do. Keep in mind:
 - Private is the most restrictive and private members can only be accessed from within the same class. 
 - Public is the least restrictive and public members can be accessed anywhere.
 - Default or package-private members can only be accessed from classes within the package.
 - Protected is like default but members can also be accessed from sub-classes even if they are defined in another package.




  
