## ⚙️ Setup Instructions

### ✅ Prerequisites
Make sure the following are installed on your system:

- **Java 17**
  ```bash
  java -version
````

* **Maven**

  ```bash
  mvn -version
  ```
* **Git**

---

### 📥 Clone the Repository

```bash
git clone https://github.com/krishnaprasad-tripfactory/task-management-system.git
cd task-management-system
```

---

### ⚙️ Configure Worker Threads

Edit `application.yml` or `application.properties` to set the number of worker threads:

#### application.yml

```yaml
task:
  workers: 3
```

> This value controls how many tasks can run concurrently.

---

### ▶️ Build the Project

```bash
mvn clean install
```

---

### ▶️ Run the Application

```bash
mvn spring-boot:run
```

---

### 🌍 Access the Application

Once the application starts, it will be available at:

```
http://localhost:8080
```

Use **Postman** or **curl** to test the REST APIs.

```

