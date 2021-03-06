# QC Questions on Servlets

 - What is a Java servlet?
   - A java class which handles HTTP requests dispatched to it by the servlet container based on requested URI.
 - What are the lifecycle methods of a Java servlet?
   - init(), service(), destroy()
 - How many times are each of the lifecycle methods called in the lifetime of a single servlet?
   - init and destroy are called exactly once in the lifetime of a servlet, service() is called once for every request.
 - What are some of the core classes and interfaces in the Java Servlet API?
   - HTTPServlet, HTTPServletRequest, and HTTPServletResponse, ServletContextListener
 - What is the method signature of the doGet method of the HttpServlet class?
   - public void doGet(HTTPServletRequest req, HTTPServletResponse resp);
 - What is a web server? Provide some common examples
   - Software that listens for and responds to HTTP requests made remotely via the internet.
   - tomcat, apache, WAMP, IIS, etc.
 - What is the web.xml file used for in a Java web application?
   - The Deployment Descriptor file, used to map servlets to URI's. More generally used to tell the servlet container where it can find needed resources.
 - What is the difference between ServletConfig and ServletContext?
   - ServletConfig is an object with settings specific to an individual servlet
   - ServletContext is configuration for an entire servlet context, including many servlets.
 - What is the purpose of the PrintWriter in a Java servlet? How is it obtained?
   - PrintWriter is an object used to write information to the response object. We obtain it by calling the HTTPServletResponse method .getPrintWriter();
 - What is the difference between a forward and a redirect?
   - forward send the request to another resource, but a redirect tells the client to send another request to the new location.
 - What is the purpose of the RequestDispatcher in Java servlets?
   - RequestDispatcher is an object used to forward requests to another servlet.
 - What is HTTP?
   - HyperText Transfer Protocol. This is the protocol used for web communication.
 - What are the HTTP verbs/methods?
   - **GET, POST, PUT, PATCH**, TRACE, OPTIONS, HEAD, DELETE, CONNECT
 - What does it mean for an operation to be safe? What HTTP methods are safe?
   - It means the operation is read-only and cannot modify a resource state. GET, OPTIONS, TRACE, HEAD
 - What does it mean for an operation to be idempotent? What HTTP methods are idempotent?
   - Idempotent means that an operation will always have the same result. PUT, PATCH, GET, DELETE, HEAD
 - What is the difference between POST, PUT, and PATCH requests?
   - POST traditionally means creating a new resource
   - PUT traditionally means updating an entire resource
   - PATCH traditionally means updating part(s) of a resource
 - What are some differences between GET and POST requests?
   - GET retrieves data from the server
   - POST sends data to the server.
