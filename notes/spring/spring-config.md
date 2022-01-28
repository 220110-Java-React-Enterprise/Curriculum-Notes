# Spring Module - XML vs Annotation vs Java Configuration

This page details XML-based and Annotation-based configurations for the ApplicationContext as well as Java configurations of Spring Beans.



## Bean Factory & Application Context
The Spring [Bean Factory](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/beans/factory/BeanFactory.html) interface establishes the underlying basis for the Spring IoC Container functionality by providing advanced configurations capable of managing any type of object. The ApplicationContext is a sub-interface of the BeanFactory interface which adds easier integration with Spring's AOP features. This ApplicationContext represents the Spring IoC container as it is responsible for the instantiation, assembly and management of "beans". These "Beans", are the term used for objects created in Spring which form the backbone of an application. Though they are created and managed by the IoC Container, they are otherwise just a type of object in an application. When bean objects have certain dependencies, these are reflected within configuration metadata used by the container.

In other words, the BeanFactory provides the configuration framework and basic functionality, and the ApplicationContext adds more enterprise-specific functionality for to the creation and management of objects in the Spring framework.

With regard to the configuration metadata, there are three ways this configuration can be represented, through XML, Java annotation or Java Code.

The following image displays a high-level representation of how Spring works:

![Spring Container](./../images/spring-ioc-overview.png)

The application classes are combined with configuration data when the ApplicationContext is created and initialized, which produces a fully configured application, or system.

It is worth noting that the BeanFactory instantiates beans lazily (creating beans only when required), while ApplicationContext instantiates beans eagerly (once the bean becomes relevant, and may potentially be used).

## XML Configuration
XML configuration consists of the declaration of at least one <bean/> element nested inside a top-level <beans/> element. These bean definitions correspond to actual objects within your application, and typically relate to server layer, data access (DAO), infrastructure objects (such as hibernate SessionFactories), or presentation objects (such as Struts Action instances). The following code is an example of a basic bean configuration using XML:
```
<!-- This XML file defines service beans and is named 'services.xml' -->
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- services -->
    <bean id="accountServ" class="com.revature.services.AccountServiceImpl">
        <property name="accountDao" ref="accountDao"/>
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="orderServ" class="com.revature.services.OrderServiceImpl">
        <property name="orderDao" ref="orderDao"/>
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="itemServ" class="com.revature.services.ItemServiceImpl">
        <property name="itemDao" ref="itemDao"/>
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for services go here -->

</beans>
```

```
<!-- This XML file defines DAO beans and is named 'daos.xml' -->
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accountDao" class="com.revature.dao.AccountDaoImpl">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="orderDao" class="com.revature.dao.OrderDaoImpl">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="itemDao" class="com.revature.dao.ItemDaoImpl">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for data access objects go here -->

</beans>
```

Here, the id attribute is a string used to identify specific bean definitions, while the class attribute defines the type of bean using the fully qualified class name. Note that you can substitute the id attribute with the name attribute if you would like to provide multiple aliases for a bean.

To instantiate a Spring IoC container using this XML configuration, the location path or paths should be supplied to an ApplicationContext Constructor. For XML configurations the ApplicationContext object should be derived from the [ClassPathXmlApplicationContext](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html) class:

```
// Single XML Path File
ApplicationContext context = new ClassPathXmlApplicationContext(new String ("services.xml"));
```

```
// Multiple XML Path Files
ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});
```

## Annotation Configuration
Annotation configuration, introduced as of Spring 2.5, serves as an alternative to XML-based setups, and rely on the use of annotations and bytecode metadata to wire components as opposed to the used of angle-bracket element declarations. Utilization of annotation based configuration still requires the use of an ApplicationContext XML file; however, the bean configurations are separated from this XML file into the component class files themselves and are defined using relevant annotations on the class, method or field declaration. 

To use annotation configuration the context tag will be required within the ApplicationContext configuration file. This element enables the use of annotations which is, by default, turned off. Additionally, you will need to include the xml namespace "context". For Example:
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

    <!-- The context namespace (below) is required for context element -->
    xmlns:context="http://www.springframework.org/schema/context"

    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- The following enables use of annotation-based configurations to be detected within your class files -->
    <context:annotation-config/>

    <!-- Bean definitions -->
   <bean id = "account" class = "com.revature.models.Account">
   </bean>
   <bean id = "order" class = "com.revature.models.Order">
   </bean>
   <bean id = "item" class = "com.revature.models.Item">
   </bean>

</beans>
```

To properly configure beans, use of the `@Autowired` annotation should be used. This annotation injects beans based on their type, and it commonly used with singleton bean design patterns.

`@Autowired` [Property]
```
package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
	private Account account;
	private int id;

	// @Autowired on properties can take the place of setter methods
	@Autowired
        private Item item;

	public Item getItem() {
		return item;
	}

	...

}
```

`@Autowired` [Setter]
```
package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
	private Account account;
	private int id;
    private Item item;

	@Autowired
	public void setItem(Item item) {
		this.item = item;
	}

	...
}
```

`@Autowired` [Constructor]
```
package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
	private Account account;
	private int id;
    private Item item;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired // multiple beans are distinguished by object type
	public Order(Account account, int id, Item item) {
		super();
		this.account = account;
		this.id = id;
		this.item = item;
	}

	...
}
```

If multiple bean definitions exist for a particular object type the `@Resource` or `@Qualifier` annotations can disambiguate the bean. `@Resource` is a standard Java annotation which injects beans based on name, rather than type. The `@Qualifier` annotation specifies a particular `@Autowired`-annotated bean based on the bean's identifier (the bean name). As such, the `@Qualifier` annotation is a Spring annotation:

`@Resource`
```
	@Resource("item_one") // if multiple items exist...
	public void setItem(Item item) {
		this.item = item;
	}
```

`@Qualifier`
```
	@Autowired
	public Order(@Qualifier("account")Account account, int id, Item item) {
		super();
		this.account = account;
		this.id = id;
		this.item = item;
	}
```

`@Required`
```
package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {
	private Account account;
	...

	@Required
	public void setAccount(Account Account) {
		this.Account = account;
	}

	...

}
```

Note that `<context-annotation-config>` only looks for annotations on beans within the same application context in which it is defined. This means if you put `<context:annotation-config/>` within a WebApplicationContext for a DispatcherServlet, it will only check for `@Autowired` beans within these controllers, but not beans in your services. You can otherwise specify packages using the `<context:component-scan/>` element with a list of packages:
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

    <!-- The context namespace, below, is required for context element -->
    xmlns:context="http://www.springframework.org/schema/context"

    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <!-- Component Scan informs Spring where to look for bean wiring configurations -->
    <context:component-scan base-package="com.revature.services;com.revature.dao;com.revature.models">

    <!-- Bean definitions -->
    ...

</beans>
```

The method to instantiate the Spring IoC container using annotation configuration is similar to the XML-based configuration. The location path should be specified in an ApplicationContext Constructor using the [ClassPathXmlApplicationContext](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html) class:

```
ApplicationContext context = new ClassPathXmlApplicationContext(new String ("applicationContext.xml"));

```

### `@Inject` and `@Named`
Java also provides standard annotations which can be used to inject object dependencies. These annotations, `@Inject` and `@Named` require the use of the `javax.inject` package. Similarly to `@Autowired`, `@Inject` can occur at the class, field and constructor argument levels, based on the bean type. The `@Named` annotation can serve the same purpose as the `@Qualifier` annotation to disambiguate between bean definitions, and additionally be used as a bean definition equivalent to the `@Component` annotation.

`@Inject`
```
package com.revature.models;

import javax.inject.Inject;
import javax.inject.Named;

public class Order {

	private Account account;
	private int id;
    private Item item;

    @Inject
	public void setAccount(Account account) {
		this.Account = account;
	}
}
```

`@Named`
```
package com.revature.models;

import javax.inject.Inject;
import javax.inject.Named;

@Named("order")
public class Order {
	private Account account;
	private int id;
        private Item item;

	@Inject	// Similarly to @Autowired, type is used to distinguish beans when a qualifier (@Named) is not used
	public void setAccount(Account account) {
		this.Account = account;
	}

	...

}
```

__NOTE__: Annotation injection is performed prior to XML injection. As such, the use of both will result in XML configurations overriding Annotation configurations.


## Java Configuration
Java-based configuration also uses annotations, but do not require the use of an application context file. Instead, configuration management is handled by `@Configuration`-annotated class files which define `@Bean`-annotated methods used to describe the beans.

Note that you can use `@Bean`-annotated methods with any class which is `@Component`-annotated; however, they are most commonly used with `@Configuration` beans since the primary purpose for a class which is `@Configuration`-annotated is the definition of beans. In order to autowire or inject primitives, the `@ComponentScan` annotation specifies where to search for defined beans. Additionally all of these beans must be imported from the org.springframework.context.annotation package.

The following example shows an illustration of the Java Configuration method:
```
package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.dao.AccountDao;
import com.revature.dao.AccountDaoImpl;
import com.revature.dao.OrderDao;
import com.revature.dao.OrderDaoImpl;
import com.revature.dao.ItemDao;
import com.revature.dao.ItemDaoImpl;
import com.revature.services.AccountService;
import com.revature.services.AccountServiceImpl;
import com.revature.services.OrderService;
import com.revature.services.OrderServiceImpl;
import com.revature.services.ItemService;
import com.revature.services.ItemServiceImpl;

@Configuration
@ComponentScan({ "com.revature.repository;com.revature.services" })
public class AppConfig {
	// =====================Setter Injection======================
	@Bean(name="accountDao")
	public AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}
	
	@Bean(name="accountService")
	public AccountService getAccountService() {
		AccountServiceImpl aserv = new AccountServiceImpl();
		as.setAccountDao(getAccountDao()); //<---setter injection
		return aserv;
	}
	
	//=================Constructor Injection=================
	
	@Bean(name = "orderDao")
	public OrderDao getOrderDao() {
		return new OrderDaoImpl();
	}
	
	@Bean(name = "orderService")
	public OrderService getOrderService() {
		OrderServiceImpl oserv = new OrderServiceImpl(getOrderDao()); //<--- consturctor injection
		return oserv;
	}

	@Bean(name = "itemDao")
	public ItemDao getItemDao() {
		return new ItemDaoImpl();
	}
	
	@Bean(name = "itemService")
	public ItemService getItemService() {
		ItemServiceImpl iserv = new ItemServiceImpl(getItemDao());
		return iserv;
	}
}
```

Instantiation for the Spring IoC container using Java configuration uses the [AnnotationConfigApplicationContext](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/context/annotation/AnnotationConfigApplicationContext.html) class with the `@Configuration`-annotated class as an argument in the constructor call:

```
ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

```

### Summary of Annotations [Alphabetical]:
* `@Autowired` - Spring Annotation used to inject bean dependencies as needed, based on bean type.
* `@Bean` - Spring annotation which plays the same role as the <bean/> element in an XML-based configuration, and you can specify an identifier for these beans with the use of the id (or name) property.
* `@Component` - Generic [stereotype annotation](./stereotypes.md) used to declare an object as a bean.
* `@ComponentScan` - Spring Annotation which specifies path locations for defined beans to be used for potential injection.
* `@Configuration` - Spring annotation indicates a class file used to manage bean configurations using Java configuration similar to the Application Context file for an XML or annotation based configuration.
* `@Inject` - Standard Java annotation used to inject bean dependencies as needed. Equivalent to Spring's `@Autowired` annotation.
* `@Named` - Standard Java annotation for disambiguating beans based on bean name. Equivalent to Spring's `@Qualifier` annotation. Additionally can be used as an equivalent to Spring's `@Component` annotation to define beans as well.
* `@Qualifier` - Spring Annotation which can be used in conjunction with `@Autowired` to disambiguate multiple beans of a defined type.
* `@Required` - Standard Java annotation which indicates that an affected bean property must be populated at configuration time through an explicit property value in the bean's definition.
* `@Resource` - Standard Java Annotation used to inject bean dependencies based on bean name, rather than type.


### References
* [Spring 4.0.x  Documentation - IoC Container & Image](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html)
* [Spring 4.0.x API Docs](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/overview-summary.html)
