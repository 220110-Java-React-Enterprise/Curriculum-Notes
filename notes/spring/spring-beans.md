# Spring Beans
What is a bean? A bean is an object that is instantiated and managed by the Spring IoC container. The purpose of beans is Dependency Injection, to achieve loose coupling.

## Inversion of Control & Dependency Injection
What is Inversion of Control? This is a programming technique that reverses the idea of control. Instead of your program running the show and making all the desicions about execution, you hand off control to some other entity or entities. In our case we are talking about managing dependencies, we give control to a Spring IoC container to do dependency injection. In this way we achieve loose coupling.

## Loose Coupling
So, what is loose coupling? This is an approach where components depend on eachother to the least extent possible. For us today, that means any dependent objects are instantiated elsewhere and provided to our object via constructors or setters. These objects are our beans. They are instantiated by the IoC container, and are provided via dependency injection.

## Put it all together
So now, to wrap this all together: We invert control, giving it to the IoC container which can then manage our beans and do dependency injection so that we can achieve looser coupling. Why is all this necessary? To abstract away as much of the implementation details as possible. Spring is a giant framework and there are a lot of things going on, and a lot to learn about. But, without these techniques it would be significantly more difficult, and it would be far more difficult to deal with changes. These techniques are widely used throughout the Spring framework, and allow us to utilize an enormous number of features that can be changed and updated without troubling us. Spring offers modules that handle web service, data persistence, logging, security, basically anything that has wide use in enterprise java applications. For added context, read [Martin Fowler's write-up](https://martinfowler.com/articles/injection.html). 

Take web service for example. With just a few set up steps you can get a simple restful API up and running with Spring, by giving control of handling everything to spring. You configure settings like path and port, but you otherwise don't care about implementation. You don't have to instantiate objects and dependencies, spin up a thread pool, listen for incoming connections, establish sessions, and all that. You let Spring do all this for you, you hand control off to spring. The spring hands control back once a request is ready, you handle it, and hand control back to spring. If you need to persist data you can set up your object and hand control off to Spring JPA. If you encounter a problem at any point you can hand control off to spring to log info.


## Bean Lifecycle
The management of beans, conducted by the BeanFactory or Application Context, includes instantiation, configuration, and the eventual removal (or destruction) of beans. As a high-level overview:
1. Bean is instantiated
1. Bean properties are set
1. Associated interfaces are made aware of the beans existence
1. The bean is made aware of any associated interfaces as well
1. Initialization methods, including custom ones, are invoked
1. Then the bean is ready for use
1. Once the bean is no longer used, it is marked for removal and a destroy method is invoked for the bean
1. Custom destroy methods are invoked, if any
1. Bean is the destroyed

The following is a visualization of this lifecycle:

![Spring Bean Lifecycle - Visualization](./../images/spring-bean-life-cycle.png)  
  

Specifically the lifecycle of a Spring Bean in an application context, pursuant to the associated interface methods is as follows:
#### Instantiation
 - Instantiate Bean
 - Populate bean properties

#### Awareness - Related Interfaces are made aware. This includes:
- [BeanNameAware's setBeanName](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/BeanNameAware.html) - Informs Bean Factory of Bean Name
- [BeanClassLoaderAware's setBeanClassLoader](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/BeanClassLoaderAware.html) - Callback to inform bean [class loader](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html?is-external=true) of bean. A Class loader is an object responsible for loading class.
- [BeanFactoryAware's setBeanFactory](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactoryAware.html) - Informs bean of their owning bean factory
- [EnvironmentAware's setEnvironment](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/EnvironmentAware.html) - Informs the bean of the environment in which it runs.
- [EmbeddedValueResolverAware's setEmbeddedValueResolver](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/EmbeddedValueResolverAware.html) - Informs bean of notifications from StringValueResolver, when embedded definition values are resolved.
 - If using an application context, the following are also made aware:
   - [ResourceLoaderAware's setResourceLoader](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/core/io/ResourceLoader.html)
   - [ApplicationEventPublisherAware's setApplicationEventPublisher](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/ApplicationEventPublisher.html)
   - [MessageSourceAware's setMessageSource](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/MessageSource.html)
   - [ApplicationContextAware's setApplicationContext](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/ApplicationContextAware.html)
   - [ServletContextAware's setServletContext (Specifically only applicable when running in a __web application context__)](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/context/ServletContextAware.html)

#### Initialization
- [postProcessBeforeInitialization methods of BeanPostProcessors](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html#postProcessBeforeInitialization-java.lang.Object-java.lang.String-) - Method called before bean initialization callback methods are invoked, but after bean has been populated with property values.
- [InitializingBean's afterPropertiesSet](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html#afterPropertiesSet--) - Method invoked by the owner bean factory after all bean properties have been set and satisfied Aware methods (BeanFactoryAware, ApplicationContextAware, etc...)
- [Custom init-method definition] - Custom Defined init method. Signature is `public void init()`. This method is detected by the [getInitMethodName Method](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/support/AbstractBeanDefinition.html#getInitMethodName--)
- [postProcessAfterInitialization methods of BeanPostProcessors](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanPostProcessor.html#postProcessBeforeInitialization-java.lang.Object-java.lang.String-) - Callback which allows post processor to decide whether to apply either the FactoryBean, created object or both through corresponding instanceof FactoryBean checks.

#### In-use
- Bean is ready for use.

#### On shutdown of a bean factory (or destruction of a bean), the following lifecycle methods apply:
- [postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/annotation/InitDestroyAnnotationBeanPostProcessor.html#postProcessBeforeDestruction-java.lang.Object-java.lang.String-) - Applies the bean's BeanPostProcessor before its destruction inclucking the invocation of custom destruction callbacks
- [DisposableBean's destroy](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html#destroy--) - Method invoked by bean factory (or ApplicationContext) when a bean is to be destroyed
- [Custom destroy-method definition] - Custom Defined destroy method. Signature is `public void destroy()`. This method is detected by the [getDestroyMethodName Method](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/support/AbstractBeanDefinition.html#getDestroyMethodName--)

It is worth nothing that Spring does not manage this entire lifecycle for all Beans, but rather only those which exist in particular [bean scopes](./bean-scopes.md).


# Component Scanning Stereotypes
@Bean is used to annotate methods which return objects which Spring will manage as a bean. @Component is used to annotate classes which Spring will scan in order to define beans.

## @Component
This is the basic annotation that allows Spring to detect our beans with component scanning. The other three are derived from this one. Marking a class with @Component or another stereotype annotation, and including that class in component scanning will cause Spring to create beans from that class in accordance with your description of a bean. You can describe other bean behaviors with annotations, things like @Scope and @Lazy.


## @Repository
Indicates this component is a repository, "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects." -Domain-Driven Design (Evans, 2003)  
The `@Repository` annotation marks a class for use with storing data within a repository or database. Specifically, the `@Repository` annotation provides benefits for objects that would otherwise be utilized as a Data Access Object (DAO).
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


### Resources
* [Spring 4.0.x Documentation - IoC Container and Beans](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html)
* [Bean Factory - Interface Documentation](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html)
* [Spring Bean Life Cycle - Tutorialspoint](https://www.tutorialspoint.com/spring/spring_bean_life_cycle.htm)
* [Lifecycle Image Reference](https://howtodoinjava.com/spring-core/spring-bean-life-cycle/)
