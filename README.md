# CareerConnectAI


CareerConnectAI is a Spring Boot backend application that simulates a campus placement management system. It enables students to register, companies to create placement drives, and students to apply for those drives after passing eligibility checks.

The project is built using layered architecture and demonstrates various backend design patterns and Spring Boot best practices.

---

## Features

### Student Management
- Register a student
- Get student by ID
- Get all students

### Company Management
- Register a company
- Get company by ID
- Get all companies

### Placement Drive Management
- Create a placement drive
- Get placement drive by ID
- Get all placement drives

### Application Management
- Apply for a placement drive
- Get application by ID
- Get all applications

### Eligibility Engine
Students are allowed to apply only if they satisfy all eligibility conditions:

- Minimum CGPA
- Maximum Active Backlogs
- Required Skills

This is implemented using the **Strategy Design Pattern**.

---

# Tech Stack

- Java 21
- Spring Boot 3
- Maven
- Lombok
- Jakarta Validation
- Postman
- Git & GitHub

---

# Project Architecture

```
Controller
      ↓
Service
      ↓
Repository
      ↓
In-Memory Storage (HashMap)
```

---

# Design Patterns Used

### Repository Pattern

Used to separate data access logic from business logic.

Repositories:

- StudentRepository
- CompanyRepository
- PlacementDriveRepository
- ApplicationRepository

---

### Service Pattern

Contains business logic.

Services:

- StudentService
- CompanyService
- PlacementDriveService
- ApplicationService
- EligibilityService

---

### Strategy Pattern

Eligibility checking is implemented using separate strategies.

```
EligibilityStrategy
        │
        ├── CgpaEligibilityStrategy
        ├── BacklogEligibilityStrategy
        └── SkillEligibilityStrategy
```

---

### Builder Pattern

Implemented using Lombok.

Example:

```java
Student.builder()
       .studentId("S101")
       .name("Bhavishyata")
       .build();
```

---

# Validation

Implemented using Jakarta Validation.

Examples:

- @NotBlank
- @NotNull
- @Email
- @Positive

Invalid requests return proper validation errors.

---

# Global Exception Handling

Implemented using:

```
@RestControllerAdvice
```

Custom Exceptions:

- StudentNotFoundException
- DuplicateStudentException
- CompanyNotFoundException
- DuplicateCompanyException
- PlacementDriveNotFoundException
- DuplicatePlacementDriveException
- ApplicationNotFoundException
- DuplicateApplicationException
- StudentNotEligibleException

---

# API Endpoints

## Student APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /students | Register Student |
| GET | /students | Get All Students |
| GET | /students/{id} | Get Student By Id |

---

## Company APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /companies | Register Company |
| GET | /companies | Get All Companies |
| GET | /companies/{id} | Get Company By Id |

---

## Placement Drive APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /drives | Create Placement Drive |
| GET | /drives | Get All Drives |
| GET | /drives/{id} | Get Drive By Id |

---

## Application APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /applications | Apply for Placement Drive |
| GET | /applications | Get All Applications |
| GET | /applications/{id} | Get Application By Id |

---

# Project Structure

```
src
└── main
    └── java
        └── com.careerconnect
            ├── controller
            ├── dto
            │   ├── request
            │   └── response
            ├── exception
            ├── mapper
            ├── model
            │   ├── entity
            │   └── enums
            ├── repository
            │   └── impl
            ├── service
            │   └── impl
            ├── strategy
            │   └── impl
            └── CareerConnectAiApplication
```

---

# Testing

The APIs have been tested using Postman.

Tested Scenarios:

- Student Registration
- Company Registration
- Placement Drive Creation
- Application Submission
- Duplicate Record Validation
- Student Not Found
- Company Not Found
- Placement Drive Not Found
- Eligibility Validation

---

# Current Storage

This project currently uses **In-Memory Storage (HashMap)**.

Data is available only while the application is running.

After restarting the application, all data is cleared.

---

# Future Enhancements

- Spring Data JPA
- MySQL Database
- Spring Security
- JWT Authentication
- Swagger/OpenAPI Documentation
- Docker Support
- Unit Testing with JUnit & Mockito
- Role Based Access
- Email Notifications

---

# Author

**Bhavishyata Yadav**

GitHub:
https://github.com/raobhavi17-svg

---

# How to Run

Clone the repository

```bash
git clone https://github.com/raobhavi17-svg/CareerConnectAI.git
```

Go inside project

```bash
cd CareerConnectAI
```

Run the application

```bash
mvn spring-boot:run
```

or run

```
CareerConnectAiApplication.java
```

The application will start on

```
http://localhost:8080
```

---

# Status

Project Status: **Phase 1, Phase 2 & Phase 3 Completed**

Completed Modules

- Student Module
- Company Module
- Placement Drive Module
- Application Module
- Eligibility Engine
- Exception Handling
- DTO Layer
- Mapper Layer
- Strategy Pattern
- REST APIs
- Postman Testing
