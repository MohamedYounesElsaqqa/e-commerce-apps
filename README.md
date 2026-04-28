# 🛒 E-Commerce Microservices Platform

A cloud-native **E-Commerce system** built using **Spring Boot 3** and **Spring Cloud**, following **Microservices Architecture** and **Domain-Driven Design (DDD)** principles to ensure scalability, resilience, and maintainability.

---

## 🏗️ Architecture Overview

The system is divided into two main layers:

- **Public Network**
  - API Gateway (client-facing entry point)

- **Private Network**
  - Internal microservices communication

### 🔑 Core Components

- **API Gateway**  
  Routes client requests to the appropriate microservices.

- **Service Discovery (Eureka Server)**  
  Enables dynamic service registration and discovery.

- **Config Server**  
  Centralized configuration management across all services.

- **Message Broker (Apache Kafka)**  
  Handles asynchronous communication between services.

- **Distributed Tracing (Zipkin)**  
  Tracks requests across distributed services.

---

## 📂 Microservices Domains (DDD)

### 👤 Customer Service
- Manages customer data
- Entities:
  - Customer (id, firstname, lastname, email)
  - Address (street, houseNumber, zipCode)
- Relationship: One-to-One

---

### 📦 Product Service
- Manages products and categories
- Entities:
  - Product (name, description, price, availableQuantity)
  - Category (name, description)
- Relationship: One-to-Many

---

### 🧾 Order Service
- Handles order creation and lifecycle
- Entities:
  - Order (id, orderDate, reference)
  - OrderLine (quantity, productId)
- Relationship: One-to-Many
- Uses productId only (Loose Coupling)

---

### 💳 Payment Service
- Handles payment processing
- Entity:
  - Payment (reference, amount, status)
- Communicates via events (Kafka)

---

### 🔔 Notification Service
- Sends notifications (email/messages)
- Entity:
  - Notification (sender, recipient, content, date)
- Fully asynchronous

---

## 🔄 System Flow

1. User sends request via API Gateway  
2. Order Service creates order  
3. Event published → `OrderCreated`  
4. Payment Service processes payment  
5. Event published → `PaymentCompleted`  
6. Notification Service sends confirmation  

---

## 🧠 Key Design Principles

- **Database per Service**
- **Loose Coupling**
- **High Cohesion**
- **Event-Driven Architecture**

---

## 📊 Data Model

- Customer ↔ Address → One-to-One  
- Product ↔ Category → One-to-Many  
- Order ↔ OrderLine → One-to-Many  
- OrderLine references productId only  

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot 3  
- **Cloud:** Spring Cloud (Gateway, Eureka, Config)  
- **Database:**
  - MongoDB (Customer, Notification)
  - Relational DB (Order, Product)
- **Messaging:** Apache Kafka  
- **Containerization:** Docker  
- **Monitoring:** Zipkin  

---

## 🚀 Advanced Concepts

- Domain-Driven Design (DDD)
- Event-Driven Architecture
- Distributed Systems
- Service Isolation
- Observability (Tracing & Logging)

---

## 💡 Key Takeaways

- Microservices represent independent business domains  
- Event-driven communication improves scalability  
- Avoid tight coupling between services  

---

## 🔥 Future Improvements

- Implement Saga Pattern for distributed transactions  
- Add Redis caching  
- Use Kubernetes for orchestration  

---

## 📸 Architecture Diagram

> Add your system design diagram here (ERD / Microservices Diagram)

---

## 👨‍💻 Author

Mohamed Gohar  
Backend Developer | Java | Spring Boot | Microservices
## ✨ Notes
AI tools were used to enhance the documentation quality, while the architecture and implementation reflect my own work and understanding.

