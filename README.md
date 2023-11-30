# Spring Commerce
_Spring Commerce is a simple e-commerce application built with Spring Boot and pure HTML/CSS/JS. It is a monolithic application that uses SpringBoot, Spring Data JPA, Spring Security, Thymeleaf, and Bootstrap. It is a simple e-commerce application that allows users to browse products, add them to the cart, and checkout. It also has a simple admin interface that allows the admin to add, update, and delete products. The application is uses MySQL as the database._

## I. Technologies
* Java 17
* Spring Boot 3.x
* Spring Security

### 1. Development Principles & Patterns
* Dependency Injection (DI): DI is a technique in which an object receives other objects that it depends on. These other objects are called dependencies. DI is a core concept of Spring. It is used to achieve loose coupling between objects. Loose coupling is a design goal that seeks to reduce the interdependence of modules. Loose coupling can make your code easier to understand and maintain.
* Model-View-Controller (MVC): MVC is a software design pattern that separates the business logic (Model) from the presentation layer (View) and the application logic (Controller). This separation of concerns allows us to build applications that are easier to maintain and extend.
* Object-Relational Mapping (ORM): ORM is a programming technique that maps data from an object-oriented domain model to a relational database. It is a core concept of Spring Data JPA. It allows us to interact with a relational database using an object-oriented domain model. It also allows us to avoid writing SQL queries by hand.

### 2. Structure
* **java/com/example/SpringCommerce**: This package contains the main class of the application.
* **Entity**: The model layer contains the domain model classes. These classes are used to represent the data that is being transferred between the different layers of the application. They are also used to represent the data that is being stored in the database.
* **Repository**: The repository layer contains the repository interfaces. These interfaces are used to interact with the database. They are implemented by Spring Data JPA at runtime.
* **Service**: The service layer contains the service interfaces. These interfaces are used to implement the business logic of the application. They are implemented by the service implementation classes.
* **Controller**: The controller layer contains the controller classes. These classes are used to implement the application logic of the application. They are responsible for handling HTTP requests and returning HTTP responses.
* **DTO(Data Transfer Object)**: The DTO layer contains the DTO classes. These classes are used to transfer data between the different layers of the application. They are also used to transfer data between the application and the client.
* **Config**: The config layer contains the configuration classes. These classes are used to configure the application. They are also used to configure the Spring Security framework.
* **Exception**: The exception layer contains the exception classes. These classes are used to handle exceptions that occur during the execution of the application.
* **Constant**: The constants layer contains the constant classes. These classes are used to store constants used other classes.
* **Util**: The util layer contains the utility classes. These classes are used to implement utility methods used by other classes.
* **Resource/templates**: The templates layer contains the template files. These files are used to store the HTML templates used by the Thymeleaf template engine.
* **Resource/static**: The static layer contains the static files. These files are used to store static resources such as images, CSS files, and JavaScript files.
* **Resource/application.properties**: The application.properties file is used to configure the application. It is used to configure the database connection, the Thymeleaf template engine, and the Spring Security framework. By default, the url of the database is remote MySQL database in a internet hosting service. If you want to use local MySQL database, you can change the url to `jdbc:mysql://localhost:3306/spring_commerce?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true` and change the username and password to your local MySQL username and password.
* **Upload**: The upload layer contains the uploaded files. These files are used to store the uploaded images.
* **pom.xml**: The pom.xml file is used to manage the dependencies of the application. It is used to manage the dependencies of the Spring Boot framework, the Spring Security framework, the Thymeleaf template engine, and the MySQL database.

### 3. Installation
Pre-requisites:
* Java 17
* MySQL >= 8.x.x.
* **Step 1**: Extract the zip file.
* **Step 2**: Open the project in your IDE. Recommended IDE: IntelliJ IDEA.
* **Step 3**: Open the application.properties file and change the url, username, and password of the database if you want to use local MySQL database.
* **Step 4**: Wait for the dependencies to be downloaded.
* **Step 5**: Run the application.
* **Step 6**: Open your browser and go to http://localhost:8080 by default. If you want to change the port, you can change it in the application.properties file.
* **Step 7**: You can login as admin by using the following credentials:
    * **Username**: admin
    * **Password**: 123456

## II. Features
1. **Auth Features**:
  * **Authenticate**: Users can authenticate using their username and password.
    * **Admin**: admin/123456 (username/password)
    * **User**: oanh/123456 (username/password)

    |url|method| credentials                           |
    |---|---|---------------------------------------|
    |/api/auth/authenticate|POST| username, password, role[ADMIN, USER] |
  
  * **Register**: Users can register using their username, password, and email.

    |url|method| credentials                           |
    |---|---|---------------------------------------|
    |/api/auth/signup|POST| username, password, role[ADMIN, USER] |
  ...

**Note**: All api endpoints are presented through User Interface (UI) in the application.

