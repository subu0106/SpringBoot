# Spring Boot Demo Project

A RESTful API application built with Spring Boot, JPA, and MySQL for user management operations.

## Prerequisites

### Java Development Kit (JDK)

- Download Java Developer version from [java.oracle.com](https://www.oracle.com/java/technologies/downloads/)
- Install JDK 17 or higher

### Eclipse IDE

- Download Eclipse IDE from [eclipse.org](https://www.eclipse.org/downloads/)
- Choose "Eclipse IDE for Enterprise Java and Web Developers" version
- Eclipse is needed as an Integrated Development Environment (IDE) for Spring Boot development
- It provides code editing, debugging, project management, and Spring Boot tools

## Project Setup

### 1. Initializing Spring Boot Project

- Go to [start.spring.io](https://start.spring.io)
- Select:
  - Project: Maven
  - Language: Java
  - Spring Boot: default version
- Generate and download the project
- Extract the zip file and locate the `pom.xml` file

### 2. Import Project into Eclipse

- Open Eclipse IDE
- Go to `File` → `Import` → `Maven` → `Existing Maven Projects`
- Select the extracted project folder containing `pom.xml`
- Click `Finish`

## Dependencies

This project uses the following key dependencies in `pom.xml`:

### Spring Boot Starter Data JPA

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>3.5.3</version>
</dependency>
```

### MySQL Connector/J

```xml
<!-- MySQL Connector for database connectivity -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

### SpringDoc OpenAPI (Swagger Documentation)

```xml
<!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.9</version>
</dependency>
```

## Database Configuration

### MySQL Setup

Add the following configuration to `src/main/resources/application.properties`:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
```

**Note:** Update `your_database_name` and `your_password` with your actual MySQL database name and password.

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/subu/spring_boot_demo/
│   │       ├── SpringBootDemoApplication.java     # Main application class
│   │       ├── controllers/
│   │       │   └── UserController.java            # REST API endpoints
│   │       ├── entity/
│   │       │   └── UserEntity.java                # JPA Entity
│   │       ├── exceptions/
│   │       │   └── ResourceNotFoundException.java # Custom exception
│   │       ├── model/
│   │       │   └── User.java                      # Data model
│   │       └── repository/
│   │           └── UserRepository.java            # Data access layer
│   └── resources/
│       └── application.properties                 # Configuration file
└── test/
    └── java/
        └── com/subu/spring_boot_demo/
            └── SpringBootDemoApplicationTests.java # Unit tests
```

## Development Process

### 1. Entity Creation

- Created `UserEntity.java` with JPA annotations
- Defines the database table structure

### 2. Repository Creation

- Created `UserRepository.java` extending `JpaRepository`
- Provides CRUD operations for the User entity

### 3. API Development

- Created `UserController.java` with REST endpoints
- Implements CRUD operations for user management

## Running the Application

### Local Development

1. Ensure MySQL is running locally
2. Update database credentials in `application.properties`
3. Run the application using Eclipse or command line:

   ```bash
   ./mvnw spring-boot:run
   ```

### Web Server

- The application runs on embedded Tomcat web server
- Default port: `http://localhost:8080`

## API Documentation

### Swagger UI

- Access interactive API documentation at: `http://localhost:8080/swagger-ui/index.html`
- Provides a user-friendly interface to test all API endpoints
- Automatically generated from code annotations

### Available Endpoints

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create new user
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

## Additional Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Spring Data JPA Guide](https://spring.io/guides/gs/accessing-data-mysql/)
- [Maven Repository](https://mvnrepository.com/) - For finding dependencies
- [SpringDoc OpenAPI Documentation](https://springdoc.org/)

## Development Tools

- **IDE**: Eclipse IDE for Enterprise Java and Web Developers
- **Build Tool**: Maven
- **Database**: MySQL
- **Web Server**: Embedded Tomcat
- **API Documentation**: Swagger/OpenAPI 3

## Getting Help

If you encounter issues:

1. Check the console logs for error messages
2. Verify database connection settings
3. Ensure all dependencies are properly downloaded
4. Check that MySQL service is running

## License

This project is for educational purposes.
