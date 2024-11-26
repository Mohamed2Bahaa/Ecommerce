
# E-Commerce Microservices Application 🚀

## **Project Overview**
This is a **fully functional E-Commerce application** built using microservices architecture. The application is currently under construction, with the core functionality implemented and a few components yet to be finalized.

### **Implemented Microservices**
1. **Customer Service**: Handles user management and customer-related operations.
2. **Product Service**: Manages product inventory, pricing, and availability.
3. **Order Service**: Handles order creation, updates, and retrieval.
4. **Payment Service**: Processes payments for placed orders.
5. **Notification Service**: (Planned, not yet completed) Will handle notifications (email/SMS) for system events.

### **Work in Progress**
- **Notification Service**: Yet to be finalized.
- **Zipkin**: Distributed tracing for debugging and monitoring microservices communication.
- **API Gateway**: Centralized entry point for managing requests across services.

---

## **Technologies Used**
### **Core Frameworks and Tools**
- **Spring Boot**: To implement the microservices.
- **Spring Cloud**: For service discovery and configuration management.
- **Kafka**: Message broker for asynchronous communication.
- **Flyway**: Database migration tool for version control.
- **Docker**: Used to containerize and manage database services.

### **Database**
- **PostgreSQL**: Primary relational database for structured data.
- **MongoDB**: NoSQL database for unstructured or semi-structured data.

---

## **System Architecture**
The project follows a **microservices architecture** where each service is independent and loosely coupled, enabling scalability and easy maintenance.

### **Communication**
- **REST APIs**: For synchronous communication between services.
- **Apache Kafka**: For asynchronous communication via message streams.

---

## **Project Structure**
```plaintext
├── Customer Service
├── Product Service
├── Order Service
├── Payment Service
├── Notification Service (in progress)
```

---

## **Setup Instructions**
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/ecommerce-app.git
   cd ecommerce-app
   ```

2. **Start database containers** (Postgres and MongoDB):
   ```bash
   docker-compose up -d
   ```

3. **Run the microservices**:
   Each microservice is a separate module; navigate to the respective folder and start using Maven or an IDE.

4. **Kafka Setup**:
   Ensure Kafka is running for inter-service communication.

---

## **Planned Enhancements**
- **Notification Service**: Adding notification functionality.
- **Zipkin**: For distributed tracing of requests.
- **API Gateway**: To route and manage API requests.

------------------------------------
