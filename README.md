# healthcare-tracker app

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Database
For this project Postgres Database is used and all the database url, user and password can be configure from the application.properties file. If you want to run please update these field as per you database config at application.properties: 
````
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/healthcaredb
spring.datasource.username=username
spring.datasource.password=password
````

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.centene.healthcaretracker.HealthcareTrackerApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
