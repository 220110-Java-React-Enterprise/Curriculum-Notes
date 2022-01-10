# Keywords, Modifiers, and Operators


## Modifiers

We already saw two different **modifiers** on the `main` method above - one is an **access modifier** and the other is a **non-access modifier**. 

#### Access Modifiers

Access modifiers are keywords which define the ability of other code to access the given entity. Modifiers can be placed on classes, interfaces, enums, and class members. The access modifiers are listed below:

| Modifier | Access Level |
| --- | --- |
| `public` | Available anywhere |
| `protected` | Within the same package, and this class' sub-classes |
| default | Within the same package |
| `private` | Only within the same class |
<br>

The default access level requires additional clarification - this access level is "default" because **there is no keyword** to be used. This access level is also known as "package private".

Using `private` modifiers on instance variables - along with public getter and setter methods - helps with **encapsulation**, which is one of the pillars of object-oriented programming.

## Non-Access Modifiers

Java also has **non-access** modifiers which can be placed on various class members:
* `static` - denotes "class" scope, meaning the member resides on the class itself, not object instances.
  * `static` variables can be accessed through the class, e.g. `MyClass.staticVariable`
  * `static` methods can be called directly without needing an instance of the class, e.g. `MyClass.someMethod()`
* `final`
  * when applied to a variable, it means the variable **cannot be re-assigned**
  * when applied to a class, it means the class **cannot be extended**
  * when applied to a method, it means the method **cannot be overriden**
* `abstract`
  * when applied to a class, the class **cannot be instantiated** directly (instead, it should be *inherited*)
  * when applied to a method, only the method signature is defined, not the implementation. Also, the class where the method resides must also be abstract. Concrete subclasses **must implement the abstract method**.
* `synchronized` - relevant to threads and preventing deadlock phenomena (discussed in a separate module)
* `transient` - marks a variables as non-serializable, meaning it will not be persisted when written to a byte stream (discussed in another module)
* `volatile` - marks a variable to never be cached thread-locally. Obscure, rarely-used keyword.
* `strictfp` - restricts floating point calculations for portability. Obscure, rarely-used keyword.

Below is a class with various class members which have different modifiers associated with them:
```java
package com.revature.mypackage;

public class Example {
    // <-- this notation specifies a comment
	public boolean a; // this variable can be accessed anywhere, on an object of type Example
	protected byte b; // accessible within com.revature.mypackage or subclasses of Example
	static int c; // class scope with default access
	private String d; // can only be accessed within this class
	
	public static void main(String[] args) {
		Example myExample = new Example();
		myExample.printValues();
		// prints out the default values:
		// The value of a is: false
		// The value of b is: 0
		// The value of c is: 0
		// The value of d is:
	}
	
	public void printValues() {
		System.out.println("The value of a is: " + a);
		System.out.println("The value of b is: " + b);
		System.out.println("The value of c is: " + c);
		System.out.println("The value of d is: " + d);
	}
}
```
  
## Operators

| Operators | Precedence |
| --------- | ---------- |
| postfix | expr++ expr-- |
| unary |	++expr --expr +expr -expr ~ ! |
| multiplicative | * / % |
| additive | + - |
| shift | << >> >>> |
| relational | < > <= >= instanceof |
| equality | == != |
| bitwise AND | & |
| bitwise exclusive OR | ^ |
| bitwise inclusive OR | \| |
| logical AND | && |
| logical OR | \|\| |
| ternary | ? : |
| assignment | = += -= *= /= %= &= ^= |= <<= >>= >>>= |



## Full list of Keywords

- abstract
 - assert
 - boolean
 - break
 - byte
 - case
 - catch
 - char
 - class
 - continue
 - default
 - do
 - double
 - else
 - enum
 - extends
 - final
 - finally
 - float
 - for
 - if
 - implements
 - import
 - instanceof
 - int
 - interface
 - long
 - native
 - new
 - package
 - private
 - protected
 - public
 - return
 - short
 - static
 - strictfp
 - super
 - switch
 - synchronized
 - this
 - throw
 - throws
 - transient
 - try
 - void
 - volatile
 - while
