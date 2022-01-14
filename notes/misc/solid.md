## SOLID
There are another set of design principles that are important for OOP languages and programs, which are defined by the acronym SOLID:
* **S**ingle responsibility principle
* **O**pen-closed principle
* **L**iskov substitution principle
* **I**nterface segregation principle
* **D**ependency inversion principle

### Single Responsibility Principle
This principle, articulated by Robert Martin, says that

> A class should have only a single responsibility, that is, only changes to one part of the software's specification should be able to affect the specification of the class.

This means that a class has a specific purpose, is responsible for one single piece of functionality, and should have only one "reason to change". This principle relates to encapsulation in that only fields and methods related to the "single responsibility" should be contained in the class.

### Open-closed Principle
This principle states

> Software entities should be open for extension, but closed for modification.

This means that entities like classes should be able to have its behavior extended without modifying the class itself. This is primarily accomplished through inheritance - allowing child classes to add onto the functionality of a base class.

### Listkov Substitution Principle
This principle was articulated by Barbara Liskov and is paraphrased as:

> Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program. 

We've already seen how important this is with polymorphism and abstraction - substituting a `Cat` for a `Dog` in our program should be straightforward, if both extend from the `Animal` class and our program uses the methods defined there.

### Interface Segregation Principle
This principle states that

> Many client-specific interfaces are better than one general-purpose interface.

This prevents clients from having to depend on methods they do not use. Breaking up our interfaces into smaller, more specific ones decouples our code and makes refactoring easier.

### Dependency Inversion Principle
Put succintly,

> One should depend upon abstractions, not concretions.

In other words, instead of having concrete dependencies in our classes, we should instead depend on abstractions like interfaces. This makes our code more loosely coupled and adds a layer of abstraction which increases the re-usability of higher-level modules.
