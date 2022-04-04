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