# Employee Data Management System

The Employee Data Management System is a web application designed to manage employee information, including registration, profile management, and search functionality. The system is built using Spring Boot for the backend, JSP for the frontend, and SQL for data storage, providing a secure and efficient environment for handling employee data.

## Features

1. **Employee Registration**:
   - Allows new employees to register their details into the system.
   - Validates input data to ensure accuracy and integrity.

2. **Profile Management**:
   - Employees can view and update their profile information.
   - Ensures that updates are securely saved in the database.

3. **Employee Search**:
   - Provides a search functionality to find employees based on various criteria.
   - Supports searching by name, department, and other relevant fields.

## Technology Stack

- **Backend**: Spring Boot
- **Frontend**: JSP (JavaServer Pages)
- **Database**: SQL (MySQL or any other RDBMS)
- **Build Tool**: Maven

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL Server (or another SQL database)
- IDE (Eclipse, IntelliJ, etc.)

## Setup and Installation

### Steps

1. Import the Employee-Management-System folder in the Java editor(eclipse).
2. Change the application.properties file according to your database
3. Run the Program.
4. Open your browser and go to "http://localhost:8080".

## Application Structure

- Backend Development
  - Developed using Spring Boot to ensure robust and secure backend functionality.
  - Controllers handle HTTP requests for employee registration, profile management, and search operations.
  - Services encapsulate business logic and interact with the data layer to handle CRUD operations.

- Frontend Development
  - JSP (JavaServer Pages) is used to build a user-friendly and responsive interface.
  - Designed forms and views for employee registration, profile display, and search results.
  - CSS is used to enhance the look and feel of the application, providing a clean and intuitive user experience.

- Database
  - The application uses SQL for persistent data storage.
  - Entities are mapped using JPA annotations, allowing seamless interaction between the application and the database.
 
## Future Enhancements

- Implement role-based access control to restrict functionalities based on user roles (e.g., Admin, Employee).
- Add data export options (e.g., CSV, Excel) for reports.
- Integrate email notifications for employee actions like registration and profile updates.

## Contact
- Author: Pradyumna Nalawade
- GitHub: Pradyumna404
- Email: pnalawade404@gmail.com
