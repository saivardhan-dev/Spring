# Spring Framework #
- Spring is a modular framework built around IoC and DI that provides enterprise infrastructure like web, data access, security, AOP, and testing. The Core Container manages beans and their lifecycle, enabling loose coupling, better testability, and cleaner architecture.
- Spring was designed to solve common problems in enterprise Java:
	1.	Reduce boilerplate code
	2.	Promote loose coupling
	3.	Improve testability
	4.	Centralize configuration
	5.	Support modern application architectures
- Inversion of Control (IoC): Objects do not create their dependencies — the container provides them.
- Dependency Injection (DI): Dependencies are injected at runtime instead of being hard-coded. (Types: Constructor Injection, Setter Injection, Field Injection)

```text
Spring FrameWork Architecture
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
## Core Container and Bean lifecycle 
- The Core Container manages everything about your objects so you don’t have to use new.
- Provides IoC (Inversion of Control) and Dependency Injection
- Handles object creation and wiring
- Defines how beans are configured and managed
- Handles bean definitions and scopes

*Bean Lifecycle:* The bean lifecycle describes the steps a bean goes through from creation to destruction.

Bean Lifecycle steps: 

1.Bean Instantiation: Spring creates the bean object.
```text
@Component
class MyBean {}
```
2.Dependency Injection: Spring injects required dependencies.
```text
@Autowired
private UserService userService;
```
3.Aware Interfaces (Optional): Spring injects container-related information if implemented.
```text
Examples:
	•	BeanNameAware
	•	ApplicationContextAware
```
4.BeanPostProcessor (Before Init): Allows modification before initialization.

5.Initialization: Bean is initialized.
Ways to define:
```text
@PostConstruct
public void init() {}
or
@Bean(initMethod = "init")
```
6.BeanPostProcessor (After Init): Final chance to modify the bean.

7.Bean Ready for Use: Bean is fully initialized and ready.

8.Destruction: Executed when application shuts down.
Ways to define:
```text
@PreDestroy
public void destroy() {}
or
@Bean(destroyMethod = "cleanup")
```
Lifecycle Flow Diagram
```text
Bean Created 
   ↓
Dependencies Injected
   ↓
@PostConstruct
   ↓
Bean Ready to Use
   ↓
@PreDestroy
   ↓
Bean Destroyed
```

*Bean Scope:*
- By default, Spring beans are singleton-scoped.
  
  Common Bean Scopes:
```text
   Scope 					 	Meaning 
singleton (default)			One instance per Spring container
prototype					New instance every time
request						One per HTTP request
session						One per HTTP session
application					One per ServletContext
```

  
  Common Spring Annotations:
```text
   Annotation 					 	Purpose 
@Component						Generic bean
@Service						Business logic
@Repository						DAO layer
@Controller						MVC Controller
@RestController					REST API
@Autowired						DI
@Bean							Bean creation
@Configuration					Config class
@Value							Inject values
@Qualifier						Resolve ambiguity
```


# SPRINGBOOT #
Spring Boot = Spring + Auto-configuration + Embedded Server + Convention over Configuration

In Spring boot, we write business logic. Spring handles: Object creation, Dependency wiring, Server setup, Request routing

## 1. Create Your First Spring Boot Project 

* Using Spring Initializr (Recommended)
  
	Go to: https://start.spring.io

```text
	Fill the details:
		•	Project: Maven
		•	Language: Java
		•	Spring Boot: Default (latest stable)
		•	Group: com.example
		•	Artifact: demo
		•	Packaging: Jar
		•	Java: 17 (or your installed version)
	Dependencies:
	Select:
		• Spring Web
	Click Generate → unzip → open in IntelliJ (We can Do all this in the IntelliJ itself as well)
```

## 2. Understand the Project Structure

we'll see:
```text
src/main/java
 └── com.example.demo
      └── DemoApplication.java

src/main/resources
 ├── application.properties
```
Main
```text
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

# Annotations:
- Spring Boot annotations are used to define components, configure dependency injection, expose REST APIs, validate input, handle exceptions, manage persistence, and automate application configuration with minimal boilerplate.
## 1. Core / Stereotype Annotations (Bean Creation)
- Used to tell Spring what classes to manage as beans

| Annotation | Description |
| --- | --- |
| @Component | When Spring scans the application, it detects classes annotated with @Component and registers them as beans in the Spring IoC (Inversion of Control) container. |
| @Service | Used for service-layer classes that contain business logic. |
| @Repository | Used for data access objects (DAOs) or classes that interact with databases. |
| @Controller | Used for web controllers that handle user requests and return responses. |
| @RestController | is a specialized version of @Controller that automatically serializes return objects into JSON/XML responses. It is equivalent to @Controller + @ResponseBody. |
| @Configuration | It indicates that a class contains @Bean definition methods, which the Spring container can process to generate Spring Beans for use in the application.|
| @Bean| is a method-level annotation used to explicitly declare that the object returned by that method should be registered and managed as a bean within the Spring Inversion of Control (IoC) container|

## 2. Spring Boot Application Annotations

| Annotation | Description |
| --- | --- |
| @SpringBootApplication | is a convenience meta-annotation used in Spring Boot to mark the main class of an application | 
| @EnableAutoConfiguration | a core feature that tells Spring Boot to automatically configure your application based on the JAR dependencies you have added to your classpath | 
| @ComponentScan | is used to automatically discover and register Spring-managed components in the application context | 

## 3. Dependency Injection Annotations

| Annotation | Description |
| --- | --- |
| @Autowired | is used for automatic dependency injection (DI), allowing the Spring container to manage and inject collaborating beans into a class without manual configuration |
| @Qualifier | is used to resolve ambiguity when multiple beans of the same type are available for dependency injection. |
| @Primary | is used to indicate the primary bean when multiple beans of the same type are present for auto wiring. |
| @Value | is one of the most important annotations. It is used to assign default values to variables and method arguments. |
| @Lazy | is used to enable lazy initialization of beans. By default, Spring initializes all singleton beans eagerly at application startup. |

## 4. Web / REST Controller Annotations
- Mapping Annotations

| Annotation | Description |
| --- | --- |
| @RequestMapping | is used to map web requests to specific handler classes and methods. |
| @GetMapping | is a specialized, shortcut annotation used to map HTTP GET requests to specific handler methods within a controller. |
| @PostMapping | is a specialized annotation used to map HTTP POST requests to specific handler methods within a controller |
| @PutMapping | is used to map HTTP PUT requests to specific handler methods within a controller. |
| @DeleteMapping | is used to map HTTP DELETE requests to specific handler methods within a controller |
| @PatchMapping | is used to map HTTP PATCH requests to specific handler methods in a controller |

- Request Data Annotations
  
| Annotation | Description |
| --- | --- |
| @RequestParam | is used to extract data from the query parameters of a URL or from form data in an HTTP request and bind it to a method parameter in a controller.  |
| @PathVariable | is used to extract dynamic values directly from the Uniform Resource Identifier (URI) path of an incoming HTTP request and bind them to method parameters in a controller.|
| @RequestBody |  is used to bind the body of an HTTP request to a method parameter in a controller. |
| @RequestHeader | to bind a request header to a method argument in a controller. |
| @CookieValue |  is used to bind the value of an HTTP cookie to a handler method parameter. |
| @ModelAttribute | is a versatile tool used to bind method parameters or return values to a named model attribute, making that data available to the web view (like a Thymeleaf or JSP template) |

- Response Annotations

| Annotation | Description |
| --- | --- |
| @ResponseBody | is used to bind the return value of a controller method directly to the HTTP response body. |
| @ResponseStatus | is used to mark a method or an exception class with a specific HTTP status code and an optional reason message to be returned in the HTTP response. |

## 5. Validation Annotations
Used with @Validated
| Annotations | 
| --- | 
| @NotNull, @NotBlank, @NotEmpty, @Min, @Max, @Size, @Email, @Pattern, @Positive, @Validated | 

## 6. Exception Handling Annotations

| Annotation | Description |
| --- | --- |
| @ExceptionHandler | is used to annotate methods that handle specific exceptions thrown by request-handling methods. |
| @ControllerAdvice | allows you to handle exceptions, data binding, and model attributes globally across all controllers in your application, centralizing cross-cutting concerns |
| @RestControllerAdvice | is a specialized Spring component used for global and centralized exception handling across all @RestController classes in an application |


## 7. Data / Persistence Annotations (JPA)

| Annotations | 
| --- | 
| @Entity, @Table, @Id, @GeneratedValue, @Column, @OneToMany, @ManyToOne, @JoinColumn, @Transactional | 

## 8. Configuration & Properties

| Annotations | 
| --- | 
| @ConfigurationProperties, @EnableConfigurationProperties, @PropertySource, @Profile |

## 9. Security (Spring Security)

| Annotations | 
| --- | 
| @EnableWebSecurity, @PreAuthorize, @PostAuthorize, @Secured |

## 10. Scheduling & Async

| Annotations | 
| --- | 
| @EnableScheduling, @Scheduled, @EnableAsync, @Async |

## 11. Testing Annotations

| Annotations | 
| --- | 
| @SpringBootTest, @WebMvcTest, @MockBean, @DataJpaTest, @TestConfiguration |

## 12. Actuator Annotations

| Annotations | 
| --- | 
| @Endpoint, @ReadOperation, @WriteOperation |

