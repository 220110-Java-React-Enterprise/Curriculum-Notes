## Thursday Topics

### Azure DevOps
- [Overview of Azure DevOps](https://docs.microsoft.com/en-us/azure/devops/user-guide/what-is-azure-devops?view=azure-devops)
- [DevOps Solutions](https://azure.microsoft.com/en-us/solutions/devops/#overview)
- [Azure Pipelines](https://azure.microsoft.com/en-us/services/devops/pipelines/)
- [Creating a sample Pipeline](https://docs.microsoft.com/en-us/azure/devops/pipelines/create-first-pipeline?view=azure-devops&tabs=java%2Ctfs-2018-2%2Cbrowser)

## Thursday Demos
- Creating an Azure pipeline

## Thursday Exercises
### Create a full-stack app and deploy it on Azure. 
This will be our biggest exercises yet, and it will pull in all of the cool topics we learned about this week into one big project. 

Here are the requirements:

1. Create a Spring Boot Application. It can be very simple, but it needs to have Spring Data JPA and Spring Web. (If you use Postgres, you will also need to add the PostgreSQL driver). It should have at least one repository and one controller. The controller must have a GET and a POST method that update the repository. Feel free to take a look at [this](https://github.com/roryeiffe/azure-primer-final) repo for reference as to what the bare minimum is. Feel free to fork it and work from it. Note that the controller class contains the logic of calling the repository methods which is bad form. You would normally want that logic to live in a service class but I took the shortcut in order to make the demo as clear as possible. 

2. Create an Azure database for either MySQL or PostgreSQL (Wednesday topics). Update the application.properties file in your Spring application to use that database. Again, a reference can be found on the Github example, but you will need to change certain things. 

3. Push your simple Spring Boot project to a repo and then create an Azure App Service. Hook it up to the repo you've made.

4. Finally, build a front-end web page that has 2 forms: One should let you enter information and persist that data to the database. The other should let you enter an id and return the data that corresponds to that id by displaying it on the web page. If no such entity exists for that id, display some sort of error message on the page. 

5. (Optional) When you're all done, deploy the front-end page using Azure Blob Storage. Send me the link or screen-share so I can test it out

Tips:

Test out the project step by step. For example, before you deploy your web app, test it out locally first using Postman. 

This is a big project but you guys can do it! There's not too much new stuff going on, so feel free to watch previous lectures to catch up. 

Work with a partner if you feel this might be too daunting! If you do, make sure you're both contributing. If you want a partner but don't know who to pick, message me and I can help out with the match-making. I'd prefer if groups were no bigger than 2 people.

Do your best to work through problems as they come up either by researching online, talking with each other, or reviewing lecture notes or videos. If it gets to the point where you're totally stumped, feel free to check in with me in my breakout room. 

This [article](https://docs.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jdbc-with-azure-postgresql) tells you how to connect a Spring Boot Application to an Azure PostgreSQL database. 

This [article](https://docs.microsoft.com/en-us/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-mysql) shows how to connect a Spring Boot App to an Azure MySQL database. 

Front End Website, for reference: https://github.com/roryeiffe/azure-primer-final-front-end