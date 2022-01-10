## Object class
We also saw earlier in the garbage collection example about an `Object` - this is a [special class](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html) in Java which is the root class from which all other classes inherit, either direcly or indirectly. Thus, all objects have at least the methods defined in the `Object` class:
1. `Object clone()`
2. `boolean equals(Object o)`
3. `void finalize()`
4. `Class<?> getClass()`
5. `int hashCode()`
6. `void notify()`
7. `void notifyAll()`
8. `String toString()`
9. `void wait()`
10. `void wait(long timeout)`
11. `void wait(long timeout, int nanos)`

### Object class methods

The `toString()` method is automatically called if you print an Object. Usually, this is overridden to provide human-readable output. Otherwise, you will print out `fully.qualified.ClassName@memoryAddress`

The `equals(Object o)` method compares two Objects. The `==` operator also compares objects, but only the memory address (i.e. will return `true` if and only if the variables refer to the exact same object in memory). By default, and unless you explicitly override it, the `equals` method simply calls the `==` operator.

The `hashCode()` method returns a hash code - a number that puts instances of a class into a finite number of categories. There are a few rules that the method follows:
* You are expected to override `hashCode()` if you override `equals()`
* The result of `hashCode()` should not change in a program
* if `.equals()` returns true, the hash codes should be equal
* if `.equals()` returns false, the hash codes do not have to be distinct. However, doing so will help the performance of hash tables.

Finally, the `.finalize()` method is called by the garbage collector when it determines there are no more references to the object. It can be overriden to perform cleanup activities before garbage collection, although it has been deprecated in newer versions of Java.
