## Working with Jackson API 

The [Jackson API](https://en.wikipedia.org/wiki/Jackson_(API)) is used to convert Java objects into JSON format to send in an HTML response. The JSON format is commonly used for transmitting data between a server and a client in a web application.

In this section, we'll discuss how we convert java objects into JSON using the Jackson API and send it in a servlet response.

### Jackson ObjectMapper

The ObjectMapper API is used for data-binding. It uses reader/writer methods to perform the conversion between Java objects and JSON. 


*  **writeValue() method**  - used to convert Java object to JSON.

*Example:*
```java
ObjectMapper mapper = new ObjectMapper();
User user = new User();

//Object to JSON in String
String jsonInString = mapper.writeValueAsString(user);
```


*  **readValue() method** - used to convert JSON to Java object.

*Example:*
```java
ObjectMapper mapper = new ObjectMapper();
String jsonInString = "{'name' : 'Adam'}";

//JSON from String to Object
User user = mapper.readValue(jsonInString, User.class);
```


### Example

*  First, we need to add the Jackson dependency in our pom.xml file.

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.11.0</version>
</dependency>
```

* Then, we create a POJO class for converting this class object into JSON.
```java
public class User
{
   private Integer id;
   private String firstName;
   private String lastName;
 
   //Getters and setters
  }
```
* Servlets sends the JSON output as a response to the client using  **ObjectMapper**.
```java
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//converts the User object into JSON and sends the JSON data to the Client as a response
		response.getWriter().write(
			new ObjectMapper().writeValueAsString(
				new User("1234", "John", "Adams")));
	}
}
```

### References

* [ObjectMapper Documentation](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html)
