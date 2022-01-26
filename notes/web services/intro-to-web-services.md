# Intro to Web Services

## What is a Web Service?
A web service is a generic term for an interoperable machine-to-machine software function that is hosted from a network addressable location.  
 - **interoperable** - different languages, hardware, environments, able to operate together thanks to some clearly defined communication protocol
 - **network addressable** - remote, available over a network.
  
A web service has an interface, which hides the implementation details so that it can be used independently of the hardware or software platform on which it is implemented, and independently of the programming language in which it is written.  
  
The idea is that a wide range of compatible machines can remotely access some functionality and/or resources by defining language and hardware agnostic protocols. 

### Advantages of Web Services
 - Expand functionality of the way we use the web
 - Expose functionality for accessability and reuse
 - Standardization & interoperability
 - Loose coupling
  
Typically web services are divided into one of two flavors:
 - SOAP
 - REST

## SOAP
SOAP or Simple Object Access Protocol, is a rigidly defined and robust protocol maintained by the W3C. SOAP services respond to requests in the form of XML documents, called messages, and though a SOAP service can receive any kind of request, if it's an HTTP request then it must be in the form of an HTTP post request. We won't be getting too deep into SOAP in this cirriculum.

## REST
REST or REpresentational State Transfer, is an architectural style for web services described by Roy Fielding in a famous 2000 paper on web architecture.
 - Representational - resources (objects) are reporesnted as JSON or XML for transfer.
 - State - referring to a resource as it exists in that moment, a **resource representation**.
 - Transfer - the resource representation is transmitted.

A resource in REST is a unit of identifiable information. Basically, a resource is an analog of an object in OOP. Note that as a resource changes over time it is not a new resource. The same resource is in a different state. Resources are identified by a URI (Universal Resource Identifier). A URL (web addresses we are all familiar with) is a locator, and a specific type of URI which is fully qualified.  
  
There's a lot more to REST which will be covered in greater detail later in this cirriculum. For now we just want a basic understanding of what REST is and to go over the naming convention for resources.  

1. Use nouns wherever possible to name a resource, like 'user', 'account', or 'machine'.
2. Typically your singular resources will be part of a larger collection, so pluralize the noun to name a container which contains the singles.
3. Then use path parameters to uniquely identify individual resources. Ex: /users/{user-id}
4. Resources may contain sub-collections of resources. Ex: /users/{user-id}/accounts/{account-id}
5. Represent your resources in a hierarchy that can be described by URI path
6. Use query parameters to filter resources. Ex: /users/{userId}/projects?lang=java&week=2
  
Other considerations:
 - Consistency
 - Tend toward kebab-style
 - Avoid trailing /
 - Avoid including file extensions
 - Avoid using CRUD verbs
 - Avoid using verbs at all except in the case where the resource is an executable function
  



<BR><BR>See Also:
 - [Advantages of Web Services -IBM](https://www.ibm.com/docs/en/ztpf/1.1.0.15?topic=services-advantages-web)
 - [Benefits of Web Services -Oracle](https://docs.oracle.com/cd/B14099_19/web.1012/b14027/intro.htm#i1018810)
 - [History of the Web](https://home.cern/science/computing/birth-web/short-history-web)
 - [Representational State Transfer (REST) -Roy Fielding](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm)
 - [What is Rest?](https://restfulapi.net/)
 - [Rest Resource Naming Guide](https://restfulapi.net/resource-naming/)


