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

## Testing

You can test the RESTful API using tools like Postman or CURL. Sample endpoints include:

- **Create Account**: `POST /api/accounts`
- **Get Account by ID**: `GET /api/accounts/{id}`
- **Update Account**: `PUT /api/accounts/{id}`
- **Delete Account**: `DELETE /api/accounts/{id}`

## GraphQL API

The project also exposes a GraphQL API for querying accounts.

- Navigate to: [http://localhost:8080/graphql](http://localhost:8080/graphql)

Example query:
{ 
    account(id: 1) { 
        id
        balance
        owner 
    } 
}