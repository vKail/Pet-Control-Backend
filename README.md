# 🐾 Pet Control - Backend

Backend of the veterinary system developed with Java and Spring Boot. REST API with clean architecture for complete veterinary clinic management.

## 📋 Description

Robust API that provides services for veterinary clinic management. Includes JWT authentication, full CRUD of entities, an appointment system, and a billing module.

**Features:**

-   Authentication and authorization with JWT
    
-   CRUD for pets, owners, and veterinarians
    
-   Medical history management
    
-   Appointment and reminder system
    
-   Billing module
    
-   Documentation with Swagger
    

## 🛠️ Technologies

-   Java 17
    
-   Spring Boot 3.x
    
-   Spring Security + JWT
    
-   PostgreSQL
    
-   JPA/Hibernate
    
-   Maven
    

## 🚀 Installation

```
# Clone the repository
git clone [https://github.com/vKail/Pet-Control-Backend.git](https://github.com/vKail/Pet-Control-Backend.git)
cd Pet-Control-Backend

# Configure environment variables
cp src/main/resources/application.properties.example application.properties

# Compile and run
./mvnw spring-boot:run

```

## 📂 Project Structure

Clean architecture by layers:

```
src/main/java/com/petcontrol/
├── application/
├── domain/
├── infrastructure/
└── presentation/

```

## 👥 Contributors

-   **Adrian Jurado** - [@vKail](https://github.com/vKail "null")
