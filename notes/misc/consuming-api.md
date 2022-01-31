# Rest Template Requests

NOTE: RestTemplate will be deprecated in Spring Framework 5.

## RestTemplate

In Spring `RestTemplate` acts as a web client to make requests to web services. `RestTemplate` offers 3 types of methods for exchanging data with web service:

| API  | Purpose  | Example |
|---|---|---|
| *ForEntity  | Request for the native exchange format returned by the server (JSON, XML, Text) | getForEntity(...)   |
| *ForObject  | Deserialize the response into a Java pojo   | getForObject(...) |
| exchange  | Generic API for making web requests  | exchange(...)  |


## RequestTemplate Usage

### getForEntity
```java
RestTemplate rest = new RestTemplate();
String resourceUrl = "http://localhost:8080/myservice/data";
ResponseEntity<String> response = rest.getForEntity(resourceUrl + "/1", String.class);
```
The above code creates and instance of a `RestTemplate` and makes a request to the `resourceUrl`. The method used for the request here is one of the overloaded`getForEntity` methods. Here the request is being made for the native data format being sent back by the server. The response is encapsulated in a `ResponseEntity` object with which we can retrived the response status, body, and headers.

### getForObject
```java
public class DataModel{
    ...
    private String value;
}
```
```java
RestTemplate rest = new RestTemplate();
String resourceUrl = "http://localhost:8080/myservice/data";
DataModel model = rest.getForObject(resourceUrl + "/1", DataModel.class);
```
The above code is similar to the previouse example, however this time the code uses `getForObject`. `RestTemplate` will attempt to deserialize the response body using a message converter bean based on the `Content-Type` header in the response.

### exchange API
The exchange API offers a more generic manner of make web request through `RestTemplate`.

```java
RestTemplate rest = new RestTemplate();
HttpEntity<Data> request = new HttpEntity<>(new DataModel("value"));
String resourceUrl = "http://localhost:8080/myservice/data";
ResponseEntity<DataModel> response = rest.exchange(resourceUrl, HttpMethod.POST, request, DataModel.class);
```
The above code uses the `exchange` API to perform an `POST` request. The major differences in the signature are the `HttpMethod` argument and the `request` argument. The `HttpMethod` argument configures which type of request to make, and the `request` argument will become the serialized body of the request.

```java
RestTemplate rest = new RestTemplate();
HttpEntity<Data> request = new HttpEntity<>(new DataModel("value"));
String resourceUrl = "http://localhost:8080/myservice/data";
ResponseEntity<DataModel> response = rest.postForLocation(resourceUrl, request);
```
This above code is similar to the previous example, but uses `postForLocation`. REST spec states that a `Post` request can return an empty body with the `Location` header set to the new resource url. `postForLocation` will return the value of the `Location` header in the response.


### Form Data
```java
RestTemplate rest = new RestTemplate();

HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
map.add("value": "test");

HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

String resourceUrl = "http://localhost:8080/myservice/data";
ResponseEntity<DataModel> response = rest.postForLocation(resourceUrl, request);
```

### References
- [RestTemplate](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
