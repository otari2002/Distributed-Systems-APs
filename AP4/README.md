# CQRS & Event Sourcing with Axon

## Project Overview

### Architecture Patterns
- **CQRS**: Separates read and write operations
- **Event Sourcing**: Stores state changes as events
- **Domain-Driven Design**: Implements bounded contexts and aggregates

# Implementation Steps

## 1. Core Modules
- Command Module
- Query Module
- Event Module
- Domain Module

## 2. Domain Models

### Account Aggregate
- Account ID
- Balance
- Status
- Operations History

## 3. Command Side

### Commands
- CreateAccountCommand
- CreditAccountCommand
- DebitAccountCommand
### Command Handlers
- AccountCommandHandler

## 4. Event Side

### Events
- AccountCreatedEvent
- AccountCreditedEvent
- AccountDebitedEvent

### Event Handlers
- AccountEventHandler

## 5. Query Side

### Queries
- GetAccountQuery
- GetAccountsQuery
- GetAccountHistoryQuery

### Query Handlers
- AccountQueryHandler
