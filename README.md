Table of Contents
=================
* [Table of Contents](#table-of-contents)
* [Read Me First](#read-me-first)
* [Getting Started](#getting-started)
* [Description](#description)
* [Requirements](#requirements)
* [Deploy](#deploy)
   * [IDE instructions:](#ide-instructions)
   * [CMD instructions:](#cmd-instructions)
   * [Docker instructions:](#docker-instructions)
* [Usage](#usage)
* [Test](#test)
* [RoadMap](#roadmap)


# Read Me First

The following was discovered as part of building this project:

* The original package name 'com.roman.numeral.trojan-horse' is invalid and this project uses 'com.roman.numeral.trojanhorse' instead.

# Getting Started

# Description

This Spring-Boot project was created to transform `Numbers` to `Roman Numerals` and `vise-versa`. The creation of this project was based on following TDD princlple. The architecture is based on REST.

# Requirements

For building and running the application you need:

* [JDK 17](http://www.oracle.com/technetwork/java/javase/downloads)
* [Maven 3.9.5](https://maven.apache.org)

# Deploy

## IDE instructions:

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.roman.numeral.trojanhorse.Application` class from your IDE.

## CMD instructions:

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean install; mvn spring-boot:run
```
## Docker instructions:

Please be sure you have [Docker](https://www.docker.com/products/docker-desktop/) installed before following instructions below:

* CD into project directory

* Build Docker image
    ```shell
    docker build -t trojanhorse .
    ```

* Run Docker image with port binding
    ```shell
    docker run -p 9000:9000 -i -t trojanhorse
    ```

# Usage

Currently the API only supports converting `Numbers` to `Roman Numerals`. Use following format:

* http://localhost:9000/api/numbers/to/roman/numerals/{number}

# Test 

* Used TDD throughout the project development
* Added `Jacoco` plugin, to verify test coverage at 100%

# RoadMap

* ~~Add `Dockerfile` for application to run on any platform~~
* ~~Add `Github Actions` CI/CD~~
  * ~~Build and test CI~~
  * ~~Checkstyle CI~~
    * ~~Use sun code conventions Ref: https://checkstyle.sourceforge.io/~~
  * ~~Docker CI~~
    * ~~Publish only latest artifacts from main branch to `Docker Repository`~~
* Implement `RomanNumeralsToNumbersController` API
* Implement `Basic Auth` 
