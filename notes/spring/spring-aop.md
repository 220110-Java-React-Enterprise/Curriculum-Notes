# Aspect Oriented Programming

## Aspect Oriented Programming and Cross Cutting Concerns
Aspect Oriented Programming is another way to think about structuring your program, which can be used complementary to Object Oriented Programming. In object oriented programming, classes are used as the key component used to drive the creation of objects, which serve the purpose of representing concrete ideas or things with states and behaviors. In Aspect Oriented Programming, the key component are aspects, which modularizes particular transactional concerns which can present across multiple classes, known as _cross-cutting concerns_. Examples of these concerns are, Database Access (security for a database), data entities (transactions to take place), error handling, or logging system messages. The defining characteristic of these _cross-cutting concerns_ is that they are actions that can take place across your classes, regardless of the class function or structure. In traditional object oriented programming, this would result in code redundancy, as the same code must be called multiple times throughout an application to perform these actions. Aspect Oriented Programming works to eliminate this redundancy by transferring responsibility of these common problems to aspects. Note that the Spring IoC Container is not dependent on AOP; however, the Spring AOP framework complements the IoC Container by providing a capable middleware solution for concerns.

### Important Terminology
* _Aspect_ - A representation of a concern which cuts across multiple classes.
* _Weaving_ - The process of linking aspects with other objects, such as beans, to create advised objects. This can be done at compile time (such as when using the AspectJ compiler), load time or runtime. Spring performs weaving at Runtime.
* _Join Point_ - A specified moment during the execution of a program, such as the invocation of a method, in which actions can be taken.
* _Advice _ - Action taken by an aspect at a specified Join point. 
* _Pointcut_ - A definition of which methods in our application advice ought to be injected into or around, for example, when a method of a certain name is executed. By default, spring uses AspectJ pointcut expression language.
* _Introduction_ - Declaration of new interfaces and corresponding implementations in subclasses of any advised object. Introductions use the `@DeclareParents` annotation with the _defaultImpl_ attribute to define a default concrete class for the bean definition. For Example:

__IFunction Interface__:
```java
package com.revature.examples;

public interface IFunctional {
    public void function();
}
```

__FunctionalDefault__:
```java
package com.revature.examples;

public class FunctionalDefault implements IFunctional {
    public void function() {
        System.out.println("This is the default function");
    }
}
```

__Aspect__:
```java
package com.revature.examples;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectExample {
    @DeclareParents(value="com.revature.examples.*+",defaultImpl=FunctionalDefault.class)
    public static IFunctional iFunctional;
}
```
The '+' after the package is used to match the class (or interface) and all subclasses. This pointcut expression will match any interfaces or classes defined in the package `com.revature.examples` and also any subclass or implementing class of these classes, even if the implementing class or subclass is in another package.
* _Target Object_ - The object which is being advised by one or more aspects. The Spring AoP is implemented using proxies, and as such, this target object will always be a proxied object.
* _AOP Proxy_ - An object created in an AoP framework in order to implement advice defined in aspects. The utilization of these proxies allows for loose coupling between your advice targets. The Spring AoP framework supports JDK dynamic proxies (which is interface based) as well as a CGLIB proxy (which is class based).

Below is a visual representation of how the Spring Transaction proxy works:

![Spring Transactional Proxy](./../images/transactional-proxy.png)

At a high-level, when a method is invoked an AOP Proxy is informed, which informs the associated Advisor (in this case a transaction advisor). This advisor implementation can then inject advice as needed (based on configuration) before, or after invoking the target method. Note that additional custom advisors can come before or after the transaction advisor is run.


## `@AspectJ`
`@AspectJ` refers to a style of declaring aspects through the use of regular Java classes with annotations. `@AspectJ` style was introduced in the AspectJ 5 release of the AspectJ Project. Note that Spring interprets the same annotations as AspectJ 5, using a library supplied by AspjectJ, however Spring's AOP runtime is not dependent on the AspectJ compiler or weaver.

## Enabling `@AspectJ`
To utilize `@AspectJ` aspects in a Spring configuration, you need to enable support for configuring the Spring AOP based on `@AspectJ` aspects and _autoproxying_ beans which are advised by those aspects. Autoproxying means that Spring will automatically generate a proxy to intercept method invocations when a bean is advised by one or more aspects to ensure that advice is executed as needed.

`@AspectJ` configurations can be enabled using either XML or Java-based Spring configuration. In either case, you will need to make sure that the AspectJ _aspectweaver.jar_ is on your application's classpath (version 1.6.8 or later is required for Spring 4.0.x). 

This can be done by adding the following dependency within your Maven Pom file:
```xml
<dependency>
	<groupId>org.aspectj</groupId>
	<artifactId>aspectjweaver</artifactId>
	<version>1.6.8</version>  <!-- or a later version... -->
</dependency>

```

For XML based configurations you must use the `aop:aspectj-autoproxy` element:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.3.xsd">
	
	<!-- This element enables AspectJ autoproxy -->
	<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

	<!-- other configurations below... -->
</beans>
```

For Java based configurations, AspectJ is supported through the use of the `@EnableAspectJAutoProxy` annotation within your `@Configuration` annotated class:
```java
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

}
```


## Pointcuts and Join Points
Recall the pointcuts determine join points, in that they define which methods in our application advice ought to be injected into or around, while join points are the specific moment during the execution of a program in which the advice can be taken. Though these may sound similar, you can think of the relationship between pointcuts and join points in that pointcuts determine which _methods_ in your application advice should take place and join points determine which _package or class_ that advice should take place.

Pointcuts are comprised of two parts: a name, and any parameters. Additionally, keep in mind that pointcut expression determine _exactly_ which method execution we are interested in. In Spring AOP, pointcut expressions use annotations with regular method signatures, and are indicated using the `@Pointcut` annotation. To use this annotation you must import the `org.aspectj.lang.annotation.Pointcut` class. Note that methods serving as the pointcut signature _must_ have a return type of `void`.

The Spring AOP supports the following pointcut designators:
* _execution_ - Used to match a method execution join point. This is the primary pointcut designator used. More detail on this expression can be found below.
```
@Pointcut("execution(public String getName())")
public void executionExample() {}
```
* _within_ - Limits method execution to those of a matching type.
```
@Pointcut("within(com.revature.examples.*)")
public void executionExample() {}
```
* _this_ - Limits method execution where the bean referenced is an instance of the specified type.
```
@Pointcut("this(com.revature.examples.ExampleService)")
public void executionExample() {}
```
* _target_ - Limits method execution where the target, proxied object, in an instance of a given type.
```
@Pointcut("target(com.revature.examples.ExampleService)")
public void executionExample() {}
```
* _args_ - Limits method execution where the arguments are instances of the given type.
```
@Pointcut("java.io.Serializable")
public void executionExample() {}
```
* `@target` - Limits method execution where the class of the executing boject has an annotation of the given type.
```
@Pointcut("@target(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```
* `@args` - Limits method execution where the runtime type of the actual arguments passed have annotations of a given type.
```
@Pointcut("@args(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```
* `@within` - Limits method execution within types that have a given annotation.
```
@Pointcut("@within(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```
* `@annotation` - Limits method execution where the join point has a given annotation.
```
@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
public void executionExample() {}
```

## Parameter Patterns for _execution_ expression
As stated previously, the _execution_ expression is the most widely used pointcut designator. As such, it is key to understand the specific syntax for this expression:
```
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)
            throws-pattern?)
```
Note that only the return type pattern, name pattern and parameter patterns are required. Additionally, when declaring these patterns it is possible to use wildcard indicators (*) to substitute all or parts of these patterns. As you may guess, the return type pattern indicates a specific type of data returned by the method must match in order for the join point to be matched. Often this return type will use the \*, or wildcard, to specify any return type for a given method. The name pattern specifies that a name must match. Note that this name may also use a * to substitute part or all of the name for a given method. The parameters pattern is slightly more complex. () indicates a method that takes no parameters, whereas (..) specifies a method with any number of parameters (zero or more). The wildcard * specifies the type of parameter, while listing the specific type requires the type to match at that parameter index. For instance: (*,String) matches methods which take two parameters, the first can be any type, while the second must be a String.

```
execution(public String getName())
```
This point cut specifies a public method (note this `public` access modifier is optional) named _getName_ that returns String data.

```
execution(public * getName())
```
This pointcut specifies any public method that returns any type of data, so long as the method is named _getName_.

```
execution(* get*())
```
Here, the pointcut matches a method of any return type whose name begins with '_get_'

```
execution(* set*(*))
```
This pointcut matches methods whose name begins with '_set_' which take one argument of any type

```
execution(void com.revature.*.set*(..))
```
Note that you can also use fully qualified type names, and wildcards for these names as well. This pointcut matches any method who name begins with '_set_' (which returns void) within any package from com.revature (such as com.revature.service, com.revature.dao, com.revature.examples, etc...), and can take any number of parameters.

# Advice


## Types of Advice
Advice is specific actions taken, defined as a method, at a particular point during the execution of a program. There are five (5) types of advice, which controls at what point the action will take place.

* __Before__ - Advice that will execute before a join point, but does not have the capability to halt the normal execution of the proceeding join point (unless an exception is thrown)
* __After Returning__ - Advice that will execute after a join point completes without throwing an exception
* __After Throwing__ - Advice that will execute if a join point throws an exception.
* __After (finally)__ - Advice that will execute regardless of how the join point completes, whether normal or by throwing an exception.
* __Around__ - Advice that will execute before and after the join point. Around advice is the most general, but also most powerful kind of advice, as it can perform custom behavior before and after method invocation, and can be responsible for choosing whether to proceed to the join point method execution or shortcut the advised method by returning its own value or throwing an exception. In general it is recommended to use the least powerful type of advise for any particular task. For instance, if you only need to update a cache with a value returned from a method, it is best to use the _After Returning_ advice type.

All of these annotations, including the `@Aspect` annotation must be imported from the `org.aspectj.lang.annotation` pacakage.

### Before
_Before_ advice is declared using the `@Before` annotation:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExample {

    @Before("com.revature.example.dataAccessOperation()")
    public void doAccessCheck() {
        // ...
    }

}
```

### After Returning
_After Returning_ advice is declared using the `@AfterReturning` annotation:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class AfterReturningExample {

    @AfterReturning("com.revature.example.dataAccessOperation()")
    public void doAccessCheck() {
        // ...
    }

}
```

Note that you can also bind `@AfterReturning` a returned value to the advice in order to access information from it (such as storing its value, or printing information specific to the returned data). This binding is declared using the `returning` attribute in the pointcut:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class AfterReturningExample {

    @AfterReturning(
        pointcut="com.revature.example.dataAccessOperation()",
        returning="retVal")
    public void doAccessCheck(Object retVal) {
        // ...
    }
}
```
Here, "retVal" is the name given to the object being returned, and is referenced in the method signature of the `doAccessCheck` method by the same name.


### After Throwing
As you may assume, _After Throwing_ advice is declared with the `@After Throwing` annotation:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AfterThrowingExample {

    @AfterThrowing("com.revature.example.dataAccessOperation()")
    public void doRecoveryActions() {
        // ...
    }

}
```

Similarly to `@AfterReturning`, you may reference a thrown exception within the advice through the use of the _throwing_ attribute, which allows you to reference the exception within the method signature of the advice by corresponding an argument in the method signature with the name declared with the _throwing_ attribute:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class AfterThrowingExample {

    @AfterThrowing(
        pointcut="com.revature.example.dataAccessOperation()",
        throwing="ex")
    public void doRecoveryActions(DataAccessException ex) {
        // ...
    }

}
```

### After (finally)
_After_ advice is declared using the `@After` annotation. Since it will execute after normal or exceptional completion of a method, you must make sure any `@After` advice is configured to handle both conditions:
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;

@Aspect
public class AfterFinallyExample {

    @After("com.revature.example.dataAccessOperation()")
    public void doReleaseLock() {
        // ...
    }

}
```

### Around
```java
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundExample {
    private static Logger log = Logger.getLogget(LoggingAspect.class);

    @Around("com.revature.example.dataAccessOperation()")
    public void performAroundAdvice() {
        log.info("This is Around Advice");
    }
}
```


### References
* [Spring 4.0.x Framework Documentation - AOP with Spring](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html)
* [Spring 4.0.x Framework Documentation - AOP API](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop-api.html)
* [JavaDocs API - Spring 4.0.x](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/overview-summary.html)
* [AspectJ API Docs](https://www.eclipse.org/aspectj/doc/released/runtime-api/index.html)
* [AspectJ API Docs - Annotations](https://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/index.html)
* [Spring 4.0.x Documentation - AspectJ](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-ataspectj)
* [AspectJ Project](https://www.eclipse.org/aspectj/)
* [AspectJ API Documentation - lang package](https://www.eclipse.org/aspectj/doc/released/runtime-api/index.html)
* [AspectJ API Documentation - annotations](https://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/index.html)
* [Spring 4.0.x Documentation - Advice](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-advice)
* [Spring 4.0.x Documentation - Pointcuts](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/aop.html#aop-pointcuts)

