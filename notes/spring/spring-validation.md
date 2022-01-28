# Validation

## Validation and Spring
Validation, or the act of checking/verifying validity or accuracy of something, is an important consideration for any web application, with various pros and cons. In general validation should not be tied to the web tier, it should be easy to localize, and it should be loosely coupled with any available validators. Fortunately, Spring provides a basic yet eminently usable `Validator` interface which can work in every layer of an application. Additionally, when validating information, it is useful to utilize Data binding, which allows user input to be dynamically bound to custom models for each application. Within the Spring `validation` package, both the `Validator` interface as well as a `DataBinder` objects exist to address both. Note that Athough this package is primarily used within the MVC framework, it is not limited to it.

The Spring `Validator` interface, as its name implies, can be used to validate objects. The interface works using a Spring Framework `Errors` objects so that, while validating, validators can report these validation failures to this `Errors` object.

To examine this lets take a look at our Account object and create a validator for this.
_Account.class_
```java
public class Account {
    private long id;
    private String name;
    private String type;

    // Constructors, getters and setters...
}
```

In order to create the validation behavior, we must implement the Validator interface from the `org.springframework.validation` package and provide a definition for the `public boolean supports(Class)` method and the `public void validate (Object, org.springframework.validation.Errors)` method

_AccountValidator.class_
```java
public class AccountValidator implements Validator {

    /**
     * This Validator validates *just* Person instances
     */
    public boolean supports(Class clazz) {
        return Account.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        validationUtils.rejectIfEmptyOrWhitespace(e, "type", "field.required");
        Account a = (Account) obj;
        if (a.getId() < 0) {
            e.rejectValue("id", "negativevalue");
        }
    }
}
```

The ValidationUtils class provides various methods which can be used to produce a variety of `Errors` objects. For example, the `rejectIfEmpty` will register to the `errors` object if the value _name_ is empty, while the `rejectifEmptyOrWhitespace` method registers when the _type_ is either empty or contains whitespace. Though it is possible to implement a single validator class for an application, it is better to encapsulate validation logic for each class with its own Validator implementation.

### Spring `Errors`
The Spring `Errors` interface stores and exposes information about data-binding and validation errors for objects. This interface defines a static `NESTED_PATH_SEPARATOR` String, which details the nested path for properties on a model or bean. For example: "account.id" or "account.type" correspond to the values of that data on an "account" object. If an object is more complex (such as a map, or property of an object nested within a class), this path separator can also provide this information: "customer.address.streetName". Here, the customer object has an address object with a property called "streetName".

In addition, `Errors` objects can output error messages by using a `MessageSource`. In the examples above, this is done by using the error code given when rejecting the field. Custom logic can then be provided in your `Errors` object. (See the [reject method](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/validation/Errors.html#reject-java.lang.String-) in the documentation for more information).

### `DataBinder` and `@Valid`
As of Spring 3, an instance of the DataBinder object can be configured with a Validator. Once configured the Validator may be invoked by invoking the `validate()` method of a DataBinder object. Any validation errors will then automatically be added to a `BindingResult` object of the DataBinder. Before viewing an example, it it worth discussing the `BeanWrapper`. Fundamentally, the `BeanWrapper` is used in a lot of places, but direct configuration is generally not needed. However, while performing data binding it is useful to examine this concept.

As you know, beans are objects used for injection and modeling information in a Spring application. These beans have various properties, like normal Java POJOs. When utilizing beans however, an important interface used in the beans package is the `BeanWrapper` and its corresponding implementation `BeanWrapperImpl`. The `BeanWrapper` offers critical functionality to set and get properties values, either individually or in bulk. When establishing property values, the name of a property is used as the context for that particular value on a bean. For instance, a String _name_ property corresponds to the `getName()` and `setName(String)` methods.

Within the Bean Factory, the `getPropertyValue()` and `setPropertyValue()` methods are used as a general way to configure bean property values with this interface during bean instantiation. The following is an example of how this data may be retrieved or manipulated:
```java
BeanWrapper account = BeanWrapperImpl(new Account());
// setting the account name..
account.setPropertyValue("name", "Revature Account");

// ... can also be done like this:
PropertyValue value = new PropertyValue("name", "Revature Account");
account.setPropertyValue(value);
```

The DataBinder object uses this concept to bind bean values to it.
For example:
```java
Account target = new Account();
DataBinder binder = new DataBinder(target);
binder.setValidator(new AccountValidator());

// bind to the target object
binder.bind(propertyValues);

// validate the target object
binder.validate();

// get BindingResult that includes any validation errors
BindingResult results = binder.getBindingResult();
```

See the [Form-input lecture notes](./form-input) for another example of the BindingResult object.

Moreover, as of Spring 3, the Spring MVC has the ability to automatically validate `@Controller` inputs through the use of the `@Valid` annotation so long as the validator for a model has been configured:
```java
@Controller
public cass AccountController {
    @RequestMapping("/example", method=RequestMethod.POST)
    public void validationExample (@Valid Account account) {
        // logic goes here
    }
}
```

### Hibernate Validator
Although you can provide your own custom validation, the Hibernate Validator is the standard validation implementation. It is also worth noting that hibernate includes its own specific constraints and annotations, and use of this validator is **_not_** dependent on the hibernate ORM. To utilize this validator implementation you should add version 4.3.1 the following dependencies to your project:
```
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>4.3.1.Final</version>
</dependency>
```

Note that the new standard is `HibernateValidator` version 6 with the JSR-380 standard.

The hibernate validator provides an implementation on various, useful constraints such as `@NotNull`, `@Min` and `@Max`. Thankfully the names of these annotations are intuitive to their purpose. Although the implementation of these annotations comes from the hibernate validator, you should import the annotation from the `javax.validation.constratins` package.

`@NotNull`
This annotation checks that an annotated value is not null.
```java
import javax.validation.constratins.NotNull;

public class Account {
    @NotNull
    private long id;
    private String name;
    private String type;

    // ...
}
```

`@Min` and `@Max`
These annotations check for a minimum or maximum numerical value.
```java
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class Plane {
    @Min(1)
    private int pioletCount;
    
    @Max(250)
    private int passengerCount;
    
    // ...
}
```

A list of more annotations can be found [here](https://docs.jboss.org/hibernate/validator/4.3/reference/en-US/html_single/#validator-defineconstraints-spec). 

If you intend to use Hibernate specific annotations, which you can find [here](https://docs.jboss.org/hibernate/validator/4.3/reference/en-US/html_single/#validator-defineconstraints-hv-constraints), you must import these annotations from the `hibernate.validator.constraints` package. Examples of these annotations include `@CreditCardNumber`, which allows validation of credit card number syntax (not validity of the actual credit card) or `@Range` to check if a numerical value lies between a specified minimum and maximum value (inclusive).

### References
* [Spring Validation and Data Binding](https://docs.spring.io/spring/docs/4.0.x/spring-framework-reference/html/validation.html)
* [Spring Validation API Docs - Validator](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/validation/Validator.html)
* [Spring Validation API Docs - ValidationUtils](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/validation/ValidationUtils.html)
* [Spring Validation API Docs - Errors](https://docs.spring.io/spring/docs/4.0.x/javadoc-api/org/springframework/validation/Errors.html)
* [Hibernate Validator JBoss Docs](https://docs.jboss.org/hibernate/validator/4.3/reference/en-US/html_single/)
