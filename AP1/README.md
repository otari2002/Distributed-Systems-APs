# Spring Boot Bank Account Management

This project is a simple Spring Boot-based microservice for managing bank accounts. It includes RESTful APIs, Spring Data JPA integration with H2 database, and GraphQL support.

## Features

- Create, update, delete, and retrieve bank account information.
- RESTful API endpoints for account management.
- Swagger documentation for API exploration.
- Spring Data Rest with projections for flexible data querying.
- GraphQL API to interact with the account service.
- Data Transfer Objects (DTOs) and mappers for data transformation.
- In-memory H2 database for persistence during development.
- Service layer for business logic separation.

## Technologies

- **Spring Boot**
- **Spring Data JPA** with H2 Database
- **Spring Web**
- **Lombok** for reducing boilerplate code
- **Swagger** for API documentation
- **GraphQL** for GraphQL API
- **Spring Data Rest**


## API Documentation

Swagger UI is available to explore the API.

- Navigate to: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Swagger

Swagger allows you to visualize and interact with the API endpoints without needing any implementation logic in place. It is automatically generated based on the API specifications defined in the Spring Boot application.

1. After starting the application, access the Swagger UI at: `http://localhost:8080/swagger-ui.html`
2. Here, you can see all the available endpoints, their parameters, and response formats.
3. You can test the API directly from this interface by filling out the required parameters and clicking "Try it out!".

## Testing

You can test the RESTful API using tools like Postman or CURL. Sample endpoints include:
- **Get All Accounts** ! `GET /api/accounts` <br/>


- **Create Account**: `POST /api/accounts`
- **Get Account by ID**: `GET /api/accounts/{id}`
- **Update Account**: `PUT /api/accounts/{id}`
- **Delete Account**: `DELETE /api/accounts/{id}`

## GraphQL API

The project also exposes a GraphQL API for querying accounts.

- Navigate to: [http://localhost:8080/graphql](http://localhost:8080/graphql)


Example query:<br/>

<img width="659" alt="image" src="https://github.com/user-attachments/assets/7fa9418c-1a26-4d39-9d06-908e20070724">