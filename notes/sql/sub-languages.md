# SQL Sub-Languages
## Overview

All SQL statements are separated into different sub categories, also known as sub-languages. There are 5 sublanguages of SQL in total:

1. DDL - data definition language
2. DML - data manipulation language
3. DQL - data query language
4. DCL - data control language
5. TCL - transaction control language

### DDL
**Data Definition Language (DDL)** statements are those for creating and modifying database objects. We use DDL to define the database **schema**. Schema just means the structure of the database, including tables, indexes, constraints, and more. 
  
Some examples of DDL keywords include: 
 - `CREATE` is used to create the database or its objects (like table, index, function, views, store procedure and triggers).
 - `DROP` is used to delete objects from the database.
 - `ALTER` is used to alter the structure of the database. (Commonly used to alter objects created with `CREATE`)
 - `TRUNCATE` is used to remove all records from a table. Space allocated to store those records is de-allocated.
 - `RENAME` is used to rename an object existing in the database.


### DQL
**Data Query Language (DQL)** statements are used to retrieve data from the database. The primary DQL keyword is `SELECT`. `SELECT` statements are used to query the database and commonly also utilize clauses that filter, manipulate, or aggregate data, like `WHERE`, `HAVING`, and `JOIN`.

### DML
**Data Manipulation Language(DML)** statements are used to add, remove, and alter data in the database. Particularly, these statements work on data stored in tables. Some examples of DML keywords include:
 - `INSERT`
 - `UPDATE`
 - `DELETE`

Note that `DELETE` and `DROP` are different keywords with different meanings. One is used to drop objects like tables. The other is used to remove data from tables. These statements commonly include clauses that filter data, such as `WHERE`.

### DCL

Data Control Language statements are used to manage the security and control of database systems.

 - GRANT, to grant any permissions to an existing user.
```sql
GRANT PERMISSION TO USERNAME
```

 - REVOKE, to revoke any permissions of an existing user.
```sql
REVOKE PERMISSION TO USERNAME
```



### TCL

Transaction Control Language statements are utilized to manage transactions within a relational database.

 - COMMIT, any DML operations that were executed before the statements will be persisted permanently.
 - ROLLBACK, any DML operations between two COMMIT statements will be completely erased (something like Ctrl + Z that will stop only when it reaches last time you opened the specific file). Committed transactions cannot be rollbacked.
 - SAVEPOINT, utilized to ROLLBACK to a specific point in time.

The general flow of using TCL could be as follows:

```sql
[Many DML Operations]
SAVEPOINT A
[Many DML Operations]
ROLLBACK TO A
```

## SQL Examples
Below will be some examples that show the use of the basic SQL we've covered thus far:

#### Create a table
```sql
CREATE TABLE users (
  user_id INT NOT NULL,
  first_name VARCHAR(40),
  last_name VARCHAR(40),
  username VARCHAR(40),
  email VARCHAR(200),
  CONSTRAINT users_pk PRIMARY KEY (user_id)
);
```
Here we can see the use of the `CREATE` keyword. The object we are creating is a `TABLE` and we name this table "users". We then open a parenthesis for a block of code describing the table we want to create. At the end we close the parenthesis and add a semicolon to indicate the end of the statement. 
  
Inside the parenthesis we describe the table. Each line is an attribute and they must be separated with commas. The first five lines each describe a column and give a data type for what will be stored in that column. The first line also adds `NOT NULL` which indicates that there must be data in this field. If we try to insert data without a valid ID the statement will fail.
  
Lastly we see a `CONSTRAINT`. This line indicates there is some constraint or rule regarding data in the table. In this case `PRIMARY KEY` is telling the DBMS that user_id is the primary key column. We'll discuss this and other constraints in greater detail later, but for now know that every table must have a primary key which can be used to uniquely identify exactly one row in the table.
  
  
#### Insert Data
```sql
INSERT INTO users VALUES (1, "Kyle", "Plummer", "kplummer", "kplummer@email.com");
INSERT INTO users (user_id, first_name, last_name, username) VALUES (2, "James", "Bond", "doubleohseven");
```
Here we are inserting two rows into the table we created above. We begin with `INSERT INTO`, then the table we want to add data to. Then the two statements diverge slightly. The first statement uses the `VALUES` keyword to list the data that will be inserted. Notice that the second line first lists the columns that the data go into. You can omit the column list as long as the `VALUES` are in the correct order and include values for every column. If they are going to be out of order or omit any columns, you must specify the column list first, then make sure the `VALUES` list matches data to those columns.
  
Again at the end we use a semicolon to indicate the end of a statement.


#### Change Data
```sql
UPDATE users SET username = "SecretAgentMan" WHERE user_id = 2;
UPDATE users SET username = "KylePlummer", email = "kyle.plummer@email.com" WHERE user_id = 1;
```
Here we update some of the data in each of the two rows we inserted above. Using the `UPDATE` keyword we then declare the table we are updating, then the `SET` keyword is used to indicate the columns we want to change. Note that in the first statement we are only changing one field, but in the second we are changing two. `SET` can indicate multiple changes in a single statement, separated by commas. We then use the `WHERE` clause to specify which rows we want to update. `WHERE` is a very commonly used keyword used to filter or indicate specific rows or circumstances. In this example we are using `WHERE` to indicate a single row based on the unique primary key values.

#### Select Data
```sql
SELECT *
FROM users;
```
In this example we see the use of the `SELECT` keyword to query data from the users table. Note the `*`, this is a wildcard. We usually want to select some number of columns from the table, and we would do this by listing the columns after `SELECT`. Here, however, we are selecting all columns.
  
```sql
SELECT first_name, last_name, email
FROM users
WHERE first_name LIKE "K%";
```
Here we see an example that only selects some columns from our table, and filters the data with the `WHERE` clause to include only rows where the first_name column begins with 'K'. We could look for rows where the name is "Kyle" like this: `WHERE first_name = "Kyle"`. In this example we use the `LIKE` keyword and the `%` wildcard which indicates "zero or more characters" to filter any names that begin with 'K'.

#### Delete Data
```sql
DELETE FROM users
WHERE user_id = 1;
```
Here we see the use of the `DELETE` keyword to remove data from a table. Delete removes an entire row from the table, im this case using the `WHERE` clause to filter only a specific row based on the unique primary key.

#### Drop Table
```sql
DROP TABLE users;
```
Here we see the `DROP` keyword used to completely remove the users table from the database. Be careful with `DROP`! The table and all data therein will be gone.
