# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.roman.numeral.trojan-horse' is invalid and this project uses 'com.roman.numeral.trojanhorse' instead.

# Getting Started

## Description
This Spring-Boot project was created to transform `Numbers` to `Roman Numerals` and vise-versa. The creation of this project was based on following TDD princlple. The architecture is based on REST.

## Requirements

For building and running the application you need:

- [JDK 17](http://www.oracle.com/technetwork/java/javase/downloads)
- [Maven 3.9.5](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.roman.numeral.trojanhorse.TrojanHorseApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean install; mvn spring-boot:run
```

## Test Coverage
Test coverage is at 100%, using `Jacoco` plugin.

## RoadMap

* Implement `Basic Auth` 
* Implement `RomanNumeralsToNumbersController` API
* Add `Dockerfile` for application to run on any platform including Android phones