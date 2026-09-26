# ERP — Exam Registration Portal

A Spring Boot based **Exam Registration Portal** designed to manage students, staff, courses, registrations, and related academic operations through a RESTful backend.

> **Project Status:** 🚧 Under Development

## 📌 Overview

The ERP (Enterprise Resource Planning) project is a backend system for managing academic and examination-related operations.

The project is being developed using **Java and Spring Boot**, with a focus on REST APIs, database management, validation, authentication, and scalable backend architecture.

## 🛠️ Technology Stack

| Technology        | Usage                         |
| ----------------- | ----------------------------- |
| Java 21           | Programming language          |
| Spring Boot       | Backend framework             |
| Spring MVC        | REST APIs                     |
| Spring Data JPA   | Database interaction          |
| Hibernate         | ORM                           |
| MySQL             | Database                      |
| Spring Validation | Request validation            |
| Spring Security   | Authentication & security     |
| JWT               | Stateless authentication      |
| Maven             | Dependency management & build |
| Lombok            | Boilerplate reduction         |

## ✨ Current Features

### Student Management

* Create students
* Retrieve student information
* Update student information
* Delete students
* Student validation
* Degree and year management

### Staff Management

* Staff management APIs
* Staff information management
* Validation

### Course Management

* Create and manage courses
* Course categorization
* Degree/year based course information

### Registration

* Student course registration
* Registration management
* Registration types

### Authentication

* UID/password based login
* BCrypt password hashing
* Spring Security authentication
* JWT token generation
* JWT authentication filter
* Stateless authentication
* Protected REST endpoints

## 🚧 Planned Features

The project is still under development. Planned improvements include:

* Role-based authorization
* Student/Staff/Admin access control
* Improved exception handling
* Pagination and sorting
* Advanced search and filtering
* Examination management
* Attendance management
* Result management
* Email notifications
* File/document management
* API documentation with Swagger/OpenAPI
* Audit logging
* Caching
* Deployment

## 🏗️ Project Structure

```text
ERP/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── anuj/
│   │   │           └── ERP/
│   │   └── resources/
│   │
│   └── test/
│
├── .mvn/
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 🔐 Security

Authentication is implemented using **Spring Security and JWT**.

The authentication flow is:

```text
User Credentials
      ↓
AuthenticationManager
      ↓
AuthenticationProvider
      ↓
UserDetailsService
      ↓
BCrypt Password Verification
      ↓
JWT Generation
      ↓
JWT Authentication Filter
      ↓
Protected API
```

Role-based authorization is planned for a later stage.

## ⚙️ Setup

### Prerequisites

Make sure you have:

* Java 21
* MySQL
* Maven (optional — Maven Wrapper is included)
* IntelliJ IDEA or another Java IDE

### 1. Clone the repository

```bash
git clone <repository-url>
cd ERP
```

### 2. Configure the database

Create a MySQL database for the project.

Example:

```sql
CREATE DATABASE erp;
```

### 3. Configure local application properties

Create your local:

```text
src/main/resources/application.properties
```

and configure your database credentials.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/erp
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

> `application.properties` is intentionally excluded from Git because it contains local configuration and credentials.

### 4. Run the application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or with Maven installed:

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## 🧪 API Testing

The REST APIs can be tested using tools such as:

* Postman
* IntelliJ HTTP Client
* cURL

Authentication requests require a valid UID and password.

After successful login, the returned JWT can be supplied using:

```text
Authorization: Bearer <JWT>
```

for protected endpoints.

## 📈 Development Roadmap

```text
[x] Core project setup
[x] Student management
[x] Staff management
[x] Course management
[x] Registration
[x] JWT Authentication
[ ] Global exception handling
[ ] Role-based Authorization
[ ] Pagination & Search
[ ] Examination module
[ ] Attendance module
[ ] Result management
[ ] Notifications
[ ] API documentation
[ ] Deployment
```

The roadmap will be updated as development progresses.

## 👨‍💻 Project

**ERP — Exam Registration Portal**

Built as a Spring Boot backend project for learning and implementing real-world enterprise application concepts.
