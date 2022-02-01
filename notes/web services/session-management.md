## HttpSession API

The Servlet API provides **HttpSession Interface**, which provides a way to identify a user and to store information about that user. For the client's first request, the Servlet Container generates a **unique session ID** and gives it back to the client with a response. Thereafter, the client sends the session ID with each request to the server.

The **getSession()** method of the *HttpServletRequest* object returns a user's session. Any servlet can access the *HttpSession* object using getSession() method. 

Example for creating the *HttpSession* object: 
```java
protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        HttpSession session = request.getSession();
}
```
The commonly used HttpSession Interface methods are listed below:

* **setAttribute(key,object)** - used to bind an object to the session, using the key specified. 
* **getAttribute(String)**  - used to retrieve a specific saved object from the session object, using its key.
* **removeAttribute(key)**  - used to remove the object bound with the specified key from the session.
* **invalidate()** - destorys the session.
* **getId()**  - returns the unique ID assigned to the session.
* **getCreationTime()**- returns the time when the session was created
* **getLastAccessedTime()** - returns the last time the client sent a request associated with the session
* **getMaxInactiveInterval()** - returns the maximum time interval, in seconds.
* **setMaxInactiveInterval(int interval)** - Specifies the time, in seconds,after servlet container will invalidate the session.

## **Example:**

Create two servlets: a **SourceServlet** and a **TargetServlet** which will process data submit through a form in an HTML file called **user.html**.

1. Upon submitting the <code>userName</code> in the **user.html** form, the **SourceServlet will create a <code>session</code> object.

2. The **SourceServlet** will use the <code>session</code> object to <code>setAttribute</code> to the user, and then use the <code>PrintWriter</code> to produce a hyperlink to the **TargetServlet**.

3. The **TargetServlet** can retrieve the user by once again instantiating a <code>session</code> and then getting the <code>"user"</code> attribute.

4. By using <code>PrintWriter</code>, the **TargetServlet** will print username that the client initially input in the **user.html** form as well as more information about the session.

### Create the HTML file <code>user.html</code>

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter User Name:</h1>
	<form method="post" action="sourceServlet">
		User Name :<input name="userName"> 
		           <input type="submit" value="send" name="submitButton">
	</form>
</body>
</html>
```

### Create <code>SourceServlet.java</code>

```java
@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		
		// instantiate a session objection
		HttpSession session = request.getSession();
		
		// set an attribute that can be retrieved by the next servlet
		session.setAttribute("user", username);
		
		// create a hyperlink to go to the next servlet which will process the request
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='targetServlet'>Click Here to get the UserName</a>");
	}
}
```
Here we are using <code>@WebServlet</code> annotations to map our servlets.  

Notice that the annotation for our sourceServlet correlates with the <code>action=</code> attribute of our <code>user.html</code> form.

### Create <code>TargetServlet.java</code>

```java
@WebServlet("/targetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// this is called when the hyperlink from SourceServlet is clicked
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// instantiate the session object and use the .getSession() method on the request
		HttpSession session = request.getSession();
		
		// retrieve the attribute from the session
		String username = (String)(session.getAttribute("user"));
		
		String sessionId = session.getId();

		long creationTime = session.getCreationTime();
		long lastAccessedTime = session.getLastAccessedTime();

		Date createDate= new Date(creationTime);
		Date lastAccessedDate= new Date(lastAccessedTime);

		
		// print the retrieved attribute using the PrintWriter
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Username is: " + username + " </h1>");
		
		out.println(" Your Session Infomation: <br/>");
		out.println("ID: " + sessionId  + "<br/>");
		out.println("Session Created Date: " + createDate + "<br/>");
		out.println("Session Created Time: " + creationTime + "<br/>");
		out.println("Last Accessed Date : " + lastAccessedDate + "<br/>");
		out.println("Last Accessed Time: " + lastAccessedTime + "<br/>");
	}
}
```

Right click on <code>user.html</code> and click Run On Server. 

You should be able to enter a username and retrieve that information in your **TargetServlet** by accessing the data stored in the associated session.
