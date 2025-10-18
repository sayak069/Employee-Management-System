# 🧑‍💼 Employee Management System

A simple **Java-based Employee Management System** built using **JDBC**, **Oracle Database**, and **Connection Pooling**, following a clean **layered architecture (DAO–Service–Factory)**.  
This project demonstrates core Java enterprise concepts like data encapsulation, JDBC CRUD operations, service abstraction, and modular design.

---

## 📂 Project Structure

```
Employee-Management-System/
│
├── pom.xml # Maven project descriptor
├── .classpath, .project # Eclipse project files
│
├── src/
│ └── main/
│ ├── java/
│ │ └── com/abc/
│ │ ├── bean/
│ │ │ └── Employee.java # Model class (POJO)
│ │ ├── dao/
│ │ │ ├── IEmployeeDao.java # DAO interface
│ │ │ └── EmployeeDaoImpl.java # DAO implementation
│ │ ├── service/
│ │ │ ├── IEmployeeService.java # Service interface
│ │ │ └── EmployeeServiceImpl.java # Service implementation
│ │ ├── factory/
│ │ │ ├── ConnectionFactory.java # Creates and manages DB connections
│ │ │ ├── EmployeeDaoFactory.java # Provides DAO instances
│ │ │ └── EmployeeServiceFactory.java # Provides Service instances
│ │ └── test/
│ │ └── EmployeeTest.java # Test/driver class (main entry point)
│ └── resources/
│
└── target/ # Compiled classes & build artifacts
```

---

## 🧠 Project Architecture

This system follows a **multi-layered architecture**:

EmployeeTest (Main/UI)
│
▼
EmployeeServiceImpl (Business Logic)
│
▼
EmployeeDaoImpl (JDBC CRUD)
│
▼
Oracle Database

---

## ⚙️ Technologies Used

- **Java 17+**
- **Oracle Database**
- **JDBC (Java Database Connectivity)**
- **Maven** for build automation
- **Eclipse IDE** (project compatible)
- **Connection Pooling** for efficient DB management

---

## 🧩 Features

✅ Add new employees  
✅ Update existing employee details using ID
✅ Delete employees by ID  
✅ Retrieve employee information using ID
✅ Uses connection pooling for performance  
✅ Follows clean separation of concerns (DAO–Service–Factory)  

---

### ⭐ If you like this project, give it a star on GitHub!
