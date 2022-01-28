# RESTful Web Services Best Practice
 
In this section, we will evaluate the best practice that must be followed while developing RESTful Web Services.
 
The first and last best practice is called `Consumer First`. It means always think about your consumer's perspective before naming your resource. What will they think about the resource? Will they be able to understand it?
 
## Consumer First
 
We must have excellent documentation for our API. Swagger is one of the most popular documentation standards for RESTful API. Make sure that our consumer understands the documentation that we have produced.
 
The next best practice is to make the best use of `HTTP`. RESTful web services are based on HTTP. Make the best use of the request methods. Use the right request method `(GET, POST, PUT, and DELETE)` appropriate for our specific action and ensure that we are sending a proper response status back.
 
For example, when a `RESOURCE NOT FOUND` is received don't send the SERVER ERROR. When a resource is CREATED, don't send SUCCESS, send CREATED back.
 
Ensure that there is no secure information in the URI. Think about what you are putting in your URI. Ensure that there is nothing secure that is going in the URIs.
 
Always use plurals. In the previous examples, we have used /users instead of using /user. Similarly, for accessing a resource, we have used `/users/1` not `/user/1`. It is more readable than using the singular.
 
When we think about resources, always use nouns for resources. But it is not always possible. There are always exception scenarios. For all these exceptions scenarios, define a consistent approach if we are searching through user use /`user/search`.
