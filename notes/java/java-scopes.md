# Scopes in Java
There is a common concept in programming called "scope". This refers to when and where and when a reference is valid. Where a reference is defined in your code controls when at runtime that reference is valid. While the reference is valid it is considered "in scope". Once it goes "out of scope" it is no longer valid. 

When writing code modern IDEs will double check everything as you write, including scope. If you get an error or warning that some reference doesn't exist, this may indicate the reference is not in scope.

Note that **scope** and **access modifiers**, while similar concepts, are not the same thing. 

### Class-level Scope
This is the highest-level scope in Java. References defined inside a class (everything exists inside a class in Java) but outside of any methods or blocks are class scoped. These references are accessable from within methods, blocks, and nested classes located within this class. Class level references can be accessed from outside a class in accordance with the access modifiers. Class scoped references are in scope as long as the class/object they are defined in is in scope. 

### Method-level Scope
References defined inside a method, but not inside a deeper block, are method scoped. These references will not be accessable from other methods in the same class, and will not be accessable by nested classes. As soon as the method completes, the reference falls out of scope. Method scoped references are accessable from within deeper blocks in that method.

### Block and Loop Scope
References defined inside any block of code are in scope in that block and blocks that are nested deeper. As soon as that block of code ends, references defined within are out of scope. These same block structures are found in control flow statements like loops. The same scoping rules apply.

```
//MyClass.java
public class MyClass {
    public int classLevelScope = 1;
    // A
    
    public int myClassMethod() {
        int methodLevelScope = 2;
        // B
        
        for(int i = 0; i < 5; i++) {
            int blockScope = 3;
            // C
        }
        //B
    }
    //A
}
```
In the above example `classLevelScope` is an `int` which is in scope at all three points A, B, and C. `methodLevelScope` is an `int` which is in scope at points B & C, but not at point A. Finally, `blockScope` is only in scope at point C. As soon as we leave the block where `blockScope` is defined it falls out of scope and is no longer valid. As far as we are concerned it no longer exists. Once we leave the method `myClassMethod` `methodLevelScope` also falls out of scope and no longer exists. Finally, `classLevelScope` is only in scope as long as this object is. As long as this object is in scope the public member `classLevelScope` can be accessed via the object.

Note that in Java references are not in scope until the point in the file where they are defined. The below example is not valid because the String str is not defined yet the first time it is used.
```
//BrokenClass.java
public class BrokenClass {
    System.out.println(str); //this will cause an error
    String str = "This string begins existing here and not before.";
    System.out.println(str); //now it will work
}
```
