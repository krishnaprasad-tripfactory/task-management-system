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
cd task-management-system
```

Alternatively, you can **Import Project from VCS** directly in IntelliJ IDEA.

---

## ⚙️ Application Configuration

Configure the number of worker threads for concurrent task execution.

### `application.yml`

```yaml
task:
  workers: 3
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

## 🔗 API Testing (cURL Examples)

Below are sample `curl` commands for testing APIs on **macOS/Linux** and **Windows**.

> Replace endpoint paths as per your controller mappings.

---

### ▶️ Create a Task

#### macOS / Linux
```bash
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{
  "name": "Sample Task",
  "time": 5
}'
```

#### Windows (PowerShell)
```powershell
curl -X POST http://localhost:8080/tasks ^
-H "Content-Type: application/json" ^
-d "{\"name\":\"Sample Task\",\"time\":5}"
```

---

### ▶️ Get Task Status

#### macOS / Linux
```bash
curl http://localhost:8080/tasks/1
```

#### Windows (PowerShell)
```powershell
curl http://localhost:8080/tasks/1
```

---

## 📦 Git Workflow (IntelliJ)

1. Make changes in IntelliJ
2. Commit using **Git → Commit**
3. Push using **Git → Push**

No manual terminal Git commands are required when using IntelliJ IDEA.

---

## ✅ Notes

- Ensure port **8080** is free before running the application
- Increase `task.workers` carefully to avoid thread exhaustion
- Logs can be monitored from the IntelliJ Run Console

---
