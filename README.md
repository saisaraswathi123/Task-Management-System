# Task-Management-System
A simple "Spring Boot CRUD Application" that allows users to manage tasks. It provides APIs for adding, retrieving, and managing tasks using "Spring Boot, JPA, and PostgreSQL".


##  Project Importance
- Task Management              : Allows users to create, update, retrieve, and delete tasks.
- Spring Boot & REST API       : Demonstrates how to build RESTful services using Spring Boot.
- Database Integration         : Uses JPA with "PostgreSQL" for data persistence.
- Maven & Dependency Management: Utilizes Maven for project and dependency management.
- Postman API Testing          : API endpoints are tested with Postman.

---

##  Technologies Used & Their Purpose
| Technology         | Purpose |
|--------------------|---------|
| Spring Boot        | To create RESTful web services. 
| Spring Data JPA    | For database interaction with PostgreSQL. 
| PostgreSQL         | Relational database for task storage. 
| Maven              | Dependency management and build automation. 
| Postman            | API testing tool. 
| Lombok             | Reduces boilerplate code for models and services. 

---

##  Project Structure

Task-Management-System/
│── src/main/java/com/example/demo
│   ├── controller
│   │   ├── TaskController.java
│   ├── model
│   │   ├── Task.java
│   ├── repository
│   │   ├── TaskRepository.java
│   ├── service
│   │   ├── TaskService.java
│   ├── DemoApplication.java
│── src/main/resources
│   ├── application.properties
│── pom.xml
│── README.md

---

##  Important Code
### 🔹 Task Model (Task.java)
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // Getters & Setters
}


### 🔹 Task Repository (TaskRepository.java)

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}

### 🔹 Task Service (TaskService.java)
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}


### 🔹 Task Controller (TaskController.java)

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
}


##  API Endpoints
| Method | Endpoint         | Description              |
|--------|-----------------|--------------------------|
| GET    | `/tasks`        | Get all tasks           |
| GET    | `/tasks/{id}`   | Get a task by ID        |
| POST   | `/tasks`        | Create a new task       |


##  Output Diagram

Client (Postman, Frontend)
       │
       ▼
Spring Boot REST API (TaskController)
       │
       ▼
Service Layer (TaskService)
       │
       ▼
Database (PostgreSQL)


## ▶ How to Run the Project

1. Build and Run

   mvn clean package
   mvn spring-boot:run

2. Test with Postman
   - Open Postman and test API endpoints.


##  Conclusion
This project is a simple yet powerful example of "Spring Boot REST API development" with "PostgreSQL and JPA integration".

