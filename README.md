# 📚 Library Management System

A simple **Library Management System** built using **Java**, **JDBC (MySQL)**

---

## ✨ Features

- Add a new user
- View all users
- Delete a user
- Add a new book
- View all books
- Borrow a book
- Delete a book
- MySQL database integration
- Swing-based or CLI-based interface

---

## 🛠️ Technologies Used

- Java (JDK 17)
- MySQL
- JDBC
- IntelliJ IDEA / Eclipse

---

## 🗃️ Database Schema

### `user` Table
| Column        | Type          |
|---------------|---------------|
| id            | int (Primary Key, Auto Increment) |
| name          | varchar(100)  |
| phone_number  | varchar(15)   |
| address       | varchar(255)  |

### `book` Table
| Column        | Type          |
|---------------|---------------|
| id            | int (Primary Key, Auto Increment) |
| book_name     | varchar(50)   |
| book_author   | varchar(50)   |
| price         | int           |
| is_borrowed   | tinyint(1)    |

---

## ⚙️ Setup Instructions

### ✅ Prerequisites

- Java JDK installed
- MySQL Server running
- IntelliJ IDEA or any IDE
- MySQL JDBC Driver (`mysql-connector-java`)

---

### 💻 Clone the Repository

```bash
git clone https://github.com/VivekMishra21/Library-Management-System.git
cd Library-Management-System
