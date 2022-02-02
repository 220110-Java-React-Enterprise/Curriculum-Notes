# Docker Images
Blueprint for a container 

[This video from VMWare draws an analogy to docker images being like Java classes with containers being analogous to Java objects](https://www.youtube.com/watch?v=EnJ7qX9fkcU&t=4s)

Images form a kind of heirarchy. One image will be "From" another with added info, dependencies, commands, applications, etc. The  added info and command each form a new layer on the image. With each of these layers being indicated in a the Dockerfile that defines what's needed for the image. 

Images are named and tagged with the version. They also have an id which uniquely identifies them. 

## Existing Docker Images
Pull images from some existing registry(repository of images). The default configuration is from the DockerHub. 
- `docker pull *image name* `
- `docker run *image name*` (this will pull the image if it doesn't already exist in the local system)

## Building Our Own Images 
 - Dockerfile
 - From existing container
    - `docker commit` 

We can then `push` our images to a given registry including DockerHub

## Managing Images 

We can use the docker CLI to manage the images on our local system. We can list out the existing images, get their details, remove and update them. 

Additionally, we can use the CLI to aid in connecting to a registry to quickly and easily distribute changes. In this case updating the software is as simple as updating the image. 

Users can easily pull new images and spin up containers/applications with the modifications made. 
    


# Docker Containers

Runnable isolated instance of a set of processes and their dependencies.

A Docker container is built from a Docker image. The image lays out everything the processes that run in the container will need.  

Docker Containers are managed by the Docker Daemon as part of the Docker Engine. The Docker Engine allows Docker containers to be standardized and very portable. 


### Under the hood
The underlying nature of Docker containers is based on the capabilities provided by namespaces and cgroups. Docker containers also take advantage of a file system called UnionFS. Docker manages all this in tandem in a wrapper refered to as *container format*. The container format used by default is `libcontainer`. 
 
Docker containers when run on a Linux system typically share the Host OS- just as one would expect of a containerized app. *The goal is lightweight after all.* 

However, in the case of Windows, Docker containers may use an additional layer of virtualization enabling you to run Linux containers on a Windows OS. This is why it's necessary to have Hyper-V and virtualization enabled when trying to install Docker on a Windows OS. (Because truly it is akin to running a container in a VM.)

### Benefits
And they allow for all the benefits outlined in the containerization notes. i.e.(copied verbatim for convenience) 
 - Secure 
    - Isolation and Virtualization keep your containerized apps more secure
- Standardized and thus Portable
    - Think write once run anywhere
- Lightweight 
	- shares the host operating system's kernel 
- Flexible and Loosely Coupled 
- Scalable
    - Easy to spin up and because of this lightweight ease they can be scaled up quickly 
 

 ### States of a container:
- created
- restarting 
- running 
- paused
- exited
- dead 



# Dockerfile 

Defines everything needed for an image. It outlines the starting point, dependencies and commands that make up all the processes needed for an image and in turn a container. 

Dockerfiles go step by step. 

Dockerfiles always begin with the instruction FROM *image name*. 
(Technically a dockerfile might have parser directives, ARG commands, or comments first. )

- The command FROM indicates the image that you start from, either: 
    - a *parent image* some pre-existing image the container is based on 
    - a *base image* which is when the container is built from the command `FROM scratch` 

Note, while technically a *base image* and *parent image* are different you might hear them used interchangeably.   

After that essentailly each instruction forms anothe layer of the docker image. (These layers are cached to speed up the build.)

Dockerfile commands include things such as installing software in the container, copying and adding files to the container from local or remote systems, defining environment variables needed for the container, and executing commands such as running the intended app in the container. [More on dockerfile commands.](../docker-workflow/dockerfile-keywords.md)

# Docker Volumes


## Overview

**Volumes** are a way to persist data for a container. 

Typically the goal is to have containers exist as mostly stateless. However, sometimes you need information for a container to remain even if the container stops. 

Volumes are managed using the CLI and the Docker API. 

(Note: While there are options for how to persist data, volumes are preferred.) 

They facillitate
- sharing data between many different containers
- decoupling of host and container 
- storing data remotely
- moving data between hosts or backing up data between hosts 

Volumes are also helpful because they allow Docker to keep the containers slim by saving data in the volume rather than the writable layer that dissappears with the container. 

# Docker Best Practices

### Goals
- "ephemeral" containers-- containers should be as easy as possible to tear down and build up, requiring minimal configuration
- lightweight containers and images
    - "ephemeral" and lightweight go hand in hand, but additionally lightweight relies on a couple of other best practices
 
### Build Context
The working directory (including subdirectories) is sent over to the Docker daemon when the image is created i.e. the `docker build` command is run. 

Thus, it's important to be mindful of what is in that directory. The less that's there the faster the process and lighter weight the image. 

### Leverage multi-stage builds and image cache 
Previous images are cached, since images are layered this can be leveraged to dramatically speed up building an image. It reduces the amount of times that you must pull from remote storage or rebuild image layers.   

** Be mindful of the cache though as some layers maybe cached and not properly updated. For instance, `RUN apt-get update` will be read as the same string every time and will not be run again if the cached image was built in exactly the same way with no other changes. 

### Additional Best Practices:
- Least number of ultimate layers for an image possible
    - These will be defined by the different commands in the dockerfile 
- Each Container should ideally serve one sole purpose and applications should be decoupled as much as possible 
- Make commands in dockerfile readable by separating them on to different lines with \ (the escape character) and by keeping those lines organized in some fashion 
- Use volumes for persistent data 
- Use secrets for sensitive data and config files for configurations that are not sensitive 



#### References
- Video linked to above from VMWare (This is also in the Containerization References)
- [References listed in Refernces in Containerization Refs.](./containerization.md#reference) 
- https://docs.docker.com/engine/api/v1.24/#31-containers
- Docker docs https://docs.docker.com/engine/reference/commandline/container/
- [Containerization References](./containerization.md#reference)
- [Dockerfile Best Practices](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
- [Dockerfile Reference](https://docs.docker.com/engine/reference/builder/)
- [Docker glossary](https://docs.docker.com/glossary/)
- https://docs.docker.com/storage/volumes/
- https://docs.docker.com/storage/
- [Docker Guide- Dockerfile Best Practices](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
- [Docker Guide- Docker Best Practices](https://docs.docker.com/develop/dev-best-practices/)
