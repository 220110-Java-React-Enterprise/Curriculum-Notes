# Dockerfile Keywords

## Dockerfile Commands

`FROM  image name`
- specifies the parent image from which the new image should be based. 
- forms the first layer of this new image. 
- might say `FROM imagename AS temp-name` if we want to have use multi-stage builds
    - This will essentially create our final image by building on the previous images that we set up in the same dockerfile. 
- i.e. If we wanted to start with a ubuntu OS base (where we would take advantage of multi-stage builds) we might have: 
```dockerfile
FROM ubuntu AS ubuntu-with-java-example
```


`RUN `
- There are two forms of the command. 
    - `RUN <command>` 
        - Runs the command in a shell by default (the particular shell depends on whether the parent image defines a linux or windows container)
    - `RUN ["executable", "param1", "param2" ]`
        - Runs the command in the executable form without using a shell       
- `RUN` will be used to set up your image- the state of the image after each run command is committed- forming a new layer 
- i.e. If we wanted to install some programs as part of the image, you might have: 
```dockerfile
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 
```

`ADD <src> <destination>`
- adds files from build context or url to the image
- copy is preferred over add
- can perform auto-extraction into the image from a local tar file (this differs from copy and is one of the few instances add is preferred) 
-i.e. The following command would copy HelloWorld.java into a file of the same name in the container's working directory. 
```dockerfile
ADD HelloWorld.java HelloWorld.java
```

`COPY <src> <destination>`
- adds files from the build context to the image 
-i.e. The following command would copy HelloWorld.java into a file of the same name in the container's working directory. 
```dockerfile
COPY HelloWorld.java HelloWorld.java
```

`EXPOSE `
- outlines the ports that the are being listened on by processes in the container-- i.e. it suggests what ports to bind to host ports when running the image 
-The following example would inform the host to bind to port 80 in the container
```dockerfile
EXPOSE 80
```

`VOLUME ["/nameofdir"]`
- creates a mount point in the image and thus container with a particular name- it indicates that the files in this directory will be shared with the resources outside of the container  
- it indicates what directory to connect a volume to when running the docker container
-i.e. The following suggests that we should connect a volume to the data directory in the container when we spin it up. 
```dockerfile
VOLUME ["/data"]
```

`WORKDIR <nameofdirectory>`
- sets the working directory in the image and eventual container of commands that follow. 
i.e. 
```dockerfile
WORKDIR /example
RUN mkdir a
```
- Would make a directory *a* inside of the *example* folder. *example/a* 

`CMD `
- used to run the app, processes etc. needed inside of your container 
- only the last CMD will run when the built image is launched as a container
- `CMD ["executable","param1","param2"]` (exec form, this is the preferred form)
    - invokes the command with out a shell 
- `CMD ["param1","param2"]` (as default parameters to ENTRYPOINT)
    - the `ENTRYPOINT` instruction must be specified if you use the default format, it's another way you can specify the first commands to be run upon spinning up a 
- `CMD command param1 param2 (shell form)`
    - invokes the command inside of a shell in /bin/sh -c
- i.e. The last line of a docker file might be a command running a java program: 
```dockerfile
CMD ["java", "HiWorld"]
```

## Dockerfile Examples
**NOTE**: The dockerfile will typically be saved as Dockerfile without any extension. (Save-as all files.)

Let's look at this dockerfile that runs a simple Java HelloWorld example: 
```dockerfile
# Define the parent image
FROM ubuntu

# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 

# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example

# Create Hello World Java program and save it in the appropriate file 
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java

# Compile the Java program, creating the file that the JVM can actually run 
RUN javac HiWorld.java

# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]

```

### Description of Example:
The first line of the Dockerfile indicates the parent image will be the official ubuntu image. It's common to see an image begin with a base OS and then install any needed programs on top of it. (Though typically, if java is the only needed program, one would might choose to use openjdk or some image that starts with java.) 

The next lines that begin `RUN ...` install the needed jdk. 

`WORKDIR` sets directory for any subsequent commands to be executed from the */example* folder. 

Thus, the lines `RUN echo... ` and `RUN javac ...` create the program that we will actually run. With more complex programs its likely you would use something like `COPY` to takes the whatever files are needed from the local system and copies them into the destination. 

Finally, the `CMD` line will execute the command `java HiWorld` from the *example* directory when the container starts up. It's important to remember that the lifecycle of the container will be tied to this initial process and the container will only exist long enough for the HiWorld program to run. 


We can also expand on this to create this same example taking advantage of multi-stage builds.
```dockerfile
# Define the parent image and give a name to the first stage of building our image
FROM ubuntu AS ubuntu-with-java-example
# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk


# This time we are building from the image that we just defined
FROM ubuntu-with-java-example 
# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java
RUN javac HiWorld.java
# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]
```

# Building an Image

An image will typically be built from a dockerfile, though it can be built from a container that's already running and has been modified. The former is preferred, but the latter can be helpful in a development environment. 

## Create image with build
`> docker build anyflags PATH` 
- `docker build` indicates to the CLI that you are going to create a new image. You have the option of adding flags for additional information and configuration. A couple flags to note:
    - `-f path` indicates that the dockerfile to be used is in the location indicated from the subsequent path (it will be used when that path is different from the build context.)
    - `-t name:version` allows you to name the image being created and indicate the version. If you were to just have `-t name` it would default to having the version marked as `latest`. 
- The path specified at the end of the `docker build` command will be understood as the build context. It will often just be `.` to indicate the current directory. Though it could be a git url or even a path to another part of your filesystem. 

### Example
Create and save the following docker file in a new empty folder. Perhaps you create a folder docker-examples in your Documents folder. 

```dockerfile 
# Define the parent image
FROM ubuntu

# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 

# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example

# Create Hello World Java program and save it in the appropriate file 
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java

# Compile the Java program, creating the file that the JVM can actually run 
RUN javac HiWorld.java

# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]
```
From the same directory in which the dockerfile has been saved run the subsequent command.
(If you saved it in the directory as described above then you would need to run `cd Documents\docker-examples`)

```console
> docker build -t java-hello-world .
```
Do not forget the . at the end. 

There are a couple of things to take notice of here. First, the dockerfile need be the only thing in its directory from which we run the `build` command. That being said, typically you will also have other files in that directory that are needed for the image. 

If we wanted to build the same docker image, perhaps from another folder entirely, then we would have the following command: 
```console
>docker build -f "C:\Users\UserName\Documents\Dockerfile" -t java-hello-world .
```
**Note**: Don't forget the . at the end- indicating that the current context is your build context. 

## Create image with commit 

Assume that you have a container that is already running and you have made some changes to it. Maybe you have installed needed software or changed some configuration. 

Then you can commit these changes to a new image that can be used to spin up even more containers. 

Note the new image won't include any data saved in the *volumes* of your container. 

`> docker commit flags CONTAINER imagename`
- Essentially you are *commiting* the changes from the container specified to the image specified. 
- It is typically preferrable to use a dockerfile, but there are some use cases like debugging where this is helpful. 
- There are a number of flags you can use. They include:
    - `-c ` will allow you to execute/apply Dockerfile instructions
    - `-m` message to include when committing changes 
    - `-p` pauses the container whose state you are committing to the new image

For example imagine you installed some new software and you wanted to create a new image from your current running container: 
```
>docker commit -c "WORKDIR /new-example" -m "added new technology"  -p 1f7e0cf664ca my-fabulous-image
```

## Imgage management
To list all the images.
  - `docker images`
    ```
    docker images -a
    ```
    - `-a`  allows you to list even hidden images. 

# Creating Containers

## Introduction
As we approach creating a container from our image, there are two paths we can take. In the instance where to set up the container requires a greater amount of configuration, it may be beneficial to create the container first and then move to the starting it up once prepared to do so. In most instances, however, we will build and run the container in one fell swoop with a single command. The former approach uses `docker create` and the latter uses `docker run`. Let's explore these ideas in more detail. 

## `> docker create imagename`
- can also be written as `docker container create imagename`
- creates a container that is in the "created" state - it configures and sets it up to be run including creating the *writable layer* on the image from which the container is created
- it's useful if there is some configuration of your container that you want to have ready, so you can easily just start up this new container
- it prints out the id of the newly created container
- flags:
    - `-p hostport:containerport` publish ports creates a mapping from the host port to the container ports 
    - `--env VARIABLE=value` set environment variables of the container
    - `-v hostdirectory:containerdirectory` create a volume between the container and the host machine -- shared memory that persists past the given container's lifecycle  
    - For example, let's pull an existing basic web app from Microsoft and create a container as described above.
    ```console
    > docker docker pull mcr.microsoft.com/dotnet/core/samples:aspnetapp
    > docker create -p 80:80 mcr.microsoft.com/dotnet/core/samples:aspnetapp 
    ```
    Then typically you would then start the container. 
    ```console
    > docker start firstthreecharactersinthecontainerid
    ```
    If you follow the example above- navigate to localhost:80 on your web browser and see that your app has been started - with the container's port 80 being mapped to port 80 on your local machine. 
 
## `> docker run flags imagename`
- Can also be written `docker container run flags imagename`
- First pulls the image from the registry(repo of images) if it doesn't already exist locally.
- Then it both creates and runs the container-- this brings a container directly into the state of *running*.  
- Recall that when you run a container its processes and environment are in their own isolated sandbox.
- To interact with a container's processes and work inside of its environment, you must tie the container to your own current environment- usually by having your commandline tied to a commandline within the container. 
- Many of the flags influence the ways in which the container can be tied to your host environment and/or the way the initial container environment is set up, highlights include: 
    - `-d` 
        - Indicates to run the container in the background 
        - If this flag is *omitted* the shell from which you are running the CLI commands will run in the *foreground*
            - That is, STDOUT and STDERR will be bound to the shell by default. Thus, anything that's printed to STDOUT/STDERR from within the container will display in the current shell. This does not mean that you can interact with 
        Try to test the difference between running:

        ```console
         > docker run hello-world
        ```
        And 
        ```console
        > docker run -d hello-world
        ```
        - The container's id prints out instead of the container's output. 
        - In the second case even though the "Hello World..." output doesn't print, we can view the logs to see that it did in fact run and do what it was supposed to. 
        
        (viewing the logs is explained in [managing containers](./managing-containers.md), but for now run the command with containerID replaced with the output from earlier.)
        ```console
        > docker container logs containerID
        ```
    - `-i` 
        - allows you to run the container in interactive mode 
        - it will keep the STDIN stream open even if your shell isn't attached to it. 
        - it's needed if you want to be able to type input to your container dynamically 
    - `-t`
        - is related to TTY and essentially is used to create some kind of terminal or shell 
    - `-it`
        - This is the combination of the previous two commands and will be very frequently used when you want to open up a container with its primary processes being an interactive shell. 
        - This allows you to basically work within the container from your commandline. 
        For example try running: 
        ```console
        > docker run -it ubuntu
        ```
        Then you can try typing commands in your containerized ubuntu shell that you'll have open. You are essentially working inside of the container. 
    - `-a standardstream`
        - this allows you to attach your commandline to a particular standard stream: `STDIN`, `STDOUT`, or `STDERR` 
        - if you want to attach multiple then you will need multiple `-a ` each followed by the particular stream 
        - Also note, just attaching `STDIN` doesn't automatically make your container interactive. For that you must use the `-i` flag. 
        - For example try testing the differences between attaching to just the error or just the standard output stream 
        ```
        > docker run -a STDERR -p 88:80 mcr.microsoft.com/dotnet/core/samples:aspnetapp 
        ``` 
        You should see your shell kind of paused- as though it's looking for some output, but not receiving any. 
        Then stop your container- see [managing containers.](./managing-containers.md)
        ```
        >docker stop containerid
        ```
        Then create and run a new container from the same image attaching a different stream:
        ```
        >docker run -p 88:80 -a STDOUT mcr.microsoft.com/dotnet/core/samples:aspnetapp 
        ``` 
        Notice how now the standard output from your container displays in the shell. 
    - `-v name:directoryincontainer`
        - Used to create a volume
        - To create a volume you name the volume and then you specify its corresponding path that will be linked within the container (the path must always begin with a / ). 
        - Using this flag you can specify an absolute path on the host machine instead of a name (beginning with /), but that will create a *bind mount*. 
        - volumes will persist after the container no longer exists
        ```console
        > docker run -it -v first_volume:/example ubuntu
        ```
        If inside of the newly created ubuntu shell, run
        ```shell
        $ cd example
        $ echo 'Hello World' > text_file.txt
        ```
        And then stop that container(CTL+C or CTL+D to exit the shell and thus stop the container's primary process exiting the container completely). Now spin up another one with the same volume
        ```console
        > docker run -it -v first_volume:/data ubuntu
        ```
        And then run the command 
        ```shell
        $ cat /data/text_file.txt
        ```
        It will print
        ```
        Hello World
        ```
        Notice/experiment with how this differs from if you created another ubuntu container from the ubuntu image without specifying the volume. It would not by default contain the folders. Those were only created and available because of the way that the volumes were configured. 

    - `-p portonhost:portincontainer`
        - This command publishes a port in the container to a host port. This creates a tie between the two of them. 

        ```console
        docker run -p 90:80 mcr.microsoft.com/dotnet/core/samples:aspnetapp
        ```
        Then go to localhost:90 in the web browser to see site being hosted in the container. 
    - `--env VARIABLE=value` 
        - set the environment variables for the container
        ```console
        >docker run --env VAR1=value1 --env VAR2=value2 ubuntu env
        ```
        Notice that the a whole list of environment variables is displayed, including the ones you just set. 

# Docker compose

## Overview 
Docker compose is the tool that makes creating and managing multi-container applications easier. 

It's fundamental use is based around the docker-compose file. 

The docker-compose file allows you to run multiple containers in a way that eases otherwise cumbersome configuration. Moreover it makes it easy to set up those containers to talk to one another. It's a YAML file(.yaml or .yml) that includes key information including environment variables, ports, volumes etc. 

The file is typically named docker-compose.yml or docker-compose.yaml. 

The file can be used simply with the `docker-compose up` command. This searches the current directory for the appropriate file and spins up the containers outlined. 

## Docker-compose file components 
Docker compose files have an overarching format that has evolved from version to version. There are three overarching versions of the docker-compose file, 1.x, 2.x and 3.x, with smaller upgrades constituting the second part of the version number. This document discusses version 3, but both version 2 and 3 follow the same general format of services, networks, and volumes. There are just some differences in the options/parameters available between the two versions. 

Each service definition is analogous to the `docker run` command. Meanwhile the networks and volumes definitions are analogous to `docker network create` and `docker volume create`.

**Compose file options**: 
- [version](#version)
- [services](#services) 
    - [Options for a service](#Options-for-a-particular-service)
        - [image](#image)
        - [build](#build)
        - [ports](#ports)
        - [environment](#environment)
        - [env_file](#env_file)
- [volumes](#volumes)
- [networks](#networks) 

### Version declaration: 
The docker-compose file begins with the version declaration. It's the first line of the file and helps the docker compose tool understand/process the file correctly. 

For example if we were to use version 3.8. Then we would have: 
```YAML
version: '3.8'
```

### services 
The various docker containers that you spin up via a docker compose file each constitute a particular service. 

At the top level of the docker compose file, you specify a services option and then all the information for each service definition is specified under that service's name (under the services option). For instance: 
```yaml
version: '3.8'

services: 
    db: 
        #all the information for the database set up
    webapp:
        #all the information for the webapp setup 
... 
```
#### Options for a particular service
The following constitute a foundational list of the options for configuring a particular service. 

##### image
The image from which the service ought to be built. 
For example, it might look like this 
```YAML
version: '3.8'

services: 
    db: 
        image: postgres:latest
```

##### build 
The build option allows you to outline how to build a service from a dockerfile. It allows you to specify the configuration needed at build time. This includes information like context, arguments and dockerfile.  
For example, in the simplest case, where the dockerfile and context are the same as the directory of the compose file, you might have: 
```YAML 
version: '3.8'

services: 
    db: 
        build: . 
```
This indicates to build the database from the context of the current directory and a dockerfile within it. 

##### ports 
Allows you to expose ports in the container for the particular service and to map them to ports on the host. The short version of the option syntax is `ports: host:container`. So for example, the declaration might look like this, if postgres was listening in the container on port 8080: 
```YAML
version: '3.8'

services: 
    db: 
        image: 'postgres:11'
        ports:
        - "80:8080"
    ...
```
##### environment
Allows you to specify environment variables for a particular service. For example, you might have  
```YAML
version: '3.8'

services: 
    db: 
        image: 'postgres:11'
        ports:
        - "80:8080"
        environment:
        - POSTGRESQL_HOST=postgresql
        - POSTGRESQL_ROOT_USER=postgres
```
##### env_file
Allows you to specify environment variables for a particular service as the contents of a file. Each line of the file will be an environment variable. (Variables defined under the environment option override environment variables from the env_file)  For example, you might have a file called *db.env* that contains: 
```env
POSTGRESQL_HOST=postgresql
```
Then your compose file might look like this: 
```YAML
version: '3.8'

services: 
    db: 
        image: postgres:latest
        ports:
        - "80:8080"
        env_file:
        - ./db.env
```
##### restart
The restart option indicates the conditions upon which to restart a container. 

The possibilities are: 
- no
  - the default and indicates not to restart the container under any circumstances 
- always
  - always tries to restart the container
- on-failure
  - when there is an on-failure error 
- unless-stopped
  - restart unless the container has been stopped (regardless of whether it's manual or not)

For example you might want you web application to always try to restart: 
```YAML
version: '3.8'

services: 
    web: 
        build: .
        ports:
        - "80:8080"
        env_file:
        - ./web.env
        restart: always
```

### volumes 
*Volumes* is both a top level option and part of the service definition. 

It allows you to specify how the container might interact with some shared and persistent portion of memory. 

For a particular service definition the *volumes* option outlines that service's named volumes or mount host paths. 

Here is a set of examples from the docker docs that outline the different short syntax for the various versions of volumes/mounts. 
```YAML
myservice: 
    ...
    volumes:
        # Just specify a path and let the Engine create a volume
        - /var/lib/mysql

        # Specify an absolute path mapping
        - /opt/data:/var/lib/mysql

        # Path on the host, relative to the Compose file
        - ./cache:/tmp/cache

        # User-relative path
        - ~/configs:/etc/configs/:ro

        # Named volume
        - datavolume:/var/lib/mysql
```
See [this for reference](https://docs.docker.com/compose/compose-file/#volumes). 

If a named volume is meant to be shared among multiple services then you will need the top level *volumes* element as well. 

In the top level *volumes* you will list the named volumes and for each you can specify the driver or you can leave it empty. If its empty then it will use the default driver configured for your docker engine. 

The driver of a volume provides a layer of abstraction allowing you to have your volume locally or on some remote host. 

For example, you might have something similar to this, to use the default volume driver which is typically local for docker engines that have not been reconfigured: 
```YAML
version: '3.8'
services:
    db: 
        ...
        volumes:
        - mydata:/var/postgres
    ...
    backup-db: 
        ...
        volumes:
        - mydata:/example

volumes:
    mydata: 
```
The ... signify omitted portions of the file. 


### networks
Networks were introduced with version 2 of docker compose and they enable containers to easily communicate with one another in a controlled way. (In docker compose version 1, links facilitated the communication between services and they are no longer recommended.) 

By default all services specified in a docker compose file are considered part of the same network. The network is by default named after the directory in which the docker-compose file can be found. Containers on the same network are by default reachable and discoverable by one another using the name of the service and the container.

Let's take for example this file out lined in the [docker documentation.](https://docs.docker.com/compose/networking/)
```YAML
version: "3"
services:
  web:
    build: .
    ports:
      - "8000:8000"
  db:
    image: postgres
    ports:
      - "8001:5432"
``` 
The web service can connect to the db service through the url- `postgres://db:5432`. Note the url begins with the protocol in this case *postgres* and then specifies the host and the port. In this case the host is db and the port is 5432 (which is the container port). For inter container communication the container's use the container ports. 

If we wanted to connect to the db via the host. Our url would be `postgres://{DOCKER_IP}:8001`. Notice that the port would be the host port. 

The docker ip is assigned when the docker container is spun up. By default it's assigned one for each Docker network it's a part of. We can find this information through the command `docker inspect --format='{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' containerID`. 

So that's all great, but what if you want the containers to be part of a smaller network. Maybe you only want two out of the three containers you define in your docker compose file to be able to talk to one another. Well that's where the user defined networks come into play. 

You can name one of the networks or multiple networks in a particular service definition, but then you also need to name these networks using the top level option. 

For example, here there is a db that connects to a backend network. An app that connects to both networks and a service called web that connects to the frontend network. 
```YAML
version: "3"
services:
  app:
    build: ./app
    networks:
      - backend
      - frontend
  web:
    build: ./web
    ports:
      - "8000:8000"
    networks:
      - frontend
  db:
    image: postgres
    ports:
      - "8001:5432"
    networks:
      - backend

networks:
  frontend:
  backend:
``` 
In the top level definition, where we define the custom networks, we can specify to use specific network drivers and some other configuration options. In this case we use all the defaults. 

As with volume drivers, network drivers provide core networking functionality in a way that abstracts it from the hardware itself. The default type is *bridge*. More details on the specifics of drivers and networking can be found [in the article on networking standalone containers.](https://docs.docker.com/network/network-tutorial-standalone/)

Now that the key components of the docker-compose file have been outlined. Let's put them all together. 

## Docker-compose format 
The following is the format all put together with comments detailing the use of the options. 

```YAML
# This is a comment and has nothing to do with the file, 
# but it is helpful for me to describe the different components. 
version: "version number"
# ^ The version of docker compose. For the differences between the different versions see the reference. 
services:
    nameofservice:
    # First you name the service then you define how to build it
    # Either you specify a build including context and dockerfile 
    # path and arguments
        build:
            context: 
            dockerfile: Dockerfilepath
             # any build arguments 
            args: 
                nameofarg: value
    # Then you specify additional information like the ports, network, volumes
        ports:
            - portnum:portnum
    # networks allows you to name a network so that services can only talk to other services on the same network 
        networks:
            - nameofnetwork
    # Then you specify a name of another service to be created
        volumes:
            - nameofvolumeorpath:/pathincontainer
    #environment variables for the particular container
        env_file:
            - nameoffile.env
        environment:
            VARIABLE_NAME: value
    # The other format has - Variablename=value instead of VARIABLE_NAME: value 
        restart: restartoption
        # indicates the conditions upon which to restart a container 
        # either always, on-failure, unless-stopped, and "no"

    nameofanotherservice:
    #if you are using a service with a predefined image you can 
    #omit using the build instruction
        image: nameofimage
    # any additional information needed just like the format above 


# If there is a named network earlier in the file then it will need to be specified as a network with it's driver indicated 
networks:
    nameofnetwork:

# If there is a named volume earlier in the file then it will need to be specified as a volume 
volumes:
   nameofvolume: 

```

## Examples
The following is a simple example of a web application. While we wouldn't typically use a docker compose file to spin up such a simple application, it illustrates a basic version of using docker compose. 

Save the following file as *docker-compose.yaml*. 
```YAML
version: '3'

services:
    webapp:
        image: 'mcr.microsoft.com/dotnet/core/samples:aspnetapp'
        ports:
            - '80:80'
 
```
Then from the commandline in the directory in which the file is saved. 

Run the following command.
```
docker-compose up -d
```
(The -d flag indicates to do it in detached mode, so that all the standard output and error information isn't printing to the shell from which you executed the command.)

You should see the application if you go to localhost:80 in your web browser. 

Then to stop the containers you can run the following command in the command line from the same directory. 

```
docker-compose down
```
For an even simpler example that uses a dockerfile. Save the following docker compose file (docker-compose.yml) to the same folder as the docker file after it. 

```YAML
version: '3'

services:
    javahelloworld:
        build: .
```
```dockerfile
# Define the parent image
FROM ubuntu

# Install needed programs
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y install default-jdk 

# Within the image and thus container, set the working directory to the new directory example
WORKDIR /example

# Create Hello World Java program and save it in the appropriate file 
RUN echo 'public class HiWorld{ public static void main(String[] args){System.out.println("Hi world");}}'> HiWorld.java

# Compile the Java program, creating the file that the JVM can actually run 
RUN javac HiWorld.java

# Run the HelloWorld program in the container 
CMD ["java", "HiWorld"]

```
From the directory with both files run the command `docker-compose up` and you'll see "Hello World" output. 

Finally, let take a look at a more complex example from [docker docs](https://docs.docker.com/compose/wordpress/). 

```YAML
version: '3.3'

services:
   db:
     image: mysql:5.7
     volumes:
       - db_data:/var/lib/mysql
     restart: always
     environment:
       MYSQL_ROOT_PASSWORD: somewordpress
       MYSQL_DATABASE: wordpress
       MYSQL_USER: wordpress
       MYSQL_PASSWORD: wordpress

   wordpress:
     depends_on:
       - db
     image: wordpress:latest
     ports:
       - "8000:80"
     restart: always
     environment:
       WORDPRESS_DB_HOST: db:3306
       WORDPRESS_DB_USER: wordpress
       WORDPRESS_DB_PASSWORD: wordpress
       WORDPRESS_DB_NAME: wordpress
volumes:
    db_data: {}
```
The file outlines using a volume to persist data for the database and application that connects to it. The environment variables allow you to spin up the container in such a way that you have the default credentials set up. You'll also notice that the wordpress web application depends on the database. This ensures the order that the services spin up.   

Save the file into a new directory and from that directory run the command `docker-compose up -d`. 

Then after a giving it a few seconds check out your site at http://localhost:8000/. 

Great work! 



## References
- [Dockerfile Reference](https://docs.docker.com/engine/reference/builder/)
- ## References
- [Docker CLI reference](https://docs.docker.com/reference/)
- [docker build](https://docs.docker.com/engine/reference/commandline/build/)
- [docker commit](https://docs.docker.com/engine/reference/commandline/commit/)
- [docker file](https://docs.docker.com/engine/reference/builder/)
- [Web app for beginners in Python](https://github.com/docker/labs/blob/master/beginner/chapters/webapps.md)
- [Basic Spring App Example](https://stackify.com/guide-docker-java/)
- [docker create imagename](https://docs.docker.com/engine/reference/commandline/create/)
- [docker run imagename](https://docs.docker.com/engine/reference/commandline/create/)
- [Docker compose example](https://docs.docker.com/compose/gettingstarted)
- [Docker compose](https://docs.docker.com/compose/)
- [Docker references](https://docs.docker.com/reference/)
- [Differences between versions](https://docs.docker.com/compose/compose-file/compose-versioning/#upgrading)
- [Docker compose networking](https://docs.docker.com/compose/networking/)
- [Docker compose volumes](https://docs.docker.com/compose/compose-file/#volumes)
