# REST

REST stands for REpresentational State Transfer. REST is a software architectural style that defines the set of rules to be used for creating web services. Web services which follow the REST architectural style are known as RESTful web services. It allows requesting systems to access and manipulate web resources by using a uniform and predefined set of rules. Interaction in RESTful architecture is based on HTTP exchanges.

 - Representational - resources (objects) are reporesnted as JSON or XML for transfer.
 - State - referring to a resource as it exists in that moment, a **resource representation**.
 - Transfer - the resource representation is transmitted.

A resource in REST is a unit of identifiable information. Basically, a resource is an analog of an object in OOP. Note that as a resource changes over time it is not a new resource. The same resource is in a different state. Resources are identified by a URI (Universal Resource Identifier). A URL (web addresses we are all familiar with) is a locator, and a specific type of URI which is fully qualified.  

A Restful system consists of a:
 - client who requests for the resources.
 - server who has the resources.

## REST Constraints
There are six architectural constraints that need to be followed in order to be RESTful.

 - Uniform Interface
 - Stateless
 - Cacheable
 - Client-Server
 - Layered System
 - Code on Demand\*

 \* - Code on Demand is sometimes considered optional, but in order to be considered RESTful, all of the other constraints must be met.



### Uniform Interface
It is a key constraint that differentiate between a REST API and Non-REST API. It suggests that there should be an uniform way of interacting with a given server irrespective of device or type of application (website, mobile app).
There are four guidelines principle of Uniform Interface are:

 - Resource-Based - Individual resources are identified in requests. For example: API/users.
 - Manipulation of Resources Through Representations: Client has representation of resource and it contains enough information to modify or delete the resource on the server, provided it has permission to do so. Example: Usually user get a user id when user request for a list of users and then use that id to delete or modify that particular user.
 - Self-descriptive Messages: Each message includes enough information to describe how to process the message so that server can easily analyses the request.
 - Hypermedia as the Engine of Application State (HATEOAS): It need to include links for each response so that client can discover other resources easily.

### Stateless
It means that the necessary state to handle the request is contained within the request itself and server would not store anything related to the session. In REST, the client must include all information for the server to fulfill the request whether as a part of query params, headers or URI. Statelessness enables greater availability since the server does not have to maintain, update or communicate that session state. There is a drawback when the client need to send too much data to the server so it reduces the scope of network optimization and requires more bandwidth.

### Cacheable
Every response should include whether the response is cacheable or not and for how much duration responses can be cached at the client side. Client will return the data from its cache for any subsequent request and there would be no need to send the request again to the server. A well-managed caching partially or completely eliminates some client–server interactions, further improving availability and performance. But sometime there are chances that user may receive stale data.

### Client-Server
REST application should have a client-server architecture. A Client is someone who is requesting resources and are not concerned with data storage, which remains internal to each server, and server is someone who holds the resources and are not concerned with the user interface or user state. They can evolve independently. Client doesn’t need to know anything about business logic and server doesn’t need to know anything about frontend UI.

### Layered System
An application architecture needs to be composed of multiple layers. Each layer doesn’t know any thing about any layer other than that of immediate layer and there can be lot of intermediate servers between client and the end server. Intermediary servers may improve system availability by enabling load-balancing and by providing shared caches.

### Code on Demand
This is an optional feature. According to this, servers can also provide executable code to the client. The examples of code on demand may include the compiled components such as Java applets and client-side scripts such as JavaScript.


<BR><BR>See Also:
 - [Representational State Transfer (REST) -Roy Fielding](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
 - [What is Rest?](https://restfulapi.net/)
 - [Rest Resource Naming Guide](https://restfulapi.net/resource-naming/)
