# JUnit

Writing application code is just one aspect of application development. How do we ensure that code we write works as we intend it to, without negative side-effects, and meets our functional and non-functional product requirements? The answer is to *test* the code we wrote.

## Introduction to Testing

Testing is a very broad term and encompasses many different strategies, levels, and techniques. You've probably done **manual testing** before simply by running your application code, providing some user input, and observing the resulting behavior of the system and noting any deviations from expectations. This kind of testing is effective in certain scenarios, but it doesn't scale well when you need to test the functionality of an application with 100s, 1000s, or 10s of thousands of lines of code, and be able to do so repeatedly in timely fashion.

To effectively test a non-trivial application, we can actually write test code which will test the functionality of our application code. When we are testing the smallest individual components of the application in isolation from other parts of the system, this is called **unit testing**.

## Unit Testing
Unit testing is the testing of individual software components in isolation from the rest of the system. This is done by writing unit tests which execute the code we want to inspect. When the code under test deviates from an expected outcome or behavior, the test will fail. If a test passes, it means the application performs as expected (unless there is a problem with the test itself). In Java, the most common unit testing framework is called JUnit.

## JUnit
JUnit is a Java framework for unit testing. JUnit has several annotations within the `org.junit` package that developers can use to create tests and setup test environments:
* `@Test` - declares a method as a test method
* `@BeforeClass` - declares a setup method that runs once, before all other methods in the class
* `@Before` - declares a setup method that runs before each test method
* `@After` - declares a tear-down method that runs before each test method
* `@AfterClass` - declares a tear-down method that runs once, after all other methods in the class

When writing a test method, JUnit helps us check the functionality of the code being tested by providing static `Assert` methods, of which there are many. A few include:
* `assertTrue()`
* `assertFalse()`
* `assertEquals()`
* `assertNotEquals()`
* `assertThat()`

Assertions verify that the state of the application meets what is expected. For example, to test a simple addition method:

```java
@Test
public void additionTest() {
  Assert.assertEquals(4, Calculator.addNumbers(2,2));
}
```

If the `.addNumbers()` method returns anything other than `4`, the test will fail. This will alert us that something is wrong in the logic of the method and we can then debug the issue. When we think we've fixed the problem, just run the test again and check that it passes.

**Note:** to avoid needing to reference `Assert` every time, we can use a `static import org.junit.Assert.*;` statement to import all `static` members of the `Assert` class.

### Ignoring Tests

To prevent a test from running, use the `@Ignore` annotation. Use this sparingly, however, because ignoring valid tests only means that you are pretending a problem does not exist. If tests are constantly ignored, you will have no guarantee that the application functionality has not regressed.

### Testing Best Practices
When it comes to testing code, a few best practices to follow include:
* [Utilize dependency injection](https://en.wikipedia.org/wiki/Dependency_injection)
* [Write testable code](https://www.toptal.com/qa/how-to-write-testable-code-and-why-it-matters)
* Use a mocking library like [Mockito](https://site.mockito.org/) for dependencies
* Measure your code coverage with a tool like [Jacoco](https://www.eclemma.org/jacoco/trunk/doc/maven.html)
* Externalize test data when possible (i.e. read in the test data from an external file or generate it dynamically)
* Generally, you want to use **only 1 assert statement per test** - this ensures you can pinpoint the defect when debugging
* Write deterministic tests (they shouldn't fail sometimes and pass other times - otherwise known as "flaky" tests)

## TDD
When developing software, it is important to ensure that most if not all of the code being written is tested to verify the functionality of the code. One way to ensure this is to follow a process called **test-driven development**, or TDD.

### TDD Process
The TDD process consists of writing unit tests first, **before** the application code has been written. Then, code can be written to make the test pass and the process can be completed for each piece of functionality required. Thus, the process is:
1. Write a unit test
2. Run the test => test will fail
3. Fix the test by writing application code
4. Retest until the test passes
5. Repeat

Following the TDD process can be useful for ensuring that a valid unit tests always exists for any class or method that is written. Later, when refactoring code, the unit tests give us confidence that we can change the source code without breaking existing functionality. If we mess up somewhere, when the unit tests are run we can pinpoint exactly where the problem lies. This makes debugging much easier.
