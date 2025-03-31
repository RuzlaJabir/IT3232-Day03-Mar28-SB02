# Spring Boot Student Management API

This is a Spring Boot project developed using Spring Boot Tool Suite 4. It includes a controller and a model to manage student data.


## API Endpoints

### General Endpoints
| Method | Endpoint            | Description                               |
|--------|---------------------|-------------------------------------------|
| GET    | `/app/age/{ag}`      | Returns age as a string response          |
| GET    | `/app/details/{ag},{nm}` | Returns name and age as a string response |

### Student Endpoints
| Method | Endpoint                                   | Description                                      |
|--------|--------------------------------------------|--------------------------------------------------|
| GET    | `/app/student`                             | Returns a single student object                  |
| GET    | `/app/students`                            | Returns a list of all students                   |
| GET    | `/app/students/{reg}`                      | Finds a student by registration number          |
| GET    | `/app/ages`                                | Returns students aged between 20-23             |
| GET    | `/app/sortbyGPA`                           | Returns students sorted by GPA                   |
| GET    | `/app/addStudent/{reg},{nm},{ag},{crs},{gpa}` | Adds a new student                              |
| GET    | `/app/updateStudent/{reg},{nm},{ag},{crs},{gpa}` | Updates an existing student                    |
| GET    | `/app/deleteStudent/{reg}`                 | Deletes a student by registration number       |



