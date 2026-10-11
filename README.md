# SOES - Secure Online Examination System

SOES (Secure Online Examination System) is a web-based application developed using Java and Spring Boot to manage online examinations. It provides role-based access for administrators, teachers, and students, making examination management simple and organized.

## 🚀 Features

- **User Authentication:** Secure login and registration.
- **Role-Based Access:** Separate access for Admin, Teacher, and Student roles.
- **Admin Dashboard:** Manage users, update roles, search users, and delete users.
- **Teacher Dashboard:** Create exams, add questions, manage exam questions, and publish exams.
- **Student Dashboard:** View available published exams and start examinations.
- **Online Examination:** Answer multiple-choice questions and submit exams.
- **Result Calculation:** Calculate marks obtained and display examination results.
- **Responsive UI:** Styled login, registration, and dashboard pages.

## 🛠️ Technologies Used

- **Backend:** Java, Spring Boot, Spring Security
- **Frontend:** JSP, HTML, CSS
- **Database:** PostgreSQL
- **ORM:** Hibernate, Spring Data JPA
- **Build Tool:** Maven
- **Development Environment:** Eclipse IDE

## 👥 User Roles

| Role | Responsibilities |
|---|---|
| Admin | Manage users and their roles |
| Teacher | Create exams, add questions, and publish exams |
| Student | View published exams, attempt exams, and view results |

## ⚙️ Prerequisites

Before running the project, install:

- JDK 21
- PostgreSQL
- Eclipse IDE or another Java IDE
- Maven (or use the included Maven Wrapper)

## ▶️ How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/OmkarMete/SOES.git
   ```

2. Open the project in Eclipse as an existing Maven project.

3. Create a PostgreSQL database named `soes`.

4. Configure your database URL, username, and password in `application.properties`. Keep credentials private and use environment variables where configured.

5. Run the `SoesApplication.java` main class.

6. Open the application in your browser:

   ```text
   http://localhost:8080
   ```

## 📂 Project Structure

```text
SOES/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/jsp/
│   │   ├── resources/
│   │   │   └── static/css/
│   │   └── webapp/
│   │       └── WEB-INF/views/
├── pom.xml
└── README.md
```

## 🔐 Security

The application uses Spring Security for authentication and role-based authorization. Database credentials should be configured locally and must not be committed to the public repository.

## 👨‍💻 Developer

**Omkar Mete**

GitHub: [OmkarMete](https://github.com/OmkarMete)

## 📌 Project Status

Developed as a Java Full Stack project to demonstrate online examination management, authentication, role-based access control, and database integration.
