# 📚 Java Library Management System (Mini Project)

##  Project Overview
This is a **console-based Library Management System** developed in Java using Object-Oriented Programming (OOP) concepts. The system allows users to manage books in a library, including both **Printed Books** and **E-Books**.

The project demonstrates core OOP principles such as:
- Encapsulation
- Inheritance
- Polymorphism
- Method Overriding

It uses a **menu-driven console interface** for user interaction.

---

## Features

- Add Printed Books
- Add E-Books
- Display all books
- Search books by ID
- Update book details
- Delete books
- Handles both printed books and e-books using inheritance
- Demonstrates runtime polymorphism

---

## Project Structure

### 1. Book (Parent Class)
- Contains common attributes:
  - id
  - title
  - author
  - publishedYear
- Provides getters, setters, and display method

### 2. PrintedBook (Child Class)
- Extends `Book`
- Additional attribute:
  - numberOfPages
- Overrides `displayInfo()`

### 3. EBook (Child Class)
- Extends `Book`
- Additional attribute:
  - fileSize (MB)
- Overrides `displayInfo()`

### 4. Library Class
- Manages an array of `Book` objects
- Supports:
  - Add book
  - Show books
  - Search book
  - Update book
  - Delete book

### 5. MiniProject (Main Class)
- Contains `main()` method
- Menu-driven program using `Scanner`

---

## Technologies Used

- Java (Core Java)
- Object-Oriented Programming
- Arrays
- Scanner class for user input

---

## OOP Concepts Demonstrated

- **Encapsulation** : Private variables with getters/setters  
- **Inheritance** : PrintedBook & EBook extend Book  
- **Polymorphism** : Method overriding in displayInfo()  
- **Abstraction ** : Hiding implementation inside classes  

---

## How to Run the Project

### 1. Compile the program
```
javac MiniProject.java