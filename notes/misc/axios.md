# Axios

<hr>

Axios is a promised based HTTP client for the browser and node.js. It is [supported](https://github.com/axios/axios#browser-support) by the latest version of common browsers and can be used to make requests in React.

Axios provides features to intercept and transform request and response data. It will also automatically parse JSON response data. It allows for requests to be cancelled, provides better error handling than fetch and also provides built in client side support for protecting against cross-site request forgery.

### Incorporating Axios in your React App

Install Axios

```
> npm install axios
```

Import Axios

```
import axios from "axios";
```

### Making Requests with Axios

Requests can be made by passing the relevant config to axios. This config describes the HTTP request and can include options such as:

- `url` - only required option
- `baseUrl` - prepended to url, if provided
- `method` - http method, default is get
- `headers`
- `params`
- `data`
- `withCredentials` - this is important for allowing cross-site requests to be made using credentials
- `auth`
- [... and more](https://github.com/axios/axios#request-config)

Example HTTP request:

```javascript
// Send a GET request
axios({
  method: "get",
  url: "https://jsonplaceholder.typicode.com/albums",
}).then((response) => {
  // process response.data - the data property should automatically be transformed to JSON
});
```

```javascript
// Send POST request
axios({
  method: "post",
  url: "https://jsonplaceholder.typicode.com/albums",
  data: {
    userId: 1,
    id: 101,
    title: "felis porttitor quis",
  },
  headers: {
    "Content-Type": "application/json",
  },
});
```

### Request Aliases

Axios also provides alias methods, making HTTP requests easier to define and easier to read.

|                                      |
| ------------------------------------ |
| `axios.request(config)`              |
| `axios.get(url[, config])`           |
| `axios.post(url[, data[, config]])`  |
| `axios.put(url[, data[, config]])`   |
| `axios.patch(url[, data[, config]])` |
| `axios.delete(url[, config])`        |
| `axios.head(url[, config])`          |
| `axios.options(url[, config])`       |

Using request aliases, the example requests in the previous section would be written as:

```javascript
// Send a GET request
axios.get("https://jsonplaceholder.typicode.com/albums").then((response) => {
  // process response.data
});
```

```javascript
// Send POST request
axios.post(
  "https://jsonplaceholder.typicode.com/albums",
  {
    userId: 1,
    id: 101,
    title: "felis porttitor quis",
  },
  {
    headers: {
      "Content-Type": "application/json",
    },
  }
);
```

### Axios Instances

If you want axios requests to share configuration, you can create an instance of axios with that common config. You are then able to invoke request/alias methods as instance methods on the axios instance. Any additional config provided in these instance methods will be merged with the instance config.

```javascript
const instance = axios.create({
  baseURL: 'https://my-domain.com/api/',
  headers: {'Content-Type': 'application/json'},
  withCredentials: true
});

instance.post(...); // this POST request would contain the configuration used to create the instance
```

<hr>

For more on axios, see their [readme](https://github.com/axios/axios).
