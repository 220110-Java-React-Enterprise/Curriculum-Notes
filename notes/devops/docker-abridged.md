# Docker Abridged Notes
The official notes on Docker are very extensive, so we will be building our own slimmed down version of the notes here. We want to keep the QC question bank in mind as we go through the docker lecture and put the most pertinent information here.

[QC Questions:](./../../qc-study/qc-docker.md)
 - What is Docker?
   - Docker is a set of Platform as a Service products that use OS virtualization to deliver software in packages called containers.
 - What is a container?
   - A container is a tool for packaging an application with it's dependencies so that it runs on it's own in an isolated sandbox. 
 - How is a container different from a virtual machine?
   - Virtual machines emulate, or virtualize, physical hardware and traditionally run a guest OS required for running other software. Containers, on the other hand, virtualize the OS.
 - What is the Docker Daemon?
   - The Docker Daemon is the core process of the Docker host that does all the heavy lifting. This manages Docker objects: containers, images, etc. 
 - Why is containerization so important?
   - Contanerization helps to ensure the application can run reliably regardless of the host environment.Containerization can also help keep the host safe, as the container shouldn't be able to modify or interact with the host environment or other containers.
 - What is a Dockerfile?
   - A file that defines everything needed for an image. It outlines the starting point, dependencies, and commands that make up all the processes needed for an image and in turn a container.
 - What commands would you find within a Dockerfile?
   - FROM, COPY, RUN, 
 - What is a Docker image?
 - How would I create a Docker image from a Dockerfile?
 - What is a Docker container?
 - How is a Docker container different from a Docker image?
 - How would I create a Docker container from a Docker image?
 - What is DockerHub?
 - What Docker command will list all running containers?
 - What is container orchestration? Why is it important?
 - What technologies exist in order to help with container orchestration?
 - What is the benefit to an image being built in Layers?
 - What are some other Docker commands?
 - What is Docker compose and why is it useful?
 - If you want to store state for a container, how does Docker recommend doing that?
