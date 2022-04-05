# Customer-relationship-management-API
The objective is to create a HTTP API to manage customer data for a small shop.

First I need a Spring Boot project, dependencies.
- Spring web for a web-application.
- H2 for in-memory database
- Lombok for reducing boilerplate code

- Web-application structure created: controller, dao, dto, service packages
- db connection properties in application.properties
- import.sql will be executed automatically on every startup for db test
- OpenAPI dependency added, one can download documentation of CostumerAPI in YAML format from http://localhost:8080/v3/api-docs.yaml
- One can test endpoints by visiting http://localhost:8080/swagger-ui.html
- Mapstruct dependency added for mapping data between dao and dto
- For using Mapstruct with Lombok you need to make some modification: https://springframework.guru/using-mapstruct-with-project-lombok/
- Mapstruct works with Lombok, mapper tests passed

OOP principles:

- Inheritance: CustomerRepository inherits (extends) JpaRepository, that's why we can use its methods (e.g.: findById()) Subclass extends its Superclass
In Java multiple inheritance is not allowed (a class can extend only one class)

- Encapsulation: Customer class secures all of its attributes (private fields) so no one can change them directly. To allow modification of a field 
we use setters. In a setter we can create our own business logic how we allow or ban (control) modification of a particular field.
With a getter we can access the value of a particular field. We can create our own business logic how we allow or ban (control) to get the information of a field.

- Abstraction: We can hide (not exposing) complex business logic by creating private methods for them and allowing access for only simplified logic

- Polymorphism: CustumerServiceImpl class implements the CustomerServiceInterface, implements, and overrides all of its method. 
  We can allow executing the same method with different outcome. CustomerMapper interface contains overloaded method stubs. 
  They have same signatures but different parameters.
  - Method overriding: We can override the inherited methods of a superclass by using the same signature of the method,
  and we can implement a different business logic in it. To show that it is an overrode method we can use the @Override annotation.
  - Method overloading: We can create methods with the same name but different signature (order or number of different parameters)
  to create different business logic for them.

- All endpoints can only receive DTOs
- @Transactional annotations are applied in default JpaRepository / CrudRepository implementation
- A customer must have the following attributes: name, surname, email and birthdate (validation added)
