# Content Negotiation Implementing Support for XML
 
In this section, we will discuss another concept of RESTful Web Services that is content negotiation.
 
## Content Negotiation
A resource can have many representations, mostly because there may be multiple clients expecting different representations.
 
Content negotiation is the process of selecting the best representation for a given response when there are multiple representations available. It is a part of HTTP that makes it possible to serve different versions of a document at the same URI.
 
 
In web API, content negotiation is performed at the server side to determine the media type formatted to be used based on return the response for an incoming request from the client-side. Content negotiation is centered on the media type and media type format.
 
## Server-driven vs. Agent-driven Content Negotiation
An algorithm located at the server makes the selection of representation for a response, which is called `server-driven negotiation.`
 
An agent makes the selection of representation for a response, which is called `agent-driven content negotiation.`
 
So, most of the REST API implementations rely on agent-driven content negotiations. Agent-driven content negotiation relies on the usage of `HTTP requests` or `resource URI patterns.`
 
## Content negotiation using HTTP headers
An incoming request may have an entity attached to it. To determine the type of entity server uses the HTTP request header `Content-Type.` There are some common content types are: application/json, application/xml, text/html, images/jpg, etc.
```xml
Content-Type: application/xml
```  
HTTP header `ACCEPT` is used to determine what type of representation is desired at the client side. It contains a value as mentioned for Content-Type.
```xml
Accept: application/json  
```
If there is no header is present in the request, the server can send preconfigured default representation type.
 
## Content negotiation using URL patterns
There is another way to pass content type information to the server. The client can use a specific extension in resource URIs. For example, a client can request the following:
```
https://revature.in/functions.xml  
https://revature.in/functions.json
```        
The first request URI returns the XML response, and the second URI returns the JSON response.
 
### Defining Preferences
The preference is defined through the q parameter that has values between 0 and 1. If the client does not specify the request header, it takes the implicit value, i.e., 1.
 
If the client is not sure about its desired representation and wants to give multiple values in the accept header. For example:
```
Accept: application/json, application/xml;q=0.7,*/*;q=0.5  
```
The above accept header allows you to ask the server for a JSON format. If the JSON format is not present, it will look for XML format. If the XML format is not possible, let it return what it can.
