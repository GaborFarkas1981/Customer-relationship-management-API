# GitHub
https://github.com/GaborFarkas1981/Customer-relationship-management-API

# Customer-relationship-management-API
The objective is to create a HTTP API to manage customer data for a small shop.

First I need a Spring Boot project, dependencies.
- Spring web for a web-application.
- H2 for in-memory database
- Lombok for reducing boilerplate code

- Web-application structure created: controller, dao, dto, service packages
- db connection properties in application.properties
- import.sql will be executed automatically on every startup for db test
- OpenAPI dependency added, you can download documentation of CostumerAPI in YAML format from http://localhost:8080/v3/api-docs.yaml
- You can test endpoints by visiting http://localhost:8080/swagger-ui.html
- Mapstruct dependency added for mapping data between dao and dto
- For using Mapstruct with Lombok you need to make some modification: https://springframework.guru/using-mapstruct-with-project-lombok/
- Mapstruct works with Lombok, mapper tests passed
- All endpoints can only receive DTOs
- @Transactional annotations are applied in default JpaRepository / CrudRepository implementation. Update all the attributes (<font color="red">at once</font>)
- A customer <font color="red">must have</font> the following attributes: name, surname, email and birthdate (validation added)

# OOP principles:

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

# Docker
- I've created a Dockerfile. Tagging of the image isn't supported inside the Dockerfile, so 
  you can build an image from the application if you run "docker build -t gfarkas/crm:v1.0.0  ."
- "-t tagname" to tagging our docker image
- "." means the Dockerfile is in the same folder where we execute docker build
# Create and run a container from an image
- You can run a container from the image by executing "docker run -p 127.0.0.1:80:8080 gfarkas/crm:v1.0.0"
- Where "-p" is the port binding (localhost:80 is where you can access the container's inner 8080 port)
- So the left side of the colon is where you can access the container and the right side is the port inside the container what you want to expose.
- With "-d" you can run the application in detached/headless mode.
- You can run a container by the id of the image as well. So docker image ls, find the id and "docker run -p 127.0.0.1:80:8080 c86"
- Where "c86" is the first three character of the id of image. It's enough to distinguish from other ids. 
# Create an image and run a container from it using docker-compose
- I've created a docker-compose.yml file. You can run the application by executing "docker-compose up"
- It will build an image from the Dockerfile and configure (expose port, create network etc.) and run a container from that image
  
# Endpoints of the application
- GET  &emsp;   path: /api/customer/{id}  &emsp;&emsp;  get one customer by its id
- GET  &emsp;   path: /api/customer/      &emsp;&emsp;  list all the customers in db
- POST &emsp;   path: /api/customer/      &emsp;&emsp;  create a customer from the payload (creates a new entry in the db with a new id)
- PUT  &emsp;   path: /api/customer/{id}  &emsp;&emsp;  find a customer by its id and update its fields from the payload (does not create new entry in the db)
- DELETE path: /api/customer/{id}         &emsp;&emsp;  find a customer by its id and delete it from the db
