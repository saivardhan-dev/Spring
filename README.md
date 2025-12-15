# Spring Framework #
- Spring Framework is a modular Java framework built around IoC and DI, providing infrastructure support for enterprise applications including web, data access, security, messaging, and testing.
- Spring was designed to solve common problems in enterprise Java:
	1.	Reduce boilerplate code
	2.	Promote loose coupling
	3.	Improve testability
	4.	Centralize configuration
	5.	Support modern application architectures
- Inversion of Control (IoC): Objects do not create their dependencies — the container provides them.
- Dependency Injection (DI): Dependencies are injected at runtime instead of being hard-coded. (Types: Constructor Injection, Setter Injection, Field Injection)

```text

├── Core Container: The Spring container is responsible for instantiating, configuring, and bean management.
│   ├── Beans: A Spring Bean is an object that is created, managed, and destroyed by the Spring container.(Created using @Component, @Service, @Repository, @Controller, @Bean)
│   ├── Core: The core Container provides IoC Container, Bean management, Dependency Injection.
│   ├── Context: The Context module extends the Core module and provides enterprise-level features.(It provides: ApplicationContext interface, Event handling, Resource loading, Bean scopes)
│   └── Expression Language (SpEL)
│
├── AOP: Separates cross-cutting concerns from business logic.(Used for: Logging, security, transactions, Auditing)
├── Data Access / Integration: Provides consistent data access across different technologies. (Supports JDBC, JPA, ORM frameworks)
├── Web (Spring MVC): Framework for building web applications and REST APIs. (Key features: Controllers, Request mapping, Validation, Exception handling)
├── Messaging: Enables asynchronous communication between applications.(Supports Kafka, RabbitMQ, Event-driven architectures), Used in microservices and distributed systems.
└── Test: Provides comprehensive testing support. (includes unit testing, Integration testing, Mocking support, Test context framework)

```
