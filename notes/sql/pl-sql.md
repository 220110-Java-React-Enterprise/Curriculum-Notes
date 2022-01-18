## Module - PL/SQL

### Helpful References

### PL/SQL

PL/SQL stands for the Procedural Language extension to SQL and it is a complete programming language which also allows SQL statements.

Besides the programming itself, Oracle offers an OOP aspect to its databases, providing certain types of objects, some of which require PL/SQL code. CREATE [OR REPLACE] and DROP statements are allowed for these objects. ALTER is not allowed.

#### Sequence

A **sequence** is an object which holds a numeric number that starts from a certain point and it also contains a max. It increments by a specific amount every time NEXTVAL is called.

They can be combined with **Triggers** to auto increment primary key columns.

```sql
CREATE [OR REPLACE] SEQUENCE START WITH 1 INCREMENT BY 1
```

#### Trigger

A **trigger** is a block of code that executes when a specific event happens. These events can be INSERT, UPDATE or DELETE statements, and they can happen AFTER or BEFORE.

Syntax:

```sql
CREATE [OR REPLACE] TRIGGER 
BEFORE INSERT ON TABLE_NAME
  FOR EACH ROW
  BEGIN
    (PL/SQL code)
  END;
```

#### Cursor

Pointers to a result set. They can be used to loop programmatically on the output of a SELECT statement (similar to iterators in Java).

Oracle provides `SYS_REFCURSOR`, its own type of `REFCURSOR`. This means you can create your own type of `REFCURSOR`. 

#### Stored Procedure

PL/SQL code that can be executed in certain ways and has some properties:

* They don't return anything.
* They may or may not contain IN (by value) and OUT (by reference) parameters.
* They allow any DML statements within.
  * These means transactions can be created in a stored procedure.
* Stored procedures can call other procedures and functions.
* Can NOT use stored procedures in DML statements.
  * `EXEC STORED_PROCEDURE`

#### Function

Also known as User Defined Functions, these are like stored procedures but have some other restrictions or abilities:

* They must return something.
* Cursors are allowed.
* It should be a single value.
* They may or may not contain IN parameters (by default).
* Only SELECT statements are allowed.
* Functions can only call other functions (no stored procedures).
* They can be used in any DML statement.
* To call a function, you have to use a DML statement (you can't `EXEC`).
* Use `FROM DUAL` if you are not selecting from a specific table.
* `DUAL` is a dummy table which returns anything your throw at it.

#### Types

Similar to classes, they can be used as your own datatypes for columns. We are not going to use this, because this is a high level technique which doesn't follow the normal forms.

##### VARRAY

Arrays of any Oracle data type or your own type, they can be used for columns.

##### Nested Table

Infinite arrays, they can be seen as tables in columns. They have to be of a specific data type.
