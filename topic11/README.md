#topic 11

[model diagram]()
[create_script]()

# 1. What database types do you know? What are the differences between them?
relational database - structured using tables, columns and rows with relationships defined with primary and foriegn keys.
non relational database - structured using documents (JSON), key-value pairings, graph structures, etc...
# 2. What are the 3 normal forms of database?
- First Normal Form: each field contains a single value. A field may not contain a set of values or a nested record. 
- Second Normal Form: Builds on 1NF by ensuring that all non-primary key columns are fully dependent on the primary key (no partial dependencies).
- Third Normal Form: Builds on 2NF by ensuring that no non-primary key column depends on another non-primary key column (no transitive dependencies).
# 3. What is Primary key?
A Primary Key is a column (or combination of columns) in a table that uniquely identifies each row in the table. It must contain unique values, and it cannot contain NULL values.
# 4. What is Foreign key?
A Foreign Key is a column (or combination of columns) that establishes a link between two tables. It references the primary key of another table, enforcing referential integrity between the two tables.
# 5. What actions on delete/update do you know? What are the differences between them?
CASCADE: When a referenced row is deleted/updated, all rows that reference it are also deleted/updated.
SET NULL: When a referenced row is deleted/updated, the foreign key column in the referencing row is set to NULL.
SET DEFAULT: When a referenced row is deleted/updated, the foreign key column in the referencing row is set to its default value.
RESTRICT: Prevents the deletion/update of a referenced row if there are any referencing rows.
NO ACTION: Similar to RESTRICT, but is used when the database does not support RESTRICT.

# 6. What DB relations do you know? How are they realized in relational DB?
One-to-One: Each row in the first table is related to one row in the second table.
One-to-Many: Each row in the first table is related to one or more rows in the second table.
Many-to-Many: Each row in the first table is related to one or more rows in the second table, and each row in the second table is related to one or more rows in the first table.
# 7. What column types do you know? How to represent Java primitive types/String/Dates using them?
- INT: Java primitive types (int, short, long, byte)
- DECIMAL: Java primitive types (double, float)
- CHAR/VARCHAR: Java String
- DATE/TIME: Java Date