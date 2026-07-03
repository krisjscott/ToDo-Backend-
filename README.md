# TodoApp

A RESTful Todo API built with Spring Boot, JPA, and MySQL.

## Tech Stack

- **Java 25** / **Spring Boot 4.1**
- **Spring Data JPA** — persistence layer
- **Spring Security** — HTTP Basic auth (stateless)
- **MySQL** — database
- **Lombok** — boilerplate reduction
- **Gradle** — build tool

## Prerequisites

- Java 25+
- MySQL running on `localhost:3306`
- A database named `TODO` created in MySQL

```sql
CREATE DATABASE TODO;
```

## Configuration

Edit `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/TODO
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

## Running the App

```bash
./gradlew bootRun
```

The server starts at `http://localhost:8080`.

## API Endpoints

All endpoints are under `/api/v1/tasks` and require HTTP Basic authentication.

| Method | Endpoint              | Description        |
|--------|-----------------------|--------------------|
| GET    | `/api/v1/tasks/`      | Get all tasks      |
| GET    | `/api/v1/tasks/{id}`  | Get task by ID     |
| POST   | `/api/v1/tasks/`      | Create a new task  |
| PUT    | `/api/v1/tasks/{id}`  | Update a task      |
| DELETE | `/api/v1/tasks/{id}`  | Delete a task      |

### Task JSON

```json
{
  "title": "Buy groceries",
  "description": "Milk, eggs, bread",
  "completed": false
}
```

## Build

```bash
./gradlew build
```

Produces `build/libs/TodoApp-0.0.1-SNAPSHOT.jar`.

## Run Tests

```bash
./gradlew test
```
