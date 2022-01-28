# Component Scanning Stereotypes
@Bean is used to annotate methods which return objects which Spring will manage as a bean. @Component is used to annotate classes which Spring will scan in order to define beans.

## @Component
This is the basic annotation that allows Spring to detect our beans with component scanning. The other three are derived from this one. Marking a class with @Component or another stereotype annotation, and including that class in component scanning will cause Spring to create beans from that class in accordance with your description of a bean. You can describe other bean behaviors with annotations, things like @Scope and @Lazy.


## @Repository
Indicates this component is a repository, "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects." -Domain-Driven Design (Evans, 2003)
The `@Repository` annotation marks a class to be used as a for use with storing data within a repository or database. Specifically, the `@Repository` annotation provides benefits for objects that would otherwise be utilized as a Data Access Object (DAO).
## @Service
Indicates this component is a service, "an operation offered as an interface that stands alone in the model, with no encapsulated state." -Domain-Driven Design (Evans, 2003)

## @Controller
Indicates this component is an MVC controller, which handles requests and responses. Frequently used in combination with @RequestMapping.
The `@Controller` annotation marks a class as a Spring MVC Controller which allow the use of handlder mapping annotations. Classes annotated with `@Controller` are autodeteced through classpath scanning, and when used in comination with `@RequestMapping`, allows for quick configurations of a web application controller.

### @RestController
This is a specialization of @Controller, it simply combines @Controller with @ResponseBody.



See also:
[Spring stereotype doc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/package-summary.html)
[Stereotypes](https://gitlab.com/revature_training/spring-team/-/blob/master/modules/framework/stereotypes.md)
