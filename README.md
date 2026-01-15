# Task Management System

A Spring Boot–based task management system designed to handle concurrent task execution using configurable worker threads.

---

## ⚙️ Setup & Installation Guide

This guide assumes you are **pushing and managing the project directly from IntelliJ IDEA**.

---

## ✅ Prerequisites

Ensure the following tools are installed and configured on your system:

- **Java 17**
  ```bash
  java -version
  ```

- **Apache Maven**
  ```bash
  mvn -version
  ```

- **Git**
  ```bash
  git --version
  ```

> IntelliJ IDEA users are recommended to configure **JDK 17** under  
> `Settings → Build, Execution, Deployment → Build Tools → Maven`.

---

## 📥 Clone the Repository (Optional)

If the project is not already imported into IntelliJ:

```bash
git clone https://github.com/krishnaprasad-tripfactory/task-management-system.git
```

Alternatively, you can **Import Project from VCS** directly in IntelliJ IDEA.

---

## ⚙️ Application Configuration

Configure the number of worker threads for concurrent task execution.

### `application.properties`

```
task.workers = 3
```

> **Note:**  
> The `task.workers` property defines the maximum number of tasks that can run concurrently.  
> Tune this value based on CPU and memory availability.

---

## 🛠️ Build the Application

You can build the project using either **IntelliJ** or **command line**.

### Using IntelliJ IDEA
- Open the **Maven** tool window
- Run: `clean` → `install`

### Using Terminal
```bash
mvn clean install
```

---

## ▶️ Run the Application

### Using IntelliJ IDEA
- Locate the main Spring Boot class
- Click **Run** ▶️

### Using Terminal
```bash
mvn spring-boot:run
```

---

## 🌍 Application Access

Once the application starts successfully, it will be available at:

```
http://localhost:8080
```

---
### Controller Layer
Exposes REST APIs:
- `/queueTask`
- `/checkStatus`
- `/stopTask`

The controller contains **no business logic** and delegates all processing to the service layer.

---

## 🌐 API Endpoints

All endpoints accept and return **JSON**.

---

### ▶️ Queue Task

**Endpoint**
```
POST /queueTask
```

**Request Body**
```json
{
  "id": "task-123",
  "task": "example-task",
  "taskParams": {
    "key": "value"
  },
  "time": 5
}
```

**Response**
```json
{
  "id": "task-123",
  "status": "DONE"
}
```

---

### 🔍 Check Task Status

**Endpoint**
```
POST /checkStatus
```

**Request Body**
```json
{
  "id": "task-123"
}
```

**Response**
```json
{
  "id": "task-123",
  "status": "QUEUED | RUNNING | DONE"
}
```

---

### ⛔ Stop Task

**Endpoint**
```
POST /stopTask
```

**Request Body**
```json
{
  "id": "task-123"
}
```

**Response**
```json
{
  "id": "task-123",
  "status": "STOPPED"
}
```
