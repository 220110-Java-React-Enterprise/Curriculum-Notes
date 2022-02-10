# Spring Lab
The purpose of this lab is to practice setting up a new spring boot application using the spring starter web and data dependencies. You will need to start a new spring boot project, connect to your datasource, expose an API, and test it with postman. When complete you should be able to do simple CRUD operations on simple objects. 

### Spring Initializer
Start with the [Spring Initializer](https://start.spring.io/) at start.spring.io, which will set up all the boilerplate files and code to get your spring application started. Make sure to select Maven, Java, and Java version 8. Fill in the other fields with relevant info for this project.  
  
Next add our starting dependencies:
 - Spring Web
 - Spring Data JPA
 - MariaDB

Next, click "generate" and you will receive a zip archive with the boilerplate project files inside. Pick an approporiate location for a new Java project and unzip the contents of this archive there. You now have a maven project ready to be opened up in IntelliJ.

### Data
The first thing you will need to do is establish a connection to your datasource. Because we started with Spring Data JPA, the application won't even run successfully unless you can reach the datasource.  
  
You will need to add the relevant key/value pairs to the application.properties file. You will need to find the relevant connection info for the following items:

 - spring.datasource.url
 - spring.datasource.username
 - spring.datasource.password

You will also want to use the following key/value pairs:

 - spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
 - spring.jpa.database-platform=org.hibernate.dialect.MariaDB103Dialect
 - spring.jpa.generate-ddl=true
 - spring.jpa.hibernate.ddl-auto=create

With this in place you should be able to run your spring application and have it launch successfully. However, it doesn't do much of anything yet.

### Domain Objects
Before we can store anything in the database, we need things to store. Create one or more simple POJOs. Make sure to include a unique ID field. You may want to create several types of POJO class and have one hold a reference to another. This will cause Spring Data to establish a relation between the tables where theose objects are stored. Explore having one POJO hold a reference to another, and one POJO with a reference to a collection of another type of POJO. This will form one-to-one and one-to-many relationships respectively.  
  
Make sure your POJOs have:
 - A public no-args constructor
 - A private ID field
 - Several other private fields, just to give the POJO a reason to exist
 - public getters and setters for all fields.

Note: The terms Model and Entity both refer to objects we want to persist in our database. The term POJO is a design pattern for a class that has only private fields and public setters and getters. a POJO is just a holder for data, and contains no other behaviors. In this lab, our POJOs are our Entities/Models. 

Make sure to mark the POJO entities with the proper annotations:
 - `@Entity` - marks a class as an entity
 - `@Id` - marks a field as the primary key
 - `@Column` - marks a field as a database column
 - `@OneToOne` - marks one side of a one-to-one relation. It is not necessary to mark both sides.
 - `@OneToMany` - marks one side of a one-to-many relation. It is not necessary to mark both sides.
 - `@ManyToMany` - Marks one side of a many-to-many relation.
Each of these annotations is from the `javax.persistence` package.

### Persistence
Now that we have objects to persist, we just need to add the logic that will persist these objects. Luckily, the most basic and common CRUD operations are already pre-built for us by Spring Data. All we need to do is create an interface that extends one of the JPA interfaces, like J
