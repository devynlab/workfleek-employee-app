# Simple Employee API

This is a sample Spring Boot application that provides REST API endpoints to manage employees. The application is built with Spring Boot 3.0.6 and uses PostgreSQL as the database.

The application provides the following REST API endpoints:

| **Method** | **Path**                               | **Description**                                  |
| :--------- | -------------------------------------- | ------------------------------------------------ |
| POST       | /api/v1/employee-app/employees         | creates a new employee                           |
| GET        | /api/v1/employee-app/employees         | retrieves all employees with pagination support  |
| GET        | /api/v1/employee-app/employees/{empNo} | retrieves a specific employee by employee number |
| PUT        | /api/v1/employee-app/employees/{empNo} | updates a specific employee by employee number   |
| DELETE     | /api/v1/employee-app/employees/{empNo} | deletes a specific employee by employee number   |

The application uses the `@Valid` annotation to validate incoming requests. The `EmployeeRequest` class is used to map the incoming JSON request body to a Java object. The `EmployeeResponse` class is used to map the response data to a JSON format.

The application uses ModelMapper to map the incoming EmployeeRequest object to a Employee entity object and vice versa.

The application.properties file contains the configuration for the database connection and other application settings.

To run the application, you can use the following command:

```
 mvn spring-boot:run
```

You can also build the application with the following command:

```
 mvn clean package
```

This will generate an executable JAR file under the target directory. You can run the JAR file with the following command:

```
 java -jar target/employee-app-0.0.1-SNAPSHOT.jar
```
