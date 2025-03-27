# Library_Management_System

A Library Management System built using Java Servlets, HTML, and CSS for managing books. It allows librarians to efficiently add, search, update, and delete books while maintaining their availability status.

## Features
Add a Book: Add books with Book ID, Title, Author, Genre, and Availability Status (Available or Checked Out).

Search for a Book: Search books by Book ID or Title.

Update a Book: Modify book details like title, author, and availability.

Delete a Book: Remove a book from the catalog.

View All Books: Display a list of all books in the library with their details.

## Setup Instructions
Step 1: Install Prerequisites
Make sure you have the following software installed:

JDK 8 or higher (Java Development Kit)

Apache Tomcat (or any servlet container that supports Java Servlets)

To install JDK (Java Development Kit):

Download JDK from Oracle's official website.

Install it according to the instructions for your operating system.

To install Apache Tomcat:

Download Apache Tomcat from Apache Tomcat.

Extract the downloaded files to a directory and follow the installation steps.

Step 2: Clone the Repository
Clone this repository to your local machine:

bash
Copy
git clone https://github.com/yourusername/library-management-system.git

Step 3: Set Up Your Tomcat Server
Move the Project to Tomcat:

Copy the entire LibraryManagementSystem folder to the webapps directory of your Apache Tomcat installation.

Example path for Tomcat:

swift
Copy
/path/to/tomcat/webapps/LibraryManagementSystem/

## Compile the Servlets:

Make sure your servlets are compiled and placed under WEB-INF/classes/com/example/.

If needed, compile your Java classes into .class files.

Step 4: Start Apache Tomcat
Open a terminal and navigate to the bin directory of Tomcat:

bash
Copy
cd /path/to/tomcat/bin
Start the Tomcat server:

bash
Copy
./startup.sh  # For Linux/macOS
startup.bat   # For Windows
Step 5: Access the Application
Open a web browser and go to:

plaintext
Copy
http://localhost:8080/LibraryManagementSystem/
This should display the front-end interface (HTML form).

## How to Use
1. Add a Book
Enter the Book ID, Title, Author, Genre, and Availability Status (Available/Checked Out).
Click Add Book to save the details.

2. Search for a Book
Enter the Book ID or Title in the Search form.
Click Search to view the book details.

3. Update a Book
Enter the Book ID of the book you want to update.
Update the Title, Author, or Availability Status.
Click Update Book to save the changes.

4. Delete a Book
Enter the Book ID of the book you wish to delete.
Click Delete Book to remove the book from the catalog.

5. View All Books
A list of all the books will be displayed after performing actions like adding, updating, or deleting a book.

## Challenges Faced During Development
While developing the Library Management System, a few challenges were encountered, and some lessons were learned:

1. Data Storage:
Initially, it was unclear how to persist data across different servlet invocations. We opted to store book records in memory (using a List<Book>), which works well for small-scale applications. However, this approach wouldn't persist the data after server restarts.
Improvement: In a production-grade application, a database (e.g., MySQL, PostgreSQL, or even an in-memory database like H2) should be used for persistent storage. Additionally, ORM frameworks like Hibernate could be explored for better database handling.

2. Form Validation:
Ensuring that user inputs are valid (e.g., Book ID uniqueness, non-empty Title and Author, Availability Status constraints) was initially done manually with if conditions, leading to repetitive code.
Improvement: JavaBeans validation (e.g., using @NotEmpty and @Size annotations) could be leveraged along with Hibernate Validator for cleaner, reusable validation logic.

3. Servlet Mapping:
Setting up servlet mappings in web.xml was a bit tricky at first. After some trial and error, I realized that it’s crucial to ensure that URLs are properly mapped to the right servlets.
Improvement: Using Servlet Annotations (@WebServlet) can simplify the setup by removing the need for web.xml. This is especially useful for more modern servlet configurations.

4. Styling and User Interface:
The UI was basic and lacked responsiveness on mobile devices. Although the HTML and CSS provided a functional interface, some users might find it not very modern or intuitive.
Improvement: Incorporating Bootstrap or a similar CSS framework could enhance the UI/UX and make it more responsive and visually appealing.

5. Concurrency Issues:
Since all book data is stored in-memory, there could be issues with concurrent access and modifications. For example, if two librarians try to update the same book at the same time, it could lead to inconsistent data.
Improvement: Introducing synchronized blocks or using thread-safe collections like ConcurrentHashMap could address concurrency issues in a small application. For a larger-scale system, using a transactional database is highly recommended.

## Future Improvements
If given more time, I would consider implementing the following improvements:

Persistent Storage: Integrate a relational database to store book records, ensuring data persistence across server restarts.

RESTful APIs: Implement a RESTful API backend (using Spring Boot or Java EE) for better scalability and flexibility.

User Authentication: Introduce user authentication to allow librarians to log in before accessing or modifying books.

Enhanced UI: Improve the user interface by incorporating modern frameworks such as React or Vue.js, and use Bootstrap to make the UI responsive.

Unit Testing: Implement unit tests for servlets, data validation, and other key parts of the application to ensure reliability.

