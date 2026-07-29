# Mini Camel Framework

> A lightweight educational implementation of the core architecture of Apache Camel built completely from scratch using Java.

---

## Overview

Mini Camel Framework is an educational project that demonstrates how an Enterprise Integration Framework works internally.

Instead of using Apache Camel as a black box, this project rebuilds its fundamental concepts from scratch to understand the architectural decisions behind Enterprise Integration Patterns (EIP).

The goal is not to replace Apache Camel but to learn how integration frameworks are designed.

---

## Motivation

Modern integration frameworks hide a tremendous amount of complexity.

As developers we often use APIs like:

```java
from("http:orders")
    .process(...)
    .to("kafka:orders-topic");
```

without understanding what happens internally.

This project rebuilds those concepts step by step.

---

## Features

- HTTP Endpoint
- Kafka Endpoint
- Producer
- Consumer
- Exchange
- Message
- Pipeline
- Processor
- Route
- RouteBuilder DSL
- Component
- Component Registry
- CamelContext
- Gateway Engine
- Custom Integration Pipeline

---

## Architecture

```text
                    CamelContext
                          │
        ┌─────────────────┴─────────────────┐
        │                                   │
 Component Registry                  Route Registry
        │                                   │
        ▼                                   ▼
 HttpComponent                      GatewayRoute
 KafkaComponent                            │
        │                                  ▼
        ▼                             Pipeline
 HttpEndpoint                             │
 KafkaEndpoint                            ▼
        │                       Authentication
        ▼                       Authorization
 Consumer                      Validation
        │                       Audit
        ▼                       OrderProcessor
 Gateway Engine                       │
        └─────────────────────────────┘
                      │
                      ▼
               Kafka Producer
```

---

## Request Flow

```text
HTTP POST /orders
        │
        ▼
Spring Controller
        │
        ▼
GatewayEngine
        │
        ▼
Route Lookup
        │
        ▼
Create Exchange
        │
        ▼
Pipeline
        │
Authentication
        │
Authorization
        │
Validation
        │
Audit
        │
Order Processor
        │
Kafka Endpoint
        │
Kafka Producer
        │
orders-topic
```

---

## Folder Structure

```text
mini-camel-framework
│
├── docs
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│
├── pom.xml
├── README.md
├── LICENSE
└── .gitignore
```

---

## Example Route

```java
return new RouteBuilder(context.getEndpointFactory())

        .from("http:/orders")

        .process(new AuthenticationProcessor())

        .process(new AuthorizationProcessor())

        .process(new ValidationProcessor())

        .process(new AuditProcessor())

        .process(new OrderProcessor())

        .to("kafka:orders-topic");
```

---

## Example Request

```bash
curl -X POST http://localhost:8080/orders \
-H "Content-Type: application/json" \
-H "Authorization: Bearer abc123xyz" \
-H "Role: ADMIN" \
-d '{
    "customerId":"CUST-100",
    "productId":"MACBOOK-PRO",
    "quantity":1
}'
```

---

## Console Output

```text
HTTP Consumer Started

Authentication Success

Authorization Success

Validation Processor

Audit Processor

Order Processor

Publishing to topic : orders-topic
```

---

## Design Patterns Used

- Builder Pattern
- Factory Pattern
- Abstract Factory
- Registry Pattern
- Strategy Pattern
- Chain of Responsibility
- Dependency Injection
- Template Method
- Fluent DSL

---

## Future Enhancements

- Direct Endpoint
- Timer Endpoint
- File Endpoint
- Splitter
- Multicast
- Choice / When / Otherwise
- Dead Letter Channel
- Retry Policy
- Exception Handling
- Route Policy
- Dynamic Routing
- Metrics

---

## Learning Objectives

This project is intended to help understand:

- Enterprise Integration Patterns
- Integration Framework Design
- Message Routing
- Apache Camel Architecture
- Framework Development
- Java Design Patterns

---

## License

MIT License

---

## Acknowledgement

This project was created as a learning exercise to understand the internal architecture of Apache Camel.

It is inspired by Apache Camel but is an independent educational implementation developed from scratch.