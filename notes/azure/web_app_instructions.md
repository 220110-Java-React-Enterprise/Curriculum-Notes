# Deploying a Spring Boot Web App via Azure

1. Create a Spring project using start.spring.io. Make sure the Spring Web dependency is added. Ensure "jar" is selected if you would like to use Spring's Embedded server. Select "war" if you would like to use Tomcat. 

2. Click on generate, unzip the downloaded folder, and add the contents to a Github repository. 

3. Add a controller class to your Spring project. You can name it whatever you want. Just make sure you include some sort of GET request so you can test out the endpoints. Push your code. 

Here's an example of what your controller could look like:

```
package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/fruit")
    public String fruit() {
        return "apples";
    }
}

```

4. On the Azure Portal, click on "Create a Resource" from the home page. 

5. Select "Web App". It should be under "Popular Web Services". Otherwise, you can use the search bar to find it. 

6. Enter in the general information. Ensure that the name is unique and select the appropriate Runtime Stack (ex: Java 11, Java SE or Tomcat). Remember to ensure that the server type matches your Spring project (jar -> Java SE, war -> Tomcat). 

7. You don't have to worry too much about the other tabs, so once the basic information is done, click on "Review + Create" and then "Create". Wait for deployment to finish. 

8. Once done, go to the resource and select "Deployment Center" from the sidebar. 

9. Under "source" select Github. It will prompt you to sign in if this is your first time. Choose the organization, repository, and branch from the drop-downs. Example: roryeiffe/azure-spring-take-3, main branch. 

10. Verify that these match your Spring project from steps 1-3. Click "Save" on the top left. 

11. It might take a few minutes to deploy. Notice the yml file in your Github repository. This was be automatically added there by Azure. You can check the progress of deployment under the "Actions" tab on Github. Once completed, a url should appear. Alternatively, you can navigate to the Web App Service on Azure Portal and find the link from there. It should look something like https://<name>.azurewebsites.net. 

12. You might find that navigating to this url brings you to the default Azure Web Service Page. If this is the case, try refreshing in a few minutes. 

13. Alternatively, you might see the default Tomcat page. To fix this, add your artifact id to the end of your url. This can be found in your pom.xml file in your Spring Boot application. 

If your pom.xml looks like 
```
<artifactId>demo</artifactId>
<version>0.0.1-SNAPSHOT</version>
```

Then, you want to add "demo-0.0.1-SNAPSHOT" to the end of your azure link. 

ex: A full link might look like rory.azurewebsites.net/demo-0.0.1-SNAPSHOT. 

Note: if you used Java SE, you shouldn't have to add the artifact id. (Thanks to Richard for discovering this!)