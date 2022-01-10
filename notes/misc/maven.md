# Introduction to Maven

[Maven](https://maven.apache.org/) is a dependency manager and build automation tool for Java programs. Maven project configuration and dependencies are handled via the Project Object Model, defined in the `pom.xml` file. This file contains information about the project used to build the project, including project dependencies and plugins.

Maven identifies projects through **project coordinates** defined in the `pom.xml` file - these are:
* `group-id` - for example: "com.revature"
* `artifact-id` - for example: "myproject"
* `version` - for example: "0.0.1-SNAPSHOT"

Together, these uniquely identify a specific version of a program.

Some other important tags within the `pom.xml` file include:
* `<project>` - this is the root tag of the file
* `<modelVersion>` - defining which version of the page object model to be used
* `<name>` - name of the project
* `<properties>` - project-specific settings
* `<dependencies>` - this is where you put your Java dependencies you want to use. Each one needs a `<dependency>`, which has:
  * `<groupId>`
  * `<artifactId>`
  * `<version>`
* `<plugins>` - for 3rd party plugins that work with Maven

## Maven Repositories

When Maven "builds" a Java project, it must first search for any dependencies declared in the `pom.xml` file. Maven dependencies are stored both locally and in a central repository. The local repository is in the `$HOME/.m2/repository` folder (can be changed in `$MAVEN_HOME/conf/settings.xml`), while the central repository is accessible at https://mvnrepository.com. If Maven cannot find a given dependency locally, it searches the central repository for the artifact and then downloads it to the local repository.

A Maven "build" means to take the project source code, along with any dependencies like libraries or frameworks, compile it, and bundle it all together into an artifact - this could be a `.war` file, a `.jar` file, or an `.ear` file. WAR stands for "web archive", JAR stands for "Java archive", and EAR stands for "Enterprise Application archive". This artifact can then be either directly run or deployed onto a web container (in the case of a web application).

## Maven Build Lifecycle
When Maven builds your project, it goes through several steps called **phases**. The default maven build lifecycle goes through the following phases:
1. Validate => project is correct and all necessary information is available 
2. Compile => compiles project source code 
3. Test => tests all compiled code 
4. Package => packages all compiled code to WAR/JAR file 
5. Integration => performs all integration tests on WAR/JAR
6. Verify => runs checks on the results of integration tests 
7. Install => installs WAR/JAR to local repository 
8. Deploy => copies final WAR/JAR to the remote repository 

Each phase in turn is composed of plugin goals that are bound to zero or more build phases. A "goal" represents a specific task which contributes to the building or managing of the project.

For more information, see the [Maven documentation](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

## Using the `mvn` command

To use the Maven CLI (command-line interface), first test that you have Maven installed:
```
mvn --version
```

Now, once you are in your project directory, you can run any phase in the default build lifecycle. Maven will look for the `pom.xml` file and use that to run the phase.

```
cd /path/to/myproject/
mvn package
```

To execute a specific Maven goal, use the `plugin:goal` syntax:

```
mvn dependency:copy-dependencies
```

Multiple phases or goals can be run sequentially. Again, see the Maven documentation for more information.
