# selenium-java-docker Suite

## Prerequisites
- Java 8+ Installed
- Maven 3.6.3 installed and configured
- Docker
- docker-compose
- Some VNC Viewer to see the tests.

## First Run
After installing and configuring the prerequisites:

- In a terminal, run `docker-compose -f docker-compose.yaml up -d` on the project root folder

Wait for docker images being pulled and set up.
  
- run `mvn clean install` to build the repo and install the dependencies. At the end of the cycle the tests will be executed.

## VNC
To check the tests being executed inside docker, with a VNC Viewer of your preference, access `127.0.0.1:9002` with password: `secret`

## Development
You can easily open this project using IntelliJ IDEA.