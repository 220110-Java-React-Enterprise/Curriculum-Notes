# Project 1 - Remote Object Store

## Description

Your next project will build upon the concepts from project 0, adding the following topics:
 - HTTP
 - ORM
 - Servlets
 - DevOps

You will be building a web service for object storage. The goal is to design a remotely accessible service which will accept HTTP requests to store and retrieve objects of unknown structure. You will expose an API which will accept incoming GET, PUT, POST, and DELETE requests and perform CRUD functionality. We will use Postman to test and consume your API.

You will be expected to complete the minimum viable product by the deadline and give a brief presentation demonstrating your project and answering questions from the QC team.

This project will be done in teams of 2-3 members that will be assigned when we begin.

### Minimum Requirements
1. Proper use of OOP principles
4. CRUD operations are supported for objects which are not defined beforehand.
5. Communication is done with HTTP exchanges, and resources are transmitted as JSON in request/response bodies.
6. JDBC and persistence logic should all be part of your ORM which abstracts this away from the rest of the application.
7. Documentation (all classes and methods have adequate Javadoc comments)
8. All Exceptions are caught and logged to a file

### Bonus Features
1. Basic HTML/CSS/JS front end to consume API
1. DevOps CI/CD pipeline to build and deploy project
2. 80%+ Unit test line coverage for service-layer methods(Test as much as possible, ask trainer if unsure)


## Object Store
These are user stories to describe the web service. This is a remotely accessible storage service for persisting and retrieving objects/resources over the internet.

### Minimum Viable Product
* As a user, I store a JSON object by invoking the proper endpoint (POST/Create).
* As a user, I can change my object by invoking the proper endpoint (PUT/Update).
* As a user, I can retrieve my object by invoking the proper endpoint (GET/Read).
* As a user, I can delete my object by invoking the proper endpoint (DELETE/Delete)
* As a user, I can create and log into a secure account.
* As a user, I can create, read, update, and delete objects without specifying their shema or structure.

### Bonus Stories
* As an administrator, I can manipulate all objects.
* As an pilot, I can initiate takeoff of a flight. (No more new tickets or cancellations)

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
 - Your work **MUST BELONG TO YOUR TEAM**. Collaboration is allowed and encouraged, but at the end of the project you must have an excellent understanding of every line of code in your project and be able to answer questions about any part of it.
