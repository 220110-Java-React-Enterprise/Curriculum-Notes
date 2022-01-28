# Spring Module - Injecting Primitives

## Injecting Primitives
Spring beans have two methods of injecting dependent data, Constructor Injection and Setter Injection.

Constructor injection occurs when an IoC container creates a bean, passing values as arguments within that bean's constructor. Setter injection occurs when the IoC container specifically invokes a bean's setter methods for the particular properties within the object.

Spring XML-based configuration files support the `<property/>` and `<constructor-arg/>` elements, which can be used to define various property values. The `<property/>` and/or `<constructor-arg/>` element should be nested within the bean in this instance. Take for example:

```
package com.revature.example;

public class FruitBasket {

    public FruitBasket(Apple apple, Banana banana) {
        // ...
    }

}
```

```
<beans>
    <bean id="fruitBasket" class="com.revature.example.FruitBasket">
        <constructor-arg ref="apple"/>
        <constructor-arg ref="banana"/>
    </bean>

    <bean id="apple" class="com.revature.example.Apple"/>

    <bean id="banana" class="com.revature.example.Banana"/>
</beans>
```

When resolving bean values, the argument's type is used. If no potential ambiguity exsists, the order in which the constructor arguments are defined is the order in which those arguments are supplied to the constructor. 

To inject primitive or hard-coded values, you may use the value attribute within the `<constructor-arg/>` or `<property/>` element. This value attribute specifies a human-readable __string representation__ of the data you want to pass into the bean property.

```
package com.revature.example;

public class ExampleBean {

    public ExampleBean(int num, String word) {
        // ...
    }

}
```

```
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg type="int" value="12345"/>
    <constructor-arg type="java.lang.String" value="Hello World"/>
</bean>
```

In the event ambiguity does exist, the index property can be used to explicity define the constructor arguments based on the order they are defined in the constructor signature.

```
package com.revature.example;

public class ExampleBean {

    public ExampleBean(int num_1, int num_2) {
        // ...
    }

}
```
```
<bean id="exampleBean" class="examples.ExampleBean">
    <constructor-arg index="0" value="1234"/>
    <constructor-arg index="1" value="4321"/>
</bean>
```

For Java-based and Annotation configurations, the `@Value` annotation can specify the injection of data when paired with a separate java configuration file. For example:

Configuration file (jdbc.properties file):
```
jdbc.driverClassName=oracle.jdbc.OracleDriver
jdbc.url=jdbc:jdbc:oracle:thin:@localhost:1521/orclpdb1
jdbc.username=user
jdbc.password=password
```

Class File:
```
@Configuration
@ImportResource("classpath:/com/revature/main/resources/properties-config.xml")
public class AppConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }

}
```

### References
* [Spring 4.0.x Documentation](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/beans.html)
