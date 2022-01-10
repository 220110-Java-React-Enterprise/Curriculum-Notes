# Module - Design Patterns

## Design Patterns
Design patterns are established general solutions to commonly occuring software development problems. They can be broadly categorized into:
* Creational
* Structural
* Behavioral

## Singleton Pattern
A Singleton is a design pattern which allows the creation of an object in memory only once in an application that instance is shared everywhere needed. It can be useful for services in an application, or other resources like a connection or thread pool.

To make a class into a Singleton, use:
1. `private static` variable of the class' type
2. `private` constructor - to prevent arbitrary object creation
3. `public static getInstance()` method, which will either instantiate the object or return the instance in memory
```java
    public class Singleton {
        // Private static variable of the class' type
        private static Singleton instance;

        // Private Constructor
        private Singleton() {}

        // Public static getInstance method
        public static Singleton getInstance() {
            if (instance == null) 
                instance = new Singleton();
            return instance;
        }
    }
```

## Factory Pattern
Factory is a design pattern which creates objects in which the precise type may not be known until runtime. To make a factory, use:
1. Abstract data type - (abstract class or interface)
2. Classes that inherit the abstract data type (the objects whose instantiation details may not be known until runtime)
3. Static method that returns a concrete instance, whose return type is the abstract data type in (1)
```java
    // Abstract Data Type
    public interface Dessert {}

    // Classes that inherit the abstract data type
    public class Cake implements Dessert {}

    public class Cookie implements Dessert {}

    public class IceCream implements Dessert {}

    // Good practice to throw an exception if the desired concrete instance is not found
    public class DessertNotFoundException extends RuntimeException {}

    // Factory class that returns the concrete instance
    public class DessertFactory {
        public static Dessert getDessert(String dessertType) {
            switch(dessertType) {
                case "cake":
                    return new Cake();
                case "cookie":
                    return new Cookie();
                case "ice cream":
                    return new IceCream();
                default:
                    throw new DessertNotFoundException(dessertType + " not found!");
            }
        }

        public class Demo {
            public static void main(String[] args) {
                Dessert d1 = DessertFactory.getDessert("cake");
                Dessert d2 = DessertFactory.getDessert("cookie");
                Dessert d3 = DessertFactory.getDessert("ice cream");
                Dessert d4 = DessertFactory.getDessert("candy");    // Throws DessertNotFoundException
            }
        }
    }
```

## Data Access Objects
When writing JDBC code, the application business logic may get mixed in with JDBC boilerplate code for querying the database, resulting in hard to read spaghetti code. One way to address this problem is to logically separate the code that accesses the database into Data Access Objects - this is referred to as the **DAO design pattern**.

To use the DAO design pattern, define an interface which declares methods through which the database will be queried. Then, concrete implementation classes can implement the interface and contain the data access logic to return the required data.

For example, if we have an Employee table in our database we'd like to query, we would create a `EmployeeDAO` interface:

```java
public interface EmployeeDAO {
  // define some CRUD operations here
  public List<Employee> getAllEmployees();
  public List<Employee> getEmployeesByLocation(String location);
  public void updateEmployeeById(int id);
  public void deleteEmployeeById(int id);
  public void addEmployee(Employee e);
}
```

This interface would be implemented for a specific database - e.g. Oracle:

```java
public class EmployeeDAOImplOracle implements EmployeeDAO {
  public List<Employee> getAllEmployees() {
    List<Employee> list = new ArrayList<>();
    // JDBC code here...
	return list;
  };
  public List<Employee> getEmployeesByLocation(String location) {
    List<Employee> list = new ArrayList<>();
    // JDBC code here...
	return list;
  };
  public void updateEmployeeById(int id) {
    // JDBC code here...
  };
  public void deleteEmployeeById(int id) {
    // JDBC code here...
  };
  public void addEmployee(Employee e) {
    // JDBC code here...
  };
}
```

Now whenever we need to query the Employee table in the database, we have a simple, clean interface which abstracts the data access logic:

```java
EmployeeDAO dao = new EmployeeDAOImplOracle();
List<Employee> allEmpls = dao.getAllEmployees();
allEmpls.forEach( e -> System.out.println(e));

List<Employee> NYEmpls = dao.getEmployeesByLocation("New York");
NYEmpls.forEach( e -> System.out.println(e));
```

Also, we can simply swap out the concrete class `EmployeeDAOImplOracle` for another database-specific class if we need to at some point in the future, since we rely only on the `EmployeeDAO` interface. The implementation doesn't even need to be talking to a database - it could be reading and writing to files for all we know! We don't care **how** the data is being read or written, we just care **what operations** are defined for the object. That is the benefit the DAO design pattern brings to the table.


## Dependency Injection
Another important design pattern which is widely used in frameworks across many languages is [**dependency injection**](https://en.wikipedia.org/wiki/Dependency_injection#Setter_injection) (DI), which is one form of a broader concept called [**inversion of control**](https://en.wikipedia.org/wiki/Inversion_of_control) (IOC). DI means that the *dependencies* of a class or object are *declared by the class and then injected* from its context instead of instantiating and relying directly on it.

There are several ways to inject dependencies:
1. [Constructor injection](https://en.wikipedia.org/wiki/Dependency_injection#Constructor_injection)
2. [Setter injection](https://en.wikipedia.org/wiki/Dependency_injection#Setter_injection)
3. [Interface injection](https://en.wikipedia.org/wiki/Dependency_injection#Interface_injection)

We'll show an example of constructor injection with two classes. If class `Foo` depends on a class `Bar`, the `Foo` class would NOT directly instantiate a `Bar` object. Instead, it would declare an instance variable of type `Bar` and have it injected. The code which uses `Foo` is then responsible for **injecting** an instance of `Bar` for `Foo` to use.

#### Before DI
```java
public class Foo {
  public void useBar() {
    Bar b = new Bar();
	b.doSomething();
  }
}
```

#### After DI
```java
public class Foo {
  Bar b;
  
  public Foo(Bar b) {
    this.b = b;
  }
  
  public void useBar() {
    b.doSomething();
  }
}

public class FooDriver {
  public static void main(String[] args) {
    Bar b = new Bar();
	Foo f = new Foo(b);
	f.useBar();
  }
}
```

### Benefits of DI
Dependency injection has many benefits, including:
* decoupling of code
* independent development - coding to interfaces allows concurrent development
* abstraction - no need to rely on concrete implementation
* easier to test - allows creation of stubs and mocks
* configuration can be externalized
