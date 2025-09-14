# FreelanceFlow.
# FreelanceFlow (In Progress)

FreelanceFlow is a full-stack web application built with **Spring Boot** and **MySQL** that helps **recruiters** and **freelancers** manage projects, track work, generate invoices, and analyze performance with interactive charts.  
It is currently under development and serves as a demonstration of my backend and frontend skills.

---

## 🚀 Features

### ✅ Implemented
- User authentication (login & registration) with secure password storage (BCrypt).
- Role-based dashboards (Recruiter / Freelancer).
- PDF invoice generation using **iText**.
- Data visualization with **Chart.js**.
- MySQL database integration for users, projects, and tasks.

### 🛠️ In Progress / Planned
- Recruiter dashboard:
  - Post new projects (with pay, hours, duration, etc.).
  - Track expenses per project.
  - Generate invoices for payments made.
  - Charts for workers hired and money spent.
- Freelancer dashboard:
  - Log hours and project contributions.
  - Track earnings and generate invoices.
  - Charts for time spent and income breakdown.
- Admin panel for managing users and overseeing platform activity.

---

## 🖥️ Tech Stack

- **Backend:** Spring Boot (Spring MVC, Spring Data JPA, Hibernate)  
- **Frontend:** HTML, CSS, JavaScript, Chart.js  
- **Database:** MySQL  
- **PDF Generation:** iText  
- **Tools:** IntelliJ IDEA, Git, Maven  
---

## 📂 Project Structure
```
src/main/java/com/freelanceflow
├── config/
├── controller/
├── dto/
├── model/
├── repository/
└── service/

src/main/resources/templates/
├── login.html
├── register.html
└── dashboard.html
```
## ⚡ Setup (For Reference Only)

This project is **still in development** and not fully functional.  
Below are the steps that would typically be used to run it locally once completed:

1. Clone the repository  
2. Create a MySQL database  
3. Configure `application.properties` with database credentials  
4. Run the project using Maven/Spring Boot  

Since this project is not finished, the application may not start or may have incomplete features.
## 🎯 Learning Goals

This project is part of my journey to strengthen full-stack development skills.  
Through FreelanceFlow, I am practicing:  
- Building REST APIs with Spring Boot  
- Using DTOs, services, and repositories for clean architecture  
- Securing authentication with BCrypt  
- Generating PDFs with iText  
- Visualizing data with Chart.js  
- Designing a MySQL-backed application
## 📜 License
This project is for educational and portfolio purposes only.



