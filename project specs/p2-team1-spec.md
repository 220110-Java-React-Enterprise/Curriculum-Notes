# Project 2 - Team 1 - TravelBuddy:

## Description

Your next project will build upon the concepts from project 0 & 1, adding the following topics:
 - HTML/CSS/JS
 - CI/CD
 - Spring Boot
 - Spring Data
 - Spring Web

You will be building a client/server application with a frontend and backend. Your application will use a third party API to get data useful to the service you provide. What service that is, is up to you. Your team should consider your options and come up with an idea for a client/server application that can utilize a third party API to grab data. Your application should meet the minimum requirements set forth below. Your team will work with your trainer to create a series of user stories for your application's MVP.
  
You will be expected to complete the minimum viable product by the deadline and give a brief presentation demonstrating your project and answering questions from the audience.

This project will be done in teams of 5-6 members that will be assigned when we begin.

### Minimum Requirements
1. Proper use of OOP principles and a well layered application structure
2. Users are interfacing with a basic UI built with HTML, CSS, and JavaScript running in a browser
4. CRUD operations are supported for one or more domain objects via the web application's API endpoints
5. Client/Server communication is done with JSON in HTTP request and response bodies.
6. All low-level persistence logic is abstracted away with Hibernate/Spring Data
7. Documentation (all classes and methods have adequate Javadoc comments)
8. All Exceptions are caught and logged
9. Data useful to the application is retrieved from a third party API
11. DevOps CI/CD pipeline is used to build and deploy project to a publicly available remote location


### Bonus Features
1. Unit test coverage of service-layer classes
2. Basic (cypher) or advanced (shashed) encryption for secure data in HTTP exchanges



## TravelBuddy
Imagine you are looking to travel to a new city or location - perhaps you are relocating for work, or simply a tourist. You know nothing about this city - but wouldn't it be nice to simply go to one website, enter the location you'd like to learn more about, and receive a nice set of facts about that place?  Our website will offers this and more! Users can register and post reviews detailing their experiences in these locations. These comments can be moderated by administrators, who will be able to see comments flagged by other users and delete them if they are in violation of our code of conduct.  We utilize various API's offered by API Ninjas (https://api-ninjas.com/).

### Minimum Viable Product
Your team will need to work with the trainer to come up with a satisfactory list of user stories for MVP as well as bonus stories. They should begin with "As a [stakeholder] I can... and describe what the user should be able to do. Aim for at least 2 different roles, perhaps user and administrator. Try to come up with 6-8 user stories for MVP. Carefully consider what your team can accomplish in 2 weeks and try not to set yourselves too great a task.

## User Stories:
 - As a user, I can register and log into an account
 - As a user, I can search for cities
 - As a user, I can view information on a city, including: Weather, Crime rate, Unemployment, gdp and user reviews
 - As a user, I can post a review of a city

 - As an administrator, I can view a dashboard of reported reviews
 - As an administrator, I can comment on reviews
    
## Bonus stories:
 - As a user, I can flag user content (reviews) as inappropriate 
 - As an administrator, I can edit and/or delete user content that is inappropriate
 - This site will include information from Google Maps
 - This site will be mobile-reactive
 - Users can rate reviews (ex. helpful / not helpful)


## Tech Stack
You should be employing the following technologies in your project.
 - Java 8
 - JavaScript/TypeScript
 - HTML & CSS
 - Apache Maven for dependencies and project management
 - Git & Github for version control
 - MariaDB deployed on AWS RDS for data persistence
 - AWS EC2, ElasticBeanstalk, S3, CodeBuild, CodePipeline for CI/CD pipeline
 - Spring Boot, Web, Data

## Deadline & Presentation
 - Finalized version of your project must be pushed to your team's p2 repository within the training originzation by 9:00 AM Central time on the date of the presentation showcase. Commits after that time will not be considered. The most recent commit submitted before that time will be the version of the project that is graded.
   - Presentation Showcase (Due Date): Thursday, February 24th 2022, 9:00 AM CDT.
 - You will give a brief (15 minute) presentation of your project. Be prepared to answer questions about your work from the QC team. Everyone involved should be part of the presentation and speak about some part of the project.
 - Your work **MUST BELONG TO YOUR TEAM**. Collaboration is allowed and encouraged, but at the end of the project you must have an excellent understanding of every line of code in your project and be able to answer questions about any part of it.
