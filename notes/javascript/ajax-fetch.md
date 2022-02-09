# AJAX

AJAX stands for **A**synchronous **J**avaScript And **X**ML. Ajax describes the process of exchanging data from a web server asynchronously with the help of  XML, HTML, CSS, and JavaScript. It just loads the data from the server and selectively updates some webpage parts without refreshing the page. Ajax uses the browser's built-in XMLHttpRequest (XHR) object to send and receive data to and from a web server asynchronously, in the background, without blocking the page or interfering with the user's experience.

Despite the name, modern usage of AJAX usually works with JSON data rather than XML as we will see.

## Ajax Work Flow

Ajax works flow starts from the client-side, on the browser. The steps involved in Ajax communication as follows:

1. A client event occurs on a webpage. (for example, the user clicks a button)
2. JavaScript creates an XMLHttpRequest object.
3. The XMLHttpRequest object makes an asynchronous request to the server.
4. The server process the received HttpRequest.
5. The server creates a response and sends data back to the browser.
6. Browser process the returned data using JavaScript.
7. The page content updated by javascript.

## The XMLHttpRequest Object

The keystone of AJAX is the XMLHttpRequest object. An XMLHttpRequest (XHR) object used to make HTTP requests to the server and receive data in response.

### Create an XMLHttpRequest Object:

Before you perform Ajax communication between client and server, we should create an XMLHttpRequest object.

```javascript
var xhttp = new XMLHttpRequest();
```

### Send a Request To a Server:

To send a request to a server, we use the open() and send() methods of the XMLHttpRequest object.

* **open(method, URL, async)**

where,
method — Specifies the HTTP request method to use, such as "GET", "POST", etc.,
URL  - Specifies the location of the server
async - Specifies whether the request should be handled asynchronously or not. If "true" then the script processing carries without waiting for a response. If  "false" then the script waits for a response.

* **send()** - Sends the request to the server. It accepts an optional parameter that allows us to specify the request's body (used for POST).

In the GET method, the data is sent as URL parameters. In the POST method, the data is sent to the server as a part of the HTTP request body, which is not visible in the URL.

```javascript
xhttp.open("GET", "ajax_info.txt", true);
xhttp.send();
```

### Server Response

The Server Response returned in the form of responseText or responseXML or status or statusText.

* **responseText** - Returns the response as a string.

* **responseXML** - Returns the response as XML.

* **status** - Returns the status as a number (For example, 200: "OK", 403: "Forbidden",404: "Page not found")

* **statusText** -Returns the status as a string (e.g., "Not Found" or "OK").


We have to wait for the data to be available to process it, and in this purpose, the state of availability of data is given by the **readyState** attribute of XMLHttpRequest. The **onreadystatechange** function is called every time the readyState changes.

The readyState property defines the status of the XMLHttpRequest:

* readyState = 0 : Not intialized
* readyState = 1 : Connection establised
* readyState = 2 : request received
* readyState = 3 : processing request
* readyState = 4 : request finished and response is ready

**Example:**
```html
<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("demo").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", "ajax_info.txt", true);
  xhttp.send();
}
</script>
```

## Working with JSON in Ajax

Sending JSON request payload and receiving the JSON response object are common tasks while dealing with AJAX. JavaScript retrieves the JSON data sent by the server, parse them, and displaying them on the webpage.

### JSON in Request Payload

In JavaScript, to send a request using JSON data, we need to serialize our JSON object into a string. The **`JSON.stringify()`** method is used to converting an object to a string. Then, the server receives the string and process the request.

**Example:**

```javascript
var data = {"name" : "Matt"};
var xmlhttp = new XMLHttpRequest();
xmlhttp.open("POST", "/demo", true);
//Use stringify() method to get string
xmlhttp.send( JSON.stringify( data ) );
```

### JSON in Response Body

If the response from the server is string/text, we need to parse them into a JSON object. The **`JSON.parse()`** method converts a JSON string representation to a JSON object.

**Example:**
```javascript
var xmlhttp = new XMLHttpRequest();

xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        //Use parse() method to convert JSON string to JSON object
        var responseJsonObj = JSON.parse(this.responseText);

        console.log( responseJsonObj.name );
        console.log( responseJsonObj.age );
    }
};

xmlhttp.open("GET", "/demo", true);

xmlhttp.send();
```

### XML in Response Body

While we normally wish to parse our response from JSON, sometimes we might be dealing with an older server and we need to parse XML data. The **`responseXML`** field contains the data as a read-only Document Object Model.

**Example:**
```javascript
var xmlhttp = new XMLHttpRequest();

xmlhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var responseXml = this.responseXML;

        console.log( responseXml.getElementsByTagName('myTag') )
    }
};

xmlhttp.open("GET", "/demo", true);

xmlhttp.send();
```

## Fetch API

Instead of using XMLHttpRequest enabled Ajax, we can use Fetch API, which is modern and versatile. The Fetch API provides a `fetch()` method defined on the `window` object. This method used to send requests and returns a `Promise` that retrieved from the response. A **Promise** object represents a value that may not be available now but, will be resolved in the future. It allows us to write asynchronous code.

The syntax for fetch() method: `let promise = fetch(url, [options])`

The browser requests the server and returns a promise as a response.  When the request unable to make HTTP-request due to network problems or response has failure HTTP-status code is  404 or 500, then the Fetch API rejects the Promise object. When we get a response successfully form the server, the promise object returned in the **Response Body**.

The methods to access the response body in various formats:

* `response.text()` – read the response and return as text. 
* `response.json()` – parse the response as JSON.
* `response.formData()` – return the response as FormData object .
* `response.blob()` – return the response as Blob (binary data with type).
* `response.arrayBuffer()` – return the response as ArrayBuffer(low-level representation of binary data). 


We also use the `async` and `await` keyword with the `fetch()` method. The `async` keyword is added to functions to tell them to return a promise rather than directly returning the value. The `await` keyword only works inside async functions, used to pause the code on that line until promise gets complete.


*Example:*
```javascript
async function asyncFunc() {
  let response = await fetch(protectedUrl);
  let text = await response.text(); // response body consumed
  document.write(text);
}

asyncFunc();
```
**Response headers** - The response headers are available in a Map-like headers object in `response.headers`. To get individual headers by name or iterate over them.

*Example:*
```javascript
async function asyncFunc() {
  let response = await fetch(githubUrl);

  // get one header
  alert(response.headers.get('Content-Type')); // application/json; charset=utf-8

  // iterate over all headers
  for (let [key, value] of response.headers) {
    alert(`${key} = ${value}`);
  }
}

asyncFunc();
```

**Request headers** - To set a request header inside the `fetch` method, we can use the `headers ` attribute.

*Example:*
```javascript
let response = fetch(protectedUrl, {
  headers: {
    Authentication: 'secret'
  }
});
```

**POST Request:**

To make a POST request, we need to mention the HTTP method (`method`)and request the body (`body`) inside the fetch method. The request body can be string, FormData object, or blob. If the request `body` is a string, then `Content-Type` header is set to `text/plain;charset=UTF-8`. If the request `body` is a JSON, then `Content-Type` header is set to `application/json;charset=UTF-8`. We don't set `Content-Type` manually for blob object.

*Example:* 
```javascript
async function asyncFunc() {
  let user = {
    name: 'John',
    surname: 'Smith'
  };
  // url is a server location 
  let response = await fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(user)
  });

  let result = await response.json();
  alert(result.message);
}

asyncFunc();
```

## Handling Errors
The Fetch API generates a promise, meaning that if the request fails, it will cause the promise to enter the `reject` state. To handle this, we need to either surround our `await` instruction with a `try...catch` block or to append a `catch()` callback to our promise.

*Example:* 
```javascript
async function asyncFunc() {
  let user = {
    name: 'John',
    surname: 'Smith'
  };
  // url is a server location 
  let response = await fetch(url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    body: JSON.stringify(user)
  });
  try {
    let result = await response.json();
    alert(result.message);
  } catch (error) {
    console.error(error);
  }
}

asyncFunc();
```

*Example:* 
```javascript
let user = {
  name: 'John',
  surname: 'Smith'
};
// url is a server location 
let response = fetch(url, {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json;charset=utf-8'
  },
  body: JSON.stringify(user)
}).then((response)=>{
  let result = response.json();
  alert(result.message);
}).catch((error)=>{
  console.error(error);
});
```
