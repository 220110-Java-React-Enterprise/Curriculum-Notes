# Spring Lab
The purpose of this lab is to practice setting up a new spring boot application using the spring starter web and data dependencies. You will need to start a new spring boot project, connect to your datasource, expose an API, and test it with postman. When complete you should be able to do simple CRUD operations on simple objects. 

### Spring Initializer
Start with the [Spring Initializer](https://start.spring.io/) at start.spring.io, which will set up all the boilerplate files and code to get your spring application started. Make sure to select Maven, Java, and Java version 8. Fill in the other fields with relevant info for this project.  
  
Next add our starting dependencies:
 - Spring Web
 - Spring Data JPA
 - MariaDB

Next, click "generate" and you will receive a zip archive with the boilerplate project files inside. Pick an approporiate location for a new Java project and unzip the contents of this archive there. You now have a maven project ready to be opened up in IntelliJ.

### Spring Data
The first thing you will need to do is establish a connection to your datasource. Because we started with Spring Data JPA, the application won't even run successfully unless you can reach the datasource.  
  
You will need to add the relevant key/value pairs to the application.properties file. You will need to find the relevant connection info for the following items:

 - spring.datasource.url
 - spring.datasource.username
 - spring.datasource.password

You will also want to use the following key/value pairs:

 - spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
 - spring.jpa.database-platform=org.hibernate.dialect.MariaDB103Dialect
 - spring.jpa.generate-ddl=true
 - spring.jpa.hibernate.ddl-auto=create

With this in place you should be able to run your spring application and have it launch successfully. However, it doesn't do much of anything yet.

### Domain Objects
Before we can store anything in the database, we need things to store. Create one or more simple POJOs. Make sure to include a unique ID field. You may want to create several types of POJO class and have one hold a reference to another. This will cause Spring Data to establish a relation between the tables where theose objects are stored. Explore having one POJO hold a reference to another, and one POJO with a reference to a collection of another type of POJO. This will form one-to-one and one-to-many relationships respectively.  
  
Make sure your POJOs have:
 - A public no-args constructor
 - A private ID field
 - Several other private fields, just to give the POJO a reason to exist
 - public getters and setters for all fields.

Note: The terms Model and Entity both refer to objects we want to persist in our database. The term POJO is a design pattern for a class that has only private fields and public setters and getters. a POJO is just a holder for data, and contains no other behaviors. In this lab, our POJOs are our Entities/Models. 

Make sure to mark the POJO entities with the proper annotations:
 - `@Entity` - marks a class as an entity
 - `@Id` - marks a field as the primary key
 - `@Column` - marks a field as a database column
 - `@OneToOne` - marks one side of a one-to-one relation. It is not necessary to mark both sides.
 - `@OneToMany` - marks one side of a one-to-many relation. It is not necessary to mark both sides.
 - `@ManyToMany` - marks one side of a many-to-many relation.
 - `@GeneratedValue` - tells spring data JPA how to automatically assign field values.
Each of these annotations is from the `javax.persistence` package.

### Persistence
Now that we have objects to persist, we just need to add the logic that will persist these objects. Luckily, the most basic and common CRUD operations are already pre-built for us by Spring Data. All we need to do is create an interface that extends one of the JPA interfaces, like JpaRepository.  
  
These repositories we create are going to be beans, which means the spring IoC container will instantiate and manage them for us. Make sure to create a package somewhere to organize these beans. A good idea is to put all your packages in a package that will be the location component scanning starts. For instance, you could add a package called beans, and in beans add packages for entities and models. We can then tell our spring boot application to scan the beans package and all it's sub-packages. To do this, add the attribue `scanBasePackages` to the `@SpringBootApplication` annotation in the application class.  
  
To create a repository, add a new interface and make it extend `JpaRepository`. JpaRepository interface needs you to also fill out a type parameter list. The two type parameters to give are the type of the entity that this repository will work with, and the type of ID that entity uses. For instance, `public interface AccountRepo extends JpaRepository<Account, Integer>`.  Make sure to mark this as a `@Repository`.
  
When Spring scans for beans it will find our entities and repositories. It will create concrete classes with implementations for some basic CRUD functionality for you. For instance, some of the methods that you get for free without having to write are:
 - `save()`
 - `saveAll()`
 - `findById()`
 - `existsById()`
 - `findAll()`
 - `findAllById()`
 - `count()`
 - `deleteById()`
 - `delete()`
 - `deleteAll()`

Now we have our simple persistence logic set up. We can begin to test this functionality and make sure it works. 

### Testing
Let's test out our application so far. We are going to add some code to the main method to instantiate our entities and save them to the database by using the repository methods created for us. Because the repositories are beans, we need to get these beans from Spring. We have built a spring boot application, so we don't have direct access to the IoC container's context. We need to get access to this context object so that we can ask it for the beans.  
  
Let's create a new package under our beans package, we are going to add a class here that will get scanned by Spring that we can use to get the context. You might name this package `utilities` or something similar. Create a new class under that package and have it implement `ApplicationContextAware`. Here is what Spring docs have to say about this interface:  
  
*Interface to be implemented by any object that wishes to be notified of the ApplicationContext that it runs in. Implementing this interface makes sense for example when an object requires access to a set of collaborating beans.*  
  
So this class is a bean and will be made aware of the IoC container, the context, that it is running in. This will give us access to this context, and all the other beans inside. We just need to override the interface's important method: `setApplicationContext`. Make sure this class has a reference to an `ApplicationContext` object. Add a constructor that takes in a single parameter, an `ApplicationContext` object. Set the reference to that injected object in the constructor. Lastly create a public getter method to retrieve the context. It might be a good idea to make the reference and the getter static so it's a little easier for us to invoke it in main.  
  
Now in main we can use this class and it's static getter method to get the context. Once we have the context we can call `context.getBean()`. We need to provide this method with one parameter, the type of the bean we are asking for. Hand it off like a class, for instance `context.getBean(AccountRepo.class)`. Once you have your repo beans you can invoke those repo methods that spring wrote for us. Try to create a few of your entity objects and call the `repo.save(entityObject)` method on it. Check the database and see your objects persisted there. Take a look at the ERD too, see how your tables were built.

### Spring Web
Next we will be creating an API to expose our application's functionality to be consumed. We will create new types of beans called controllers, named for their place in the Model-View-Controller(MVC) pattern. Here in our curriculum we are more interested in building client-server applications that don't conform perfectly to the MVC pattern. Basically, we move the view part to the client, rather than having this logic on the server-side. Controllers abstract us away from the lower-level servlets, so while a controller is not the same thing as a servlet, you can consider that they fill a similar role in our application.  
  
Create a new package for controllers under the beans package, so that Spring will scan it. Each controller should represent a resource, so just like servlets, we should have one for each entity. These controllers should expose CRUD functionality for each entity. Just like servlets, we will map HTTP methods to class methods and our controller will invoke the necessary logic elsewhere in our application. Create a controller in the new package for each entity. Mark the controllers with the proper annotations:

 - `@Controller` - stereotype annotation that marks this as a controller bean
 - `@RestController` - shortcut, this annotation implies both `@Controller` and `@ResponseBody`
 - `@RequestMapping` - maps incoming HTTP requests to the controller class and methods. Can also specify the method and/or content-type.
 - `@RequestBody` - specifies that a parameter object should be marshalled from the http request body (using jackson to translate JSON)
 - `@ResponseBody` - specifies taht the returned value should be marshalled as JSON and transmitted in the response body.
 - `@PathVariable` - extract a token value from the URL
 - `@RequestParameter` - fetch value by key from URL parameter list
 - `@ResponseStatus` - Set a status for a successful request/response

Remember that some of these annotations can be applied to classes or methods. For instance, `@RequestMapping` when applied to the class sets the URL path that leads to that controller. Applying `@RequestMapping` to a method then specifies the URL path that leads to that method. So, if you marked your class with `"/accounts"` and a method with `"/getAccountByUserId"` then the path that leads to that method would be like `"something.com/contextpath/accounts/getAccountByUserId"`  
  
A basic restful controller that is invoked by a POST request sent to `"something.com/contextpath/accounts/213"` with a JSON representation of an Account object in the body might look like the below controller. This controller method creates a new resource from the JSON body and stores it in the database tied to User with the ID of 213.

```Java
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountRepo accountRepo;
    private final UserRepo userRepo;

    @Autowired //spring provides our repos by autowiring them into this constructor
    public AccountController(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void newAccountForUser(@RequestBody Account account, @PathVariable Integer userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.addAccount(account);
            userRepo.save(user);
            accountRepo.save(account);
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }
}
```
*This example can be found in [spring-boot-demo](https://github.com/220110-Java-React-Enterprise/Curriculum-Notes/tree/main/demos/spring-boot-demo)*

Note:
 - The use of `Optional`. The CRUD methods that spring builds for us return Optionals, which are a facade class designed to avoid null checks.
 - The use of `@Autowired` to get us our Repository beans.
 - In one `@RequestMapping` we just give part of the URI, but in the other we mark that as `value`. It's only necessary to mark the URI with `value` if there are going to be other attributes in the annotation, in this case `method` is also present.

Use the annotations and the example above, as well as your notes, to complete the controllers. You should be able to cover all CRUD functionality for your domain objects.

### Consume The API
Test your controllers by building HTTP requests in postman that hit your endpoints. You can feel free to remove the logic we wrote in main to test persistence earlier. You should have the necessary logic for CRUD in your controllers, or perhaps in a service layer than your controllers invoke.

### Conclusion
Congratulations! At this point you (hopefully) have a fully functional Spring Boot application that can be used to persist domain objects by consuming an API. You should be able to take this project and layer more complexity onto it to produce your own applications.
