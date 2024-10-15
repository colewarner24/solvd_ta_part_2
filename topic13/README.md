# topic 13

[main code with all classes](https://github.com/colewarner24/solvd_ta_part_2/tree/topic13/jdbc/src/main/java/booking)

# Questions

# 1. What is JDBC? How does it connect with the DB providers? 
JDBC (Java Database Connectivity) is an API in Java that allows Java applications to interact with databases. It provides methods for querying and updating data in a database and allows for connection management, statement execution, and result handling.
The JDBC connects to a database using drivers that can interact with a db.

# 2. What is DAO?
is a design pattern that provides an abstract interface to a database or other persistence storage separating the business and data access logic.

# 3. Why do we need a service layer in terms of DAO classes?
The service layer acts as another abstraction layer to seperate all database operations from business logic.

# 4. What is transaction? How is it realized in JDBC?
A transaction is a sequence of one or more operations to a database. A transaction can be rollbacked to save a state of the db.
It is realized in the JDBC by using commit() and rollback()

# 5. What are the differences between Statement and PrepareStatement? 6. What is ResultSet?
Statement executes sql statements without parameters while prepareStatement lets you dynamically add parameters.
ResultSet is the object of the result of the sql query. It has methods of traversing and obtaining the results.
