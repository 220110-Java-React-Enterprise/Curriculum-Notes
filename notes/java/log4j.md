# Module - Log4j

Log4j is a reliable, fast, and flexible logging framework for Java supported by Apache. It's commonly used to record application events, log granular debugging information for developers, and write exception events to files.

## Why do we need logging?
Logging records events that occur during software execution. As users execute programs on the client side, the system accumulates log entries for support teams. In general, it allows for developers to access information about applications to which we do not have direct access. Without logs, we would have no idea of knowing what went wrong when an application crashes, or track and monitor application performance.

Also, a logging framework like Log4j is critical because it allows us to use various logging levels and configure a threshold to determine which messages will be recorded in the application log files.

## Log4j Usage
Log4j has a simple class architecture as shown below:

![log4j classes](https://logging.apache.org/log4j/2.x/images/Log4jClasses.jpg)

The main components of the hierarchy are:
* `Logger` - logs the messages
* `Appender` - publishes logs to destination(s)
* `Layout` - formats logging information
* `Configuration` - stores settings
* `Filter` - used to filter out logs that do not meet the threshold

### Log4j Logging Levels
Below are the Log4j log levels, in order of least to most restrictive:
1. **ALL** => all levels
2. **DEBUG** => designates fine-grained informational events that are most useful to debug an application
3. **INFO** => informational messages that highlight the progress of the application at the coarse grained level
4. **WARN** => designates potentially harmful situations
5. **ERROR** => designates error events that might still allow the application to continue running
6. **FATAL** => severe error events that presumably lead the application to abort
7. **OFF** => highest possible level, intended to turn off logging

### How do logging levels work?
A log request of level *x* in a logger with level *y* is enabled with *x >= y*. For the standard levels, we have that 
    ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF

### Configuration
Log4j (specifically Log4j2) can be configured using XML, JSON, YML, or Properties files, as described in [their documentation](https://logging.apache.org/log4j/2.x/manual/configuration.html).

### Simple Example
To use Log4j2, first include the library as a dependency. If you're using Maven, simply add the following to your `pom.xml` file:
```xml
<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.11.2</version>
</dependency>
```

Assuming you've setup some configuration file, you can go ahead and use loggers in your code:

```java
public class Foo {
  private static Logger log = LogManager.getLogger(Foo.class);
  
  public static void main(String[] args) {
    log.info("Hello world!");
	log.warn("Uh oh");
	log.error("This is not good!");
  }
  
}
```
