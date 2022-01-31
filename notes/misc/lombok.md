# Lombok

According to the official website, "Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java. Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more." Project Lombok isn't unique to Spring. Lombok can be used with vanilla Java however, Lombok and Spring have a common goal; reduce the amount of boilerplate code by autogenerating the required code elements at compiletime.

## Why use Lombok

First lets define boilerplate code. Boilerplate code is code that must be included in many places with little to no alteration. Prime examples of Java boilerplate code.

- Getters and Setters
- No Arg Constructors
- toString
- Equals
- Hashcode
- Logging Variables

Next, why do we want to reduce writing boilerplate code? Writing boilerplate code is tedious, easily overlooked, reduces testing coverage, and muddies up code. Lombok exposes a host of annotations that makes generating this code easy while aleviating the above issues.

## Lombok usage

The following assumes the use of Lombok with Spring. It is required to used the library with Spring, but this is where we are right now. Please refer to the official documentation for learning how to install the library and required plugins for your IDE and project workflow. In the examples below I have the plugin for my IDE (IntelliJ) and I have Lombok as a project dependency in the pom.xml.

```java
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
  private String title;
  private String isbn;
  private String[] authors;
  private LocalDateTime publicationDate;
}
```

The above code creates a Java model class for a book. The use of the `Lombok` annotations will automatically generate the require code elements during compile time. In this case since the annotations are above the class, specifically the `@Getter` and `@Setter` annotations, the generated code will cover the whole class. So a getter and setter for each field.

| Annotation         | Purpose                                               |
| ------------------ | ----------------------------------------------------- |
| @Getter            | Generates a getter method for each field              |
| @Setter            | Generate a setter method for each field               |
| @NoArgsConstructor | Generate a no argument constructor for the class      |
| @ToString          | Generate a toString method for the class              |
| @EqualsAndHasCode  | Generate and equals and hashCode method for the class |

```java
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
  private String title;
  private String isbn;
  private String[] authors;
  private LocalDateTime publicationDate;

  @Getter(AccessLevel.NONE)
  @Setter
  private Double commissionRate;
}
```

The above code example is similar to the previous one meaning Lombok will provide a getter and setter for each field. However the commissionRate field's getter method will not be accessible. You can pass an AccessLevel to either the `@Getter` and `@Setter` or both. This is useful when you want to create readonly or writeonly fields.

The previous examples uses a lot of the Lombok annoations and it will be easy to assume that the `Lombok` annotations will become boilerplate code in short order. `@Data` is a shortcut annotation that includes the following annotations

- @Getter
- @Setter
- @ToString
- @EqualsAndHashCode
- @RequiredArgsConstructor

### What about Autowiring with Spring

Although Spring and Lombok won't clash too much in most occassions, there is one feature of Spring that Lombok will not handle by default, and this will cause problems at runtime, Autowiring. Because the code is generated for you at compile time, you will have to tell `Lombok` to add the `@Autowired` annotation.

```java
@Repository
@NoArgsConstructor
public class BookRepository {...}

@Service
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class BookService{
    private BookRepository bookRepository
}
```

The above code creates the BookRepository and BookService classes. There is a dependency graph BookRepository -> BookService. The BookService requires the BookRepository, but the constructor is going to be generated for us. The onConstructor attribute takes a list of annotations to add to the constructor's signature.

```java
@Repository
@NoArgsConstructor
public class BookRepository {...}

@Service
@NoArgsConstructor
public class BookService{
    @Setter(onMethod=@__(@Autowired))
    private BookRepository bookRepository
}
```

The above example is similar to the previous example, but uses setter injection.

WEIRD NOTE!!! The syntax `@__` is for a backward compatibility issue with `javac 7` [Read More on @\_\_](https://projectlombok.org/features/experimental/onX.html).

### References

- [Lombok](https://projectlombok.org)
