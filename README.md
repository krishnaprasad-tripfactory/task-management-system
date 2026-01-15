# Task Management System

A Spring Boot–based task management system designed to handle concurrent task execution using configurable worker threads.

---

## ⚙️ Setup & Installation Guide

Follow the steps below to set up and run the application locally.

---

## ✅ Prerequisites

Ensure the following tools are installed and available in your system path:

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

---

## 📥 Clone the Repository

Clone the repository and navigate to the project root:

```bash
git clone https://github.com/krishnaprasad-tripfactory/task-management-system.git
cd task-management-system
```

---

## ⚙️ Application Configuration

Configure the number of worker threads responsible for concurrent task execution.

### `application.yml`

```yaml
task:
  workers: 3
```

> **Note:**  
> The `task.workers` property determines how many tasks can be executed concurrently.  
> Adjust this value based on system resources and workload requirements.

---

## 🛠️ Build the Application

Compile the project and resolve dependencies using Maven:

```bash
mvn clean install
```

---

## ▶️ Run the Application

Start the Spring Boot application using the following command:

```bash
mvn spring-boot:run
```

---

## 🌍 Application Access

Once the application starts successfully, it will be accessible at:

```
http://localhost:8080
```

Use tools such as **Postman** or **curl** to interact with the REST APIs.

---
