# MasterSys 🏋️‍♂️

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)

> **A comprehensive Gym Management System (Sistema de Gestão de Academias) built as an educational and personal portfolio project.**

---

## 🌍 Language Disclaimer: Why PT-BR in the code?

You might notice that this README is in English, but the actual source code (classes, variables, database tables) is primarily in **Portuguese (PT-BR)**. 

This was a deliberate design choice inspired by **Domain-Driven Design (DDD)** principles. The concept of *Ubiquitous Language* suggests that the code should reflect the exact terms used by the business domain. Since this project simulates a system for Brazilian gyms, using native terms like `Aluno` (Student/Member), `Matricula` (Enrollment), and `Fatura` (Invoice) eliminates translation friction and makes the domain model much more authentic and expressive.

---

## 🚀 About the Project

**MasterSys** is a robust backend REST API developed to manage the daily operations of a fitness center/gym. It handles member registration, class modalities, financial billing (invoices), and generates administrative reports.

### Key Features
* **Members Management (`Alunos`)**: CRUD operations with advanced dynamic filtering capabilities using Spring Data JPA Specifications.
* **Enrollments & Modalities**: Manage tracking of which class/modality a member is enrolled in, along with their current belt/graduation level (`Graduacao`).
* **Financial Management**: Tracking monthly invoices, check for pending payments (`Faturas em Aberto`).
* **Management Reports**: Custom database projections returning data such as Monthly Revenue, Number of Members per City, and Pending Invoices.
* **Resilient Architecture**: Centralized error handling (`GlobalExceptionHandler`) to output clean and standardized HTTP error responses.
* **Automated Migrations**: Database version control managed by Flyway.

## 🛠️ Technology Stack

* **Language:** Java (v17+)
* **Framework:** Spring Boot 3 (Web, Data JPA, Validation)
* **Database:** PostgreSQL
* **Migrations:** Flyway
* **API Documentation:** OpenAPI 3 / Swagger (`springdoc-openapi`)
* **Build Tool:** Maven

## ⚙️ Getting Started

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* Maven 3.8+
* PostgreSQL database running locally or via Docker

### Running Locally

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/mastersys.git
   cd mastersys
   ```

2. **Configure the Database**
   Copy the example environment file and set up your local PostgreSQL credentials:
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```
   *Edit `application.properties` to match your PostgreSQL username, password, and database URL.*

3. **Run Migrations & Start the Server**
   Since the project uses Flyway, database tables and initial dummy data are created automatically on startup.
   ```bash
   ./mvnw spring-boot:run
   ```

## 📖 API Documentation

Once the application is running, you can explore the endpoints, their expected payloads, and test them directly through the Swagger UI:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

The documentation provides rich schemas and predefined JSON examples for rapid testing.

## 📝 License

Developed for educational purposes. Feel free to fork, explore, and use it as a learning reference!
