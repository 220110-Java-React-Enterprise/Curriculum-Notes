# Docker Command Cheatsheet
## Docker Codumentation
- [Docker CLI reference](https://docs.docker.com/reference/)
  - [docker build](https://docs.docker.com/engine/reference/commandline/build/)
  - [docker commit](https://docs.docker.com/engine/reference/commandline/commit/)
  - [docker ps](https://docs.docker.com/engine/reference/commandline/ps/)
  - [docker container exec](https://docs.docker.com/engine/reference/commandline/container_exec/)
  - [docker container logs](https://docs.docker.com/engine/reference/commandline/container_logs/)
  - [docker container port](https://docs.docker.com/engine/reference/commandline/container_port/)
  - [docker container kill](https://docs.docker.com/engine/reference/commandline/container_kill/)
  - [docker container stop](https://docs.docker.com/engine/reference/commandline/container_stop/)
  - [docker push](https://docs.docker.com/engine/reference/commandline/push/)
  - [docker pull](https://docs.docker.com/engine/reference/commandline/pull/)


List of major commands and relevant flags. All of these commands can be found in other places in the lecture notes, so their detailed explanations are omitted. 

Also many of these commands have additional flags. Only the most important/relevant are listed here. 

## Create Images
These commands can be used to create images either from running containers or from a dockerfile. 
[See notes on building an image.](./building-an-image.md)

  - **`docker build`**
    - used to create an image from a dockerfile. 
    - Example:
    ```console
    > docker build -t java-hello-world .
    ```
    - Flags: 
      - `-t imagename:version` 
      - `-f dockerfilepath`


  - **`docker commit`**
    - used to create an image from an existing container.
    - Example
    ```console
    > docker commit 586 java-hello-world 
    ```
    - Flags
      - `-c `
      - `-m `
      - ` -p`

## Manage Docker Images 
The following commands can be used to manage images on your local machine as well as on the DockerHub. 
[See notes on DockerHub.](./dockerhub-container-registry.md)
[See notes on building an image.](./building-an-image.md)

  - **`docker images`**
    - list all the images on your local machine
    - Example
    ```
    >docker images -a
    ```
    - Flags:
      - `-a`  

  - **`docker pull`**
    - retrieve an image from the DockerHub
    - Example
    ```
    >docker pull ubuntu
    ```

  - **`docker push`**
    - share your image to DockerHub
    - Example
    ```
    >docker push revature/java-hello-world:1.0
    ```


## Manage Docker Containers
These commands can be used to start and manage docker containers. 
See [notes on creating containers.](./creating-containers.md)
See [notes on managing containers.](./managing-containers.md)
  - **`docker run`**
    - same as `docker container run`
    - create and run a container from an image
    - if the image is not already on your local machine, then pull it from the DockerHub 
    - Example
    ```console
    >docker run -it ubuntu 
    ```
    - Flags
      - `-d`
      - `-it`
      - `-p`
      - `-v`
      - `env`

  - **`docker ps `**
    - list all containers
    - Example
    ```
    >docker ps -a
    ```
    - Flags
      - `-a`

  - **`docker container logs `**
    - view the standard error and output of a container
    - Example
    ```
    >docker container logs 586
    ```
  - **`docker container exec `**
    - execute a command in a running container
    - Example
    ```
    docker container exec -it bin/bash 586
    ```
    - Flags
      - `-it`
  - **`docker container port `**
    - list port mappings between a container and its host  
    - Example
    ```console  
    >docker container port 563
    ``` 
  - **`docker container stop `**
    - stop a particular container
    - Example
    ```console  
    >docker container stop 563
    ``` 
  - **`docker container kill `**
    - forcibly stop a container 
    - Example
    ```console  
    >docker container kill 563
    ``` 
  - **`docker container rm `**
    - remove a particular container  
    - Example
    ```console  
    >docker container rm -f -v 563
    ``` 
    - Flags:
      - `-f`
      - `-v`
  - **`docker volume rm `**
    - remove a volume
    - Example
    ```console
    >docker volume rm my_volume
    ```
  - **`docker container prune`**
    - remove exited containers
    - Example
    ```console
    >docker container prune
    ```
