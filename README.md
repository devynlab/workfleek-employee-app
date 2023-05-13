# Simple Employee API

This is a simple employee management API built with Spring Boot.

## Prerequisites

To run this application, you will need to have the following installed:

- Java 17
- Maven 3
- Docker (Optional)
- Docker Compose (Optional)

## Building the Application

To build the application, run the following command from the root directory of the project:

```
mvn clean install
```

## Running the Application

### Using Maven

To run the application using Maven, run the following command from the root directory of the project:

```
mvn spring-boot:run
```

### Using Docker

To run the application using Docker, you can use the following steps:

1. Clone the repository:

```
git clone https://github.com/devynlab/workfleek-employee-app.git
```

2. Change into the project directory:

```
cd employee-app
```

3. Run the following command to build the Docker image:

```
docker-compose up --build
```

This will start the Employee API and PostgreSQL database containers.

You can access the API by navigating to http://127.0.0.1:8080/api/v1/employee-app in your web browser.

## API Endpoints

The application provides the following REST API endpoints:

| **Method** | **Path**                               | **Description**                                  |
| :--------- | -------------------------------------- | ------------------------------------------------ |
| POST       | /api/v1/employee-app/employees         | creates a new employee                           |
| GET        | /api/v1/employee-app/employees         | retrieves all employees with pagination support  |
| GET        | /api/v1/employee-app/employees/{empNo} | retrieves a specific employee by employee number |
| PUT        | /api/v1/employee-app/employees/{empNo} | updates a specific employee by employee number   |
| DELETE     | /api/v1/employee-app/employees/{empNo} | deletes a specific employee by employee number   |

## Technology Stack

The application is built with the following technologies:

- Spring Boot 3.0.6
- PostgreSQL
- Docker 23.0.6
- Docker Compose 2.17.3
