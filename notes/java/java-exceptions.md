# Module - Java Exceptions

## Exceptions
When an exceptional condition occurs in the course of a Java program, a special class called an `Exception` can be **thrown**, which indicates that something went wrong during the execution of the program. If the exception is not handled anywhere in the program, it will propagate up through the call stack until it is handled by the JVM which then terminates the program.

### Exception Class Hierarchy
![Exceptions hierarchy](https://i.pinimg.com/originals/a6/ab/f3/a6abf35c5fbbb57ebd4e949945839f31.jpg)

The exception class hierarchy starts with the `Throwable` class which inherits from `Object`. Any object which is a `Throwable` can be "thrown" in a program by the JVM or by the programmer using the `throws` keyword. The `Exception` and `Error` classes both extend `Throwable`. An `Error` represents something that went so horribly wrong with your application that you should not attempt to recover from. Some examples of errors are:
* `ExceptionInInitializerError`
* `OutOfMemoryError`
* `StackOverflowError`

`Exception` is a general exception class which provides an abstraction for all exceptions. There are many subclasses of `Exception`, as shown above.

#### Unchecked vs Checked Exceptions
The `Exception` class and all of its subclasses, except for `RuntimeException`, are known as "checked exceptions". These represent occasions where it is reasonable to anticipate an unexpected condition, like a file not existing when attempting to write to it (which would result in a `FileNotFoundException`). **Checked exceptions are required to be handled or declared by the programmer** - otherwise, the code will not compile.

`RuntimeException` is a special type of exception - it, and all of its subclasses - are known as "unchecked exceptions". An **unchecked exception** is an exception that **is not required to be handled or declared** like checked exceptions are. Some examples include:
* `ArithmeticException` for illegal math operations
* `IndexOutOfBoundsException` for if you reference an index that is greater than the length of an array
* `NullPointerException` for if you attempt to perform an operation on a reference variable that points to a `null` value

#### Handling / Declaring Exceptions
When risky code is written that has the possibility of throwing an exception, it can be dealt with in one of two ways:
1. Handling means that the risky code is placed inside a try/catch block
2. Declaring means that the type of exception to be thrown is listed in the method signature with the `throws` keyword. This is also called "ducking" the exception - you let the code which calls the method deal with it.

## `try/catch/finally` Blocks
In order to handle exceptions that could be thrown in our application, a `try/catch` block can be used. The `try` block encloses the code that may throw an exception, and the `catch` block defines an exception to catch and then runs the code inside only if that type of exception is thrown. We can optionally include a `finally` block which will run whether an exception is thrown or not. A simple example is shown below:
```java
try {
  object.someRiskyMethodCall();
} catch(Exception e) {
  System.out.println("phew! that was close!");
} finally {
  System.out.println("I'll run whether there was a problem or not!");
}
```

### `try/catch/finally` Block Rules
Catch and finally blocks have several different rules which must be followed:
* Multiple catch blocks are allowed. More specific exceptions must come before more general exception types.
* Multi-catch blocks (catching more than one exception in a given block) are allowed, exception types are separated by `|`
* The `finally` block is optional
* A `try/finally` block only IS allowed, but a `try` block by itself is not
* A `finally` block will always execute, unless of course `System.exit()` is called

### Try-With-Resources
Try with resources is a newer syntax for try blocks. This is for convienence, we can instantiate objects of any class that implements the `AutoClosable` interface. This interface makes a promise, that the necessary methods will be implemented in order for the JVM to close and garbage collect these resources once the try-catch block ends.

```java
try(Connection connection = ConnectionUtil.getConnection()) {
	logger.info("Connection successful");
} catch (SQLException e) {
	logger.error("Couldn't connect to the database", e);
}

```

## Custom Exceptions
A programmer can create custom exceptions in Java by extending any exception class. If you extend `RuntimeException`, however, you will be creating an unchecked exception. This is a good idea if you do **not** want other code to have to handle your exception being thrown. If you do always want to require your exception to be handled, then create a checked exception by extending any existing one, or the `Exception` class itself.

```java
public class MyCheckedException extends Exception {}
public class MyUncheckedException extends RuntimeException {}

public class ExceptionThrower {

  public static void main(String[] args) {
    try {
	  throw new MyCheckedException("uh oh");
	} catch(MyCheckedException e) {} // we're just ignoring it here
	
    if ( 100 > 1) {
	  throw new MyUncheckedException("you're not required to handle me!");
	}
  }
  
  public static void declareChecked() throws MyCheckedException {
    throw new MyCheckedException("this one is declared!");
  }
}
```
