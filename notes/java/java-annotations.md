## Annotations
Java [annotations](https://en.wikipedia.org/wiki/Java_annotation) are special constructs you may see throughout Java code, which use the `@` symbol followed by the name of the annotation. These annotations provide metadata about the source code to the compiler and the JVM. They can be placed on classes, methods, interfaces, and other constructs - however some annotations are restricted to only being placed on certain types or class members.

Annotations can be used to enforce rules in the code, or to abstract some functionality provided by a library or framework. Java frameworks and libraries often process annotations using the Reflection API (covered in another module) to dynamically provide functionality to developers.

Java has a few built-in annotations you should be familiar with:
* `@Override` - declares the method must override an inherited method (otherwise, a compilation error occurs)
* `@Deprecated` - marks a method as obsolete (compilation warning if used anywhere)
* `@SuppressWarnings` - instructs compiler to supress compilation warnings
* `@FunctionalInterface` - designates an interface to be a functional interface (covered in another module)

[1]: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
[2]: https://en.wikipedia.org/wiki/Heap_(data_structure)
