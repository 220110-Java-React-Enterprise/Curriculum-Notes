# Spring Annotations

## Spring Config
 - @Configuration - marks a class as the bean configuration class which has methods that return objects to be beanified.
 - @ComponentScan - tells IoC container to configure by scanning for annotated components
 - @Bean - marks a class as a bean (not for component scanning!)
 - @Component - marks a class as a component (a bean) for component scanning. There are also the "stereotype" annotations below:
   - @Repository - marks as a JPA repository bean
   - @Service - marks as a service bean
   - @Controller - marks as a controller (servlet) bean
 - @Autowired - injects dependencies from IoC contrainer automagically
 - @Resource - alternative to @Autowired, this injects beans into fields or setters. Not constructors!
 - @Inject - alternative to @Autowired, this injects beans into fields or setters. Not constructors!
 - @Qualifier - In addition to byName and byType you can find beans by qualifier.
 - @Required - indicates the annotated bean field is required and a bean cannot be instantiated if it is not supplied.
 - @Inject - Another way to inject dependencies from IoC container
 - @Named - Allows @Inject to find beans byName instead of byType

## Spring Data
 - @Query - used to denote a method as a repository CRUD method and can specify a JPQL query to be parameterized if needed.
 - @Repository - Stereotype annotation - marks as a JPA repository bean
 - @Transactional - Sets transaction settings
 - @Param - marks a field as a parameter for a JPQL query
 - @Id - marks an entity field as the ID (the PK of  database entry)
 - @Transient
 - @CreatedBy, @LastModifiedBy
 - @CreatedDate, @LastModifiedDate
 - @Valid
 - @Min - spring JPA validation, sets minimum valid value
 - @Max - spring JPA validation, sets maximum valid value
 - @NotNull - spring JPA validation, field cannot be null
 - @Range - spring JPA validation, sets minimum and maximum range of values
 - @EnableTransactionManagement
 - @EnableJpaRepositories

## Spring MVC (Web)
 - @Controller - stereotype annotation that marks class as a controller (basically a servlet)
 - @Restcontroller - Implies @Controller and @ResponseBody
 - @PathVariable - marks a parameter in a controller method to be populated by the correpsonding path variable
 - @RequestMapping - maps a controller or method to a URL pattern
 - @GetMapping - @RequestMapping that dentotes the GET method
 - @PostMapping - @RequestMapping that dentotes the POST method
 - @PutMapping - @RequestMapping that dentotes the PUT method
 - @DeleteMapping - @RequestMapping that dentotes the DELETE method
 - @RequestBody - Marks a parameter as a request payload that should be de-serialized from JSON/XML
 - @ResponseBody - This annotation marks a return type to be serialized into JSON/XML payload
 - @ResponseStatus - Use this annotation to set the response status for a successful method
 - @RequestParam - Marks a parameter in a controller method to be populated with the value associated with a key in the request payload
 - @RequestHeader - marks a parameter in a controller method to be populated with the value associated with a key in the request headers

## misc
 - @DateTimeFormat
