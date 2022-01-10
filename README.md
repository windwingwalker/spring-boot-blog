# Spring Boot Blog Demo

## Background
This application is a part of a series, which is aiming at writting a basic web application in different programming languages and frameworks. The idea blueprint is basically a blog, which is able to perform basic web application operations, such as handling HTTP request, fetch data, etc. You can treat the application as a web-based hello world, with more common but advanced functions. 

## Tech Stack
### Basic
- Language: Java 11
- Framework: Spring Boot 2.5.6
- Dependency Management: Maven

### Advanced: Development tools
- VSCode
- Docker

## Application Functions
The functions are the same across the series: 
- Host a web server
- Apply MVC structure
- Expose RESTful APIs
  - GET
  - POST
  - PUT
  - DELETE
- Handle HTTP requests
  - Distribute request to different services based on RESTful API
  - Fetch request body
  - Fetch path variables
- Operate Database (MongoDB)
  - Read documents by id
  - Read documents by other field
  - Create documents
  - Update documents by id
  - Delete document by id
- Handle HTTP responses
  - Custom response body in JSON format
  - Custom response status
    - 404
    - 200
    - 201
    - 500
- Handle Exception 
  - Resource not found (404)
  - Unknown error (500)

## File Structure
- .devcontainer/: VSCode development tool utilizing container technology
- src/: Source code of the program
- docker-compose.yml
- Dockerfile
- pom.xml
- README.md