# Project 1

## Description

Your next project will build upon the concepts from project 0, adding the following topics:
 - HTTP
 - ORM
 - Servlets
 - DevOps (bonus: automate it fully)

## Project 1:
You will be building an API which exposes functionality to accept, deserialize, and persist objects in a database. Your API will be remotely accessible and accessed by Postman. **A front-end GUI is not required for MVP.** You will expose an API which will accept incoming GET, PUT, POST, and DELETE requests.  We will use Postman to test and consume your API. Your API will depend on a custom ORM which will be written in it's own project, packaged as a .JAR file, and used as a dependency.


#### Part 1 - Custom ORM:
You will develop a custom ORM which uses reflection to dynamically build CRUD functionality without being aware of the structure/schema beforehand. This should abstract all JDBC and persistence logic away from the other part of the project. Your ORM is a dependency to be utilized by the other part of the project.

#### Part 2 - Web Service:
You will create your own web service used to store, manipulate, and retrieve objects in response to HTTP requests. Your service will be remotely available on AWS, and will utilize your ORM as a dependency. You will expose an API using Java servlets that allow us to manipulate the objects as resources. You will decide on what sort of resources your service can handle. Make up some sort of service, use your imagination, and design the resources that you would store. Example: An airline microservice that persists data about customers. It doesn't need to worry about aircraft or billing, it's just persisting and recalling user POJOs to suport some other application.

You will be expected to complete the minimum viable product by the deadline and give a brief presentation demonstrating your project and answering questions from the QC team.

This project will be done in teams of 2-3 members that will be assigned when we begin.

### Minimum Requirements
1. Proper use of OOP principles
4. CRUD operations are supported for at least 2 types of objects.
5. Communication is done with HTTP exchanges, and resources are transmitted as JSON in request/response bodies.
6. JDBC and persistence logic should all be part of your ORM which abstracts this away from the rest of the application.
7. Documentation (all classes and methods have adequate Javadoc comments)
8. All Exceptions are caught and logged to a file

### Bonus Features
1. Basic HTML/CSS/JS front end to consume API
2. ORM can build foreign key relations according to object references.
3. ORM can design schema on the fly.
4. Automated DevOps CI/CD pipeline to build and deploy project
5. Adequate unit test line coverage for service-layer methods(Test as much as possible, ask trainer if unsure)


## Object Store
These are user stories to describe the web service. This is a remotely accessible storage service for persisting and retrieving objects/resources over the internet.

### Minimum Viable Product
* As a user, I store JSON objects by invoking the proper endpoint (POST/Create).
* As a user, I can change objects by invoking the proper endpoint (PUT/Update).
* As a user, I can retrieve objects by invoking the proper endpoint (GET/Read).
* As a user, I can delete objects by invoking the proper endpoint (DELETE/Delete).
* As a user, I can retrieve all objects that belong to me. (transmit the user as part of the request header, and build a relation in the db in some way to tie the objects to the user)


## Tech Stack
You should be employing the following technologies in your project.
 - Java 8
 - HTTP
 - Servlets
 - Apache Maven for dependencies and project management
 - Git & Github for version control
 - MariaDB deployed on AWS RDS for data persistence
 - Custom ORM for data persistence

## Deadline & Presentation
 - Finalized version of your project must be pushed to your team's p1 repository within the training originzation by 9:00 AM Central time on the date of the presentation showcase. Commits after that time will not be considered. The most recent commit submitted before that time will be the version of the project that is graded.
   - Presentation Showcase (Due Date): Thursday, Feburary 10th 2022, 9:00 AM CDT.
 - You will give a brief (10 minute) presentation of your project. Be prepared to answer questions about your work from the QC team.
 - Your work **MUST BELONG TO YOUR TEAM**. Collaboration is allowed and encouraged, but at the end of the project each team member must have an excellent understanding of every line of code in your project and be able to answer questions about any part of it.
