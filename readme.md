# Implementation step
 
## Tech

- Java
- Spring-boot
- Spring web
- Spring 0security
- Spring data JPA
- etc (you can find the details in pom.xml :)


## Installation

Dillinger requires JDK 8 or higher to run.
- clone this repository to your local
- create database (mysql as default) and name it
- set database connection in application properties (db name, host, username, and password)
- use maven to package the app

Run the application to your machine and the hibernate will create the table for you, GREAT! ;)

# Feature

1. sign up
```
POST /api/auth/signup HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 117

{
  "username": "admin",
  "email": "admin@gmail.com",
  "role": [
    "admin"
  ],
  "password": "admin123"
}
```
2. sign in
```
POST /api/auth/signin HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 54

{
  "username": "admin",
  "password": "admin123"
}
```
3. get all job
```
GET /api/resource/jobAll HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2ODgzOTg1NCwiZXhwIjoxNjY4OTI2MjU0fQ.FFtGaADjKxbNw9qnsbsk6Cn-2z-cKUrEazqEXbA9lECIIr4K5ArwH7XlFLUTsWh3hDz6ov3rjBi3A6jKHGE4pQ
```
4. get job by id
```
GET /api/resource/job/32bf67e5-4971-47ce-985c-44b6b3860cdb HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY2ODgzOTg1NCwiZXhwIjoxNjY4OTI2MjU0fQ.FFtGaADjKxbNw9qnsbsk6Cn-2z-cKUrEazqEXbA9lECIIr4K5ArwH7XlFLUTsWh3hDz6ov3rjBi3A6jKHGE4pQ
```




