# Prototype Seed Project

This project exists to provide a seed project for prototyping with **SpringBoot** and **Angular 7**.
When built, it provides an executable JAR file containing both the backend and frontend code under a single embedded web server. In addition, the build generates a **Docker** image that includes the Java JDK.

## Layout

This project contains two discrete parts:
* An **Angular 7** frontend under `npm-app`
* A **SpringBoot** web tier under `java-app`

Although the build merges these two portions into a single delivery, they can be started indepdently during development in order to better support hot code replacement.

## Build

To build the runnable JAR file for this project, run the following command from the root directory:
```bash
$ gradlew build
```
The versioned JAR file can be found under `java-app/build/libs`.

To build the Docker image for this project, run the following command from the root directory:
```bash
$ gradlew buildDocker
```
The Docker image can be found in the local Docker repository.

## Development

TBD