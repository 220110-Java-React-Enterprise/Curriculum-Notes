## Collections Framework
The Collections framework in Java is a set of classes and interfaces that implement commonly used data structures. A collection is a single object which acts as a container for other objects. The Collections API is organized in a class hierarchy shown in simplified version below:

![Collection API class hierarchy](https://javaconceptoftheday.com/wp-content/uploads/2014/11/CollectionHierarchy.png)

The important interfaces in the Collections API are:
* `Iterable` - guarantees the collection can be iterated over
* `List` - an ordered collection
* `Set` - a collection does not contain duplicates
* `Queue` - a collection that operates on a first-in-first-out (FIFO) basis
* `Map` - contains key/value pairs. Does not extend `Iterable`.

## Collections Class
The [Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html) class - not to be confused with the Collection interface - defines many `static` helper methods which operate on any given collection. Use this class for help with sorting, searching, reversing, or performing other operations on collections.


## Iterable and Iterator Interface
The `Iterable` interface defines a data structure which can be directly traversed using the `.iterator()` method, which returns an `Iterator`. This can be useful for fine-grained control over iteration. The `Iterator` interface contains methods for traversal, including:
* `hasNext()`
* `next()`
* `remove()`

For example:

```java
Set<String> names = new ArrayList<>();
// add names...
Iterator<String> it = names.iterator();
while (it.hasNext()) {
  String name = it.next();
  doSomething(name);
}
```

### Enhanced For Loop
Any object which implements the `Iterable` interface can also be iterated over using a special kind of `for`-loop: the "enhanced" for loop. The syntax is as follows:
```java
Set<String> names = new ArrayList<>();
// add names...
for (String name : names) {
  System.out.println(name);
}
```
The downside of the enhanced for loop is that the index of iteration is not tracked, so fine-grain control over execution is not possible. However, this simplified syntax is beneficial for many simple iterations.

## Generics
Generics are constructs introduced in Java 5 which enforce compile time safety by allowing you to use parameterized types. They are covered here because the are frequently and heavily used with collections. Generics can be declared on a class (generic types), method parameters (generic methods), or return types.

Before Java 5, you had to write something like this and hope other developers understood to only put Strings inside: 
```
List names = new ArrayList();
names.add("Alice"); // good use
name.add(new Object()); // uh oh - we want to prevent this from happening
```

With generics, you can restrict a class to only accept objects of a given type and the compiler will prevent you from using any other type:
```
List<String> names = new ArrayList<>(); // using a List of Strings only
names.add("Alice"); // nice!
names.add(new Object()); // now we get a compilation error to stop this - generics save the day!
```

### Generic Classes
To make a class (or interface) generic, use the angle brackets when declaring it, and use an arbitrary "generic type" which is determined by the invoking code. The generic type can then be reused throughout the class to enforce type safety.

```java
public class MyGenericClass<T> {
  private T instance;
  
  // simple generic setter method
  public void setObject(T object) {
    this.instance = object;
  }
}
```

### Naming Convention for Generics
Technically, type parameters can be named anything you want. The convention is to use single, uppercase letters to make it obvious that they are not real class names.
* E => Element
* K => Map Key
* V => Map Value
* N => Number
* T => Generic data type
* S, U, V, and so on => For multiple generic data types


## List Interface
A `List` is a collection that is ordered and preserves the order in which elements are inserted into the list. Also, elements are accessed by their index, which begins with 0 for the first element in the list.

### Vector
`Vector` is an older class which implements `List` - it is essentially a thread-safe implementation of an `ArrayList`.

### Stack
`Stack` is an older implementation of the stack data structure (last-in-first-out, or LIFO). Generally you should use an `ArrayDeque` for implementing a stack.

### ArrayList
An `ArrayList` is a concrete class which implements `List`. It is a data structure which contains an array within it, but can resize dynamically. Once it reaches maximum capacity, an `ArrayList` will increase its size by 50% by copying its elements to a new (internal) array. Traversal is fast (constant time) because elements can be randomly accessed via index, just like an array. Insertion or removal of elements is slow, however (linear time, since there is a risk of having to resize the underlying array).

### LinkedList
A `LinkedList` implements both the `List` and `Queue` interfaces, so it has all methods in both interfaces. The data structure is composed of nodes internally, each with a reference to the previous node and the next node - i.e. a doubly-linked list. Because of this structure, insertion or removal of elements is fast (no risk to resize, just change the nearest references), but traversal is slow for an arbitrary index.


## Map Interface
Map does not implement the Collection interface, however it is considered to be part of the Collections framework. It is used to identify a value by a key, and each entry in a map is a key-value pair. Because it does not implement `Iterable`, Maps cannot be iterated over directly. Instead, one must either:
* use the `entrySet()` method to iterate over the set of `Map.Entry`
* use the `keySet()` method to iterate over the set of keys
* use the `values()` method to return a `Collection` of values which can then be iterated over

### HashMap
`HashMap` is a Map which:
* Stores elements in key-value pairs
* Insertion/Retrieval of element by key is fast
* Tradeoff is that it does not maintain the order of insertion
* Permits one null key and null values

### TreeMap
`TreeMap` is a Map whose:
* Keys are stored in a Sorted Tree structure
* Main benefit is that keys are always in a sorted order
* Insertion/Removal are slow
* Cannot contain null keys as null cannot be compared for sorting

### HashTable
`HashTable` is an older, thread-safe implementation of a `HashMap`. It does not allow null keys or null values.

## Set Interface
`Set` is an interface which defines a data structure which:
* is NOT index driven
* only allows unique elements
* generally DOES NOT preserve the order in which elements were inserted

## Queue Interface
A `Queue` is a data structure used when elements should be added and removed in a specific order. Unless specified, elements are ordered FIFO (first-in-first-out). Some useful methods declared are:
* `offer()`
* `peek()`
* `poll()`
## Comparable and Comparator Interfaces
[`Comparable`](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) is an interface which defines the natural ordering for a class. A class must implement `Comparable` if it is to be sorted by the `compareTo()` method.
```java
public interface Comparable<T> {
	public int compareTo(T o);
}
```

The `compareTo()` method returns an `int` which is:
* Zero, if the two objects are equal
* Negative, if this object is smaller than that
* Positive, if this object is greater than that

[`Comparator`](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html) is an interface which allows you to define a total ordering on some collection of objects. A class that is to be sorted by `compare()` does not have to implement `Comparator`.
```java
public interface Comparator<T> {
	public int compare(T firstObject, T secondObject);
}
```
