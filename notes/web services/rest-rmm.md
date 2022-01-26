# Richardson Maturity Model
"A model (developed by Leonard Richardson) that breaks down the principal elements of a REST approach into three steps. These introduce resources, HTTP verbs, and hypermedia controls." - Martin Fowler 
 
 
## 0. Start with HTTP. 
 
Interactions for your application are built on HTTP with some kind of formatted payload. XML, JSON etc. 
 
Essentially in the form of RPC. (Remote Procedure Calls)
 
## 1. Introduce Resources. 
 
API endpoints will be directed at particular resources. 
 
"To an object guy like me this is like the notion of object identity. Rather than calling some function in the ether and passing arguments, we call a method on one particular object providing arguments for the other information."
 
## 2. Verbs of HTTP 
 
Tie the actions taken as closely as possible with the verbs of HTTP.
 
And receive responses whose status codes are closely related to the action taken. 
 
## 3. HyperMedia Controls
 
"HATEOAS (Hypertext As The Engine Of Application State)" 
 
"The point of hypermedia controls is that they tell us what we can do next, and the URI of the resource we need to manipulate to do it." 
 
Now responses will include not just a representation of the resource to which they correspond but the URI needed to access the resource as part of that representation.  
 
 
## Conclusions
 
- Level 1 => divide and conquer 
- Level 2 => standardization
- Level 3 => discoverability 
 
## References 
- [Martin Fowler on Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)
- [Leonard Richardson's explanation](https://www.crummy.com/writing/speaking/2008-QCon/act3.html)
 
