# ERP — Exam Registration Portal

A Spring Boot–based **Exam Registration Portal** for managing students, staff, courses, and academic registrations through RESTful APIs.

> **Project Status:** Under Development

## Overview

ERP (Enterprise Resource Planning) is a backend application designed to manage academic and examination-related operations. The project focuses on REST API development, relational database management, request validation, authentication, and application security using Java and Spring Boot.

The goal is to build a maintainable backend system using common enterprise application development practices.

## Technology Stack

| Technology | Usage |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.0.2 | Backend framework |
| Spring MVC | REST API development |
| Spring Data JPA | Database access and repository abstraction |
| Hibernate | Object-relational mapping (ORM) |
| MySQL | Relational database |
| Spring Validation | Request validation |
| Spring Security | Authentication and endpoint security |
| JJWT 0.11.5 | JWT creation and validation |
| BCrypt | Password hashing |
| Maven | Dependency management and build |
| Lombok | Boilerplate code reduction |

## Features

### Student Management

- Create student records
- Retrieve student information
- Update student records
- Delete student records
- Validate student information
- Manage degree and academic year information

### Staff Management

- Staff management REST APIs
- Manage staff information
- Validate staff data

### Course Management

- Create and manage courses
- Organize course information
- Support degree- and academic-year-based course information

### Registration Management

- Register students for courses
- Manage registration information
- Support registration types

### Authentication and Security

- UID/password-based authentication
- Password hashing and verification using BCrypt
- Spring Security integration
- JWT generation and validation
- JWT authentication filter
- Stateless authentication
- Token revocation service
- Protected REST endpoints

### Exception Handling

- Custom application exceptions
- Authentication-specific exceptions
- Exception-handling infrastructure for application errors

*Feature descriptions reflect the current implementation direction. Verify each feature against the latest code before treating it as production-ready.*

## Authentication Flow

The application uses Spring Security and JSON Web Tokens (JWT) to authenticate users and protect REST endpoints.

```text
User Credentials
       |
       v
AuthenticationManager
       |
       v
AuthenticationProvider
       |
       v
UserDetailsService
       |
       v
BCrypt Password Verification
       |
       v
JWT Generation
       |
       v
Client Receives JWT
       |
       v
JWT Authentication Filter
       |
       v
Token Validation
       |
       v
Revocation Check
       |
       v
Protected REST API
```

After successful authentication, the client sends the JWT in subsequent requests using the following HTTP header:

```http
Authorization: Bearer <JWT>
```

The authentication filter validates the token before allowing access to protected endpoints. Token revocation support is intended to prevent revoked tokens from being accepted, subject to the application's implementation and configuration.

## Project Structure

The following is an illustrative structure. Actual package names and directories may differ.

```text
ERP/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── anuj/
│   │   │           └── ERP/
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               ├── repository/
│   │   │               ├── entity/
│   │   │               ├── dto/
│   │   │               ├── security/
│   │   │               └── exception/
│   │   └── resources/
│   └── test/
├── .mvn/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Prerequisites

Before running the application, make sure you have:

- Java Development Kit (JDK) 21
- MySQL Server
- Maven or the included Maven Wrapper
- IntelliJ IDEA, Eclipse, or another Java IDE
- Postman or another REST API testing tool (optional)

## Setup and Installation

### 1. Clone the repository

```bash
git clone https://github.com/Anuj45-new/ERP.git
cd ERP
```

### 2. Configure the database

Create a MySQL database for the application.

Example:

```sql
CREATE DATABASE erp;
```

Use the database name configured in your application.

### 3. Configure application properties

Create or update the local configuration file:

`src/main/resources/application.properties`

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/erp
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

Add any additional properties required by the application's JPA, server, and JWT configuration.

**Security note:** Use your own local database credentials and JWT signing secret. Never commit real credentials, signing secrets, or other sensitive configuration to GitHub.

### 4. Run the application

On Windows, use the Maven Wrapper:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, if Maven is installed:

```bash
mvn spring-boot:run
```

The default application URL is:

```text
http://localhost:8080
```

The application will start on this address unless the server port has been changed in the configuration.

## API Testing

REST endpoints can be tested using:

- Postman
- IntelliJ HTTP Client
- cURL

For protected endpoints:

1. Send an authentication request with valid credentials.
2. Obtain the JWT returned after successful authentication.
3. Add the token to the request headers.
4. Access the required protected endpoint.

Example:

```http
Authorization: Bearer <JWT>
```

The exact request paths and payload formats depend on the application's controller mappings.

## Error Handling

The project includes custom exception classes for application and authentication errors.

The exception-handling layer is intended to provide consistent error responses and simplify error management across the application.

Global exception handling and standardized API error responses should be verified against the current implementation before being considered complete.

## Development Roadmap

The following roadmap identifies implemented areas and potential future improvements.

- [x] Core Spring Boot project setup
- [x] Student management APIs
- [x] Staff management APIs
- [x] Course management APIs
- [x] Registration management
- [x] Spring Security integration
- [x] JWT authentication implementation
- [x] Token revocation service implementation
- [x] Custom exception classes
- [ ] Verify and complete global exception handling
- [ ] Complete and verify role-based authorization
- [ ] Fine-grained access control for students, staff, and administrators
- [ ] Pagination and sorting
- [ ] Advanced search and filtering
- [ ] Examination management
- [ ] Attendance management
- [ ] Result management
- [ ] Email notifications
- [ ] API documentation with Swagger/OpenAPI
- [ ] Automated testing
- [ ] Audit logging
- [ ] Caching where appropriate
- [ ] Deployment

## Future Improvements

Potential improvements include:

- Strengthening authorization and access-control rules
- Improving API error consistency
- Expanding automated unit and integration tests
- Adding API documentation
- Improving database query efficiency
- Introducing deployment and environment-specific configuration
- Adding examination, attendance, and result modules

## Project Information

**Project Name:** ERP — Exam Registration Portal

**Category:** Backend Development

**Primary Technologies:** Java, Spring Boot, Spring Security, JWT, Spring Data JPA, Hibernate, MySQL

**Build Tool:** Maven

This project is being developed as a practical exploration of enterprise backend development, REST API design, relational database integration, authentication, and application security.
