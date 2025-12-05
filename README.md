# Smart Contact Manager 
Smart Contact Manager is a full-stack web application built using Spring Boot, designed to help users store, manage, and organize their contacts securely.
It includes user authentication, contact CRUD operations, profile management, image uploads, and role-based access.

The system is inspired by real-world contact management apps and follows clean code, modular structure, and best backend practices.

##  Features
### 🔐 Authentication & Security
- User Registration & Login
- Password Encryption using Spring Security / BCrypt
- Role-based access (USER / ADMIN)

### 📇 Contact Management
- Add new contacts
- View all contacts
- Search contacts
- Update existing contacts
- Delete contacts
- Upload profile pictures for contacts

### 👤 User Profile
- View logged-in user profile
- Update user details
- Upload/change profile image
- 🖼 File Upload Support
- Store contact profile images
- Store user profile images
- Auto-delete old images when replacing

### 📱 Responsive UI
- Built using Thymeleaf + Bootstrap
- Mobile-friendly layout

## Module Covered
- User Signup using email and password
- Verify account using email verification link
- User signup with google and github
- Add the contact picture
- Contact picture is uploaded to cloud
- User can view all contacts
- Compose and send the email directly from SCM
- Email contains text attachment
- update the contact
- Delete the contact
- Search the contact
- Pagination
- Exporting contact data to excel or pdf
- Edit profile details
- Dark and light theme
- Provide Feedback

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring data Jpa
- Spring Security
- Hibernate JPA
- MySQL Database

### Frontend
- Thymeleaf
- FlowBite Components
- JavaScript

### Build Tool
- Maven

## How to Run Locally
1. Clone Repository
```
git clone https://github.com/Anjali22-07/SCM.git
cd smart-contact-manager

```

2. Configure Database
Update application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/YourDatabaseName
spring.datasource.username=yourUsername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

```

3. Run the Application
```
mvn spring-boot:run

```

4. Access the App
```
http://localhost:8080

```

## Contributing
Feel free to open issues, suggest features, or submit pull requests.


## License
This project is licensed under the [MIT License](License)

## Author
[Anjali Singh](https://github.com/Anjali22-07)
