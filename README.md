# Craft Courses Management System

<p align="center">
  <img src="https://github.com/user-attachments/assets/15b1a00b-2c81-4642-8ffd-3712e08c398b" width="600" height="400" alt="Login">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/ce064320-a189-4ea1-b021-a0bda7f2a2fd" width="600" height="400" alt="User Interface">
</p>

## Overview

This project is a software solution designed for a company that offers various handicrafts courses, aiming to facilitate the management of courses and participants. The project includes a comprehensive management system for course management, student registrations, instructor information, and payment processes.

## Project Description

This project provides a system where users can create and manage various handicrafts courses. The system allows participants to register for courses, instructors to teach at available times, and ensures that payments are processed correctly.

### Objectives

1. **Student Records:** Students can access information about courses they have previously attended and upcoming courses they are registered for.
2. **Instructor Information Management:** The system records instructor details, their available working hours, and the subjects they can teach.
3. **Lesson Creation and Management:** Staff can define handicrafts lessons and create courses that include these lessons.
4. **Course Creation and Management:** Staff can create courses that include defined lessons.
5. **Payment Processing:** The system tracks participant payments and stores registration details in the database.
6. **Course Enrollment:** Students can register for suitable courses.

## Features

- Management of courses, instructors, students, and lessons.
- Assignment of instructors based on availability and working hours.
- Different payment methods and course fees.
- Course registrations and access to past course information.

## Technologies

- **Java:** The project is developed in Java.
- **PostgreSQL:** Used for database management.
- **Swing:** Java Swing is used for the user interface.

## Setup

1. **Database Setup:**
   - Install PostgreSQL and use the SQL files in the `database/` directory to create the database.

2. **Project Setup:**
   - Clone the project from GitHub:
     ```bash
     git clone https://github.com/username/repository.git
     ```
   - Open the project in NetBeans IDE or a similar Java IDE.

3. **Connection Settings:**
   - Update the `dbUrl`, `dbUsername`, and `dbPassword` in the `DatabaseHelper.java` file with your database details.

## Usage

1. **Launch the Application:**
   - Run the project from your IDE to start the application.

2. **Student Registrations:**
   - Register new students by entering their `Student` information.

3. **Instructor Registrations:**
   - Register new instructors by entering their `Instructor` information.

4. **Lesson Creation and Management:**
   - Create new lessons, update lesson details, and manage them.

5. **Course Creation and Management:**
   - Create new courses that include defined lessons and manage them.

6. **Payment Processing:**
   - Track student payments and complete registration processes.

7. **Course Enrollment:**
   - Register students for appropriate courses and manage enrollment information.

## Contributors

- Abdullah Belikırık
- Büşra Güral
- Emir Oğuz
- Mert Tuna Kurnaz
- Müdafer Kaymak
