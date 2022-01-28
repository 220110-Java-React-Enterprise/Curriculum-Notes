# Bean Scopes

Bean configuration files act similarly to the creation of a class file, in that it is a template which can be used to instantiate objects (in this case, Spring uses this configuration to create bean objects). This configuration also extends to the defined scope of those objects. As a reminder, a scope can be seen as a sub-section of a larger application, with certain defined values, properties and objects. When defining a bean in the configuration, you have the ability to define the scope as well. For XML configurations, use the scope attribute on the bean element. Otherwise you can use the `@Scope` annotation to override the default (Singleton) scope for configured beans.

With regard to Spring Beans, there are six scopes, four of which can only be by access when utilizing a web aware ApplicationContext. They are:
1. Singleton Scope (default) - Each bean definition is scoped to a single object instance per Spring IoC Container.
1. Prototype Scope - A single bean definition is scoped to a number of object instances.
1. Request Scope [Only valid with a web-aware ApplicationContext] - A single bean definition is scoped to the lifecycle of a single HTTP request. This means the HTTP request has its own instance of a bean created from a single bean definition.
1. Session Scope [Only valid with a web-aware ApplicationContext] - A single bean definition is scoped to the lifecycle of an HTTP Session.
1. Gloabl Session Scope [Only valid with a web-aware ApplicationContext] - A single bean definition is scoped to the lifecycle of a global HTTP session. Generally only valid when used in a portlet context.
1. Application Scope [Only valid with a web-aware ApplicationContext] - Scopes a single bean definition to the lifecycle of a ServletContext.

### [Singleton Scope](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes-singleton)
For a Singleton Scoped bean, the IoC container will create exactly one instance of a Spring bean per bean definition. Each of those singleton beans are then stored in a cache of singleton beans. When a named bean is requested, the associated bean within this cache is returned.

The Single Scope for beans is the default scope, meaning that if no scope is explicitly defined, the bean will be instantiated in this singleton scope.

### [Prototype Scope](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes-prototype)
For non-singleton beans, the prototype scope allows for the creation of a new bean instance each time a request for a specific bean definition is made.

As a general rule, the prototype scope should be used for stateful beans, while the singleton scope should be used for stateless beans.

It is also worth noting that, unlike the other scopes, Spring does not manage the complete lifecycle of beans within the prototype scope. The container will still instantiate, configure and assemble the prototype bean object, but at that point will hand this prototype off to the client, with no other records of the prototyped instance. As such, with regard to bean lifecycles, all initialization callback methods are called on every bean, regardless of scope, the same cannot be said for the destruction lifecycle callbacks.

### [Request Scope](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes-request)
For the Request scope, the Spring IoC Container will create a new instance of a bean, based on the associated bean definition for every HTTP request recieved. These beans are particular to individual requests, so when the request completes, the associated bean within the request scope will be discarded.

### [Session Scope](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes-session)
For the Session scope, the Spring IoC container will create a new instance of a bean, based on the associated bean definition, each time a particular HTTP Session is created. When the session eventually ends, the associated bean will be discarded along with it.

### [Global Session Scope](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes-global-session)
For the Global Session scope, similarly to the previous definitions, will create a bean, however, this applies only with regard to portlet-based web applications. The portlet defines the global Session that is shared among all portlets, and the IoC Container uses this global session definition to scope Beans described at the global session level. These beans are similarly discarded when the associated global portlet session concludes.

Note if you attempt to use the `Request`, `Session`, and `Global Session` scope within a regular Spring IoC container (such as the ClassPathXmlApplicationContext), you will get an IllegalStateException regarding an unknown bean scope.

### [Application Scope](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes-application)
Within an Application Scope, a Spring IoC Container will create a new instance of the bean based on the associated bean definition once for the entire web application. This is similar to a singleton bean, but has two important differences.
1. An application scope bean is a singleton for each ServletContext _not_ for each Spring _ApplicationContext_
1. Beans within the application scope are visible within the ServletContext meaning they can be used as an attribute for `ServletContext`

XML:
```
<!-- The following is redundant since the singleton scope is the implicit behavior -->
<bean id="exampleBean" class="com.revature.example.ExampleBean" scope="singleton"/>

<bean id="protoBean" class="com.revature.example.ProtoBean" scope="prototype"/>

<!-- etc... -->

```


Annotation:
```
@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton") // This is not required since this is implicit behavior
    public ExampleBean exampleBean() {
        // ...
    }

    @Bean
    @Scope("prototype")
    public ProtoBean protoBean() {
        // ...
    }

    // etc...
}
```

### Custom Scope
The above details the common recognized scopes, the bean scoping mechanism is extensible, allowing you to define your own custom scopes, or redefine an existing one. Note that the singleton and prototype scopes are exempt from this, and you cannot override these definitions; furthermore, it is considered bad practice to override the existing scopes at all.

To create your own custom scope you must implement the [`org.springframework.beans.factory.config.Scope` interface](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/beans/factory/config/Scope.html). This interfacce has four methods used to get and remove objects from the scope as well as register the object for later destruction. The method signatures are:

```
Object get(String name, ObjectFactory objectFactory)
```
This method returns the object from the underlying scope. For instance, a bean in the session scope would return that session-scoped bean, and if it does not already exist, will create a new instance of the bean after binding it to the session.

```
Object remove(String name)
```
This method removes an object from an underlying scope and return that object. For instance, in the previous example, this would remove the session-scoped bean from the associated session. This method should return null of the specified bean name cannot be found.

```
void registerDestructionCallback(String name, Runnable destructionCallback)
```
This method registers the destruction callback methods for the specified object when it is to be destroyed.

```
String getConversationId()
```
This method should return a particular identifier used for the object. Each scope utilized a different identification method. For instance, session scope implementations may use the session identifier.

After creation of a custom scope, you will need to make Spring aware of the implementation. To do so, you must invoke the following method from the `ConfigurableBeanFactory` interface, which is available on most standard ApplicationContext implmentations:

```
void registerScope(String scopeName, Scope scope);
```
Here, the first argument is a unique name associated with the custom scope. The second argument should be an actual instance of the custom scope imlpementation.

For example:

```
Scope revatureScope = new RevatureSpringScope();
beanFactory.registerScope("revScope", revatureScope);
```

After which you can configure new bean definitions with this custom scope:
XML:
```
<bean id="revatureBean" class="com.revature.example.RevatureBean" scope="revScope"/>

```

Annotation:
```
@Configuration
public class AppConfig {

    @Bean
    @Scope("revScope")
    public RevatureBean revatureBean() {
        // ...
    }
}
```


### References
* [Bean Scopes - Spring 4.0.x documentation](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html#beans-factory-scopes)
