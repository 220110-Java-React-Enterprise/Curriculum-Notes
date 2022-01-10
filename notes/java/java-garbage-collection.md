### Garbage Collection
Consider the following Java code snippet:
```java
Object o1 = new Object(); // 1
Object o2 = new Object(); // 2
Object o3 = o1;           // 3
o2 = o3;                  // 4
```

How many objects have we created on the heap? We determine this by counting the number of `new` keywords: in this case, 2. However, we have declared 3 reference variables that point to these objects in memory. The third line does not create a new object, it simply creates a new reference variable pointing to the object created on the first line. The last line reassigns the `o2` variable to reference the object `o3` is referencing, which is the first object created.

But what happened to the object created on the second line? After line 4, there are no reference variables pointing to it, thus it can never be used again in the program. When a condition like this occurs, the object becomes eligible for garbage collection - **the process of removing objects from the heap which have no references to them**. In lower-level programming languages, memory is manipulated directly in the code, but Java abstracts these details away from the developer by allowing the JVM to handle memory management itself. We already know that the JVM creates objects in the heap when we invoke the `new` keyword. It also will clean up objects for us, freeing up memory for new objects to be created.

As demonstrated, garbage collection is run in the background by the JVM. **There is no way we can explicitly force garbage collection to happen**, but we can *request* garbage collection to be run through the use of one of the following:
* `System.gc()`
* `Runtime.getRuntime().gc()`
* `System.runFinalize()`
