PRACTICA 1-- GRUPO 11 - README
Overview
The Book Barter Concept is a web application that allows users to exchange books, share knowledge, and promote sustainable reading practices. The application includes both form-based and API-based CRUD operations for managing users and pickup points. Additionally, it features a Patch operation for partial updates, as well as integration with Postman for testing.
TAKE IN MIND:
IN ORDER TO ACCESS TO FORMULARIES FOR BOOK MODEL PRESS BUTTON CATALOG, AND THE REST OF MODELS ARE AT THE BOTTOM OF THE WEB.
Key Features:
CRUD Operations for Users and Pickup Points via forms and API.

Patch Operation for partial updates for both Users and Pickup Points.

A Postman Collection to test the CRUD and Patch operations.

Custom CSS and JavaScript to enhance the user interface.

A Spring Boot backend with RESTful endpoints for each entity.

Requirements
Java 11+ (for running the Spring Boot application)

Maven (for building the project)

Postman (for testing the API)

Project Structure
Controller: Manages incoming HTTP requests for users and pickup points (both via forms and API).

Service: Contains the business logic and handles CRUD and Patch operations for users and pickup points.

Model: Contains the User and PickupPoint entities.

HTML: User interface with forms to interact with the backend.

CSS: Styling for the web pages.

JavaScript: Used for redirection and dynamic content loading.

API Endpoints
1. User Operations (CRUD + Patch)
Create a User (POST)
Endpoint: /users/register

Method: POST

Request Body: JSON

json
Copiar
Editar
{
  "nombre": "John Doe",
  "email": "john.doe@example.com",
  "password": "password123"
}
Response: Status 201 (Created) with the created user details.

Get All Users (GET)
Endpoint: /users

Method: GET

Response: A list of all users.

Get User by ID (GET)
Endpoint: /users/{id}

Method: GET

Response: Details of a user with the specified ID.

Update User (PUT)
Endpoint: /users/{id}

Method: PUT

Request Body: JSON (full user object)

json
Copiar
Editar
{
  "id": 1,
  "nombre": "Jane Doe",
  "email": "jane.doe@example.com"
}
Response: Status 200 (OK) with the updated user details.

Partially Update User (PATCH)
Endpoint: /users/{id}

Method: PATCH

Request Body: JSON (only the fields to be updated)

json
Copiar
Editar
{
  "email": "jane.doe@newdomain.com"
}
Response: Status 200 (OK) with the updated user details.

Delete User (DELETE)
Endpoint: /users/{id}

Method: DELETE

Response: Status 204 (No Content) if the user is deleted.

2. Pickup Points Operations (CRUD + Patch)
Create Pickup Point (POST)
Endpoint: /puntos/add

Method: POST

Request Body: JSON

json
Copiar
Editar
{
  "direccion": "123 Main St",
  "ciudad": "Madrid",
  "userId": 1
}
Response: Status 201 (Created) with the created pickup point details.

Get All Pickup Points (GET)
Endpoint: /puntos

Method: GET

Response: A list of all pickup points.

Get Pickup Point by ID (GET)
Endpoint: /puntos/{id}

Method: GET

Response: Details of a pickup point with the specified ID.

Update Pickup Point (PUT)
Endpoint: /puntos/{id}

Method: PUT

Request Body: JSON (full pickup point object)

json
Copiar
Editar
{
  "id": 1,
  "direccion": "456 Oak St",
  "ciudad": "Barcelona"
}
Response: Status 200 (OK) with the updated pickup point details.

Partially Update Pickup Point (PATCH)
Endpoint: /puntos/{id}

Method: PATCH

Request Body: JSON (only the fields to be updated)

json
Copiar
Editar
{
  "direccion": "789 Pine St"
}
Response: Status 200 (OK) with the updated pickup point details.

Delete Pickup Point (DELETE)
Endpoint: /puntos/{id}

Method: DELETE

Response: Status 204 (No Content) if the pickup point is deleted.

Postman Collection
A collection of Postman requests is available to test the CRUD and Patch operations for both Users and Pickup Points. Import the collection into Postman and execute the operations to ensure the API works as expected.

Frontend (HTML + CSS + JavaScript)
User Interface
The application provides a user-friendly interface to interact with the CRUD operations for Users and Pickup Points. Key pages include:

Registration Form: For creating a new user.

Login Form: For logging in a user.

Pickup Points Management: For managing pickup points.

JavaScript
JavaScript is used to handle redirections between pages, such as redirecting users back to the homepage after successful registration or login.

CSS
Custom CSS is applied for styling the various pages, providing a responsive and user-friendly layout for desktop and mobile users.

Installation
Clone the repository:

bash
Copiar
Editar
git clone https://github.com/ARDCAB/PRACTICA.DISTRI.BUENO.git
cd PRACTICA.DISTRI.BUENO
Install dependencies:

Make sure you have Java 11 or later installed.

Use Maven to build the application:

bash
Copiar
Editar
mvn clean install
Run the application:

bash
Copiar
Editar
mvn spring-boot:run
The application will be available at http://localhost:8080.

Test API using Postman: Import the Postman collection and test all the CRUD and Patch endpoints.

Conclusion
This project demonstrates how to implement CRUD and Patch operations for managing entities in a web application using Spring Boot and REST API. Additionally, it includes a basic front-end to interact with the backend through forms and custom JavaScript. All necessary configurations for a smooth user experience and API testing have been implemented.
