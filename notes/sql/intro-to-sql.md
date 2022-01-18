# SQL
SQL, or Structured Query Language, is a scripting language used to manipulate relational databases, commonly referred to as SQL databases. In the strictest sense SQL instructs a relational database management system in a similar way to how Java instructs the compiler and JS instructs the interpreter.
  
*SQL is often referred to as "sequel". Be cool, say sequel.*
  
# SQL Flavors
SQL is a standard described originally by Sun Microsystems, which is now owned by Oracle. The main SQL standard is implemented slightly differently by a number of different groups including Oracle, and Microsoft to name a few. These flavors of SQL are each a superset of the SQL standard with added features and slight syntactical differences. Once we know one it isn't difficult to transition to another. The flavor we will be working with in this training is MariaDB, which is an open source fork of MySQL. The syntax is very nearly the same as MySQL (from Oracle).

## SQL Sublanguages
The types of SQL commands used to query and manipulate data within a database can be categorized into 5 sub-languages (or dialects). We will be primarily interested in the first 3 seen below, DDL, DML, and DQL. 

1. **DDL Data Definition Language:** Statements used to create tables and databases as well as defined properties.
    * `CREATE`, `ALTER`, `DROP`, `TRUNCATE`
2. **DML (Data Manipulation Language):** Statements used to insert or remove data from tables.
    * `INSERT`, `UPDATE`, `DELETE`
3. **DQL (Data Query Language):** Statements used to query data from a table.
    * `SELECT`
4. **DCL (Data Control Language):** Statements used to control who can access data.
    * `GRANT`, `REVOKE`
5. **TCL (Transaction Control Language):** Statements used to commit and restore data through transaction.  Transactions group a set of tasks into a single execution unit.
    * `COMMIT`, `ROLLBACK`, `SAVEPOINT`

## Data Types

When defining the properties of an entity in the database (i.e. the columns), you must specify the data type to store. Common SQL datatypes include:

#### Numeric
- INT
- TINYINT
- BIGINT
- DECIMAL
- NUMERIC
- FLOAT
- REAL

#### Date/Time
- DATE
- TIMESTAMP
- DATETIME
- TIME
- YEAR

#### Character/String
- CHAR
- NCHAR
- VARCHAR
- NVARCHAR
- NTEXT

#### Binary
- BINARY
- VARBINARY
- IMAGE

#### Miscellaneous
- CLOB
- BLOB
- XML
- JSON

Each database vendor may support their own data types, or not support some of the ones listed above. Refer to the specific vendor documentation for more information.

### Conventions

SQL is a case-insensitive language, but the convention is to use UPPERCASE to refer to SQL keywords and lowercase for non-SQL specific entities (like table or column names). This helps distinguish between SQL keywords and other words. Also, for readability purposes we should split long commands or queries into multiple lines.

For example, this:

```sql
SELECT * FROM table1
LEFT JOIN table2 ON table1.a = table2.b
WHERE table1.x < 5
AND table2.y > 8
ORDER BY table1.a DESC
```

is much more readable than:

```sql
SELECT * FROM table1 LEFT JOIN table2 ON table1.a = table2.b WHERE table1.x < 5 AND table2.y > 8 ORDER BY table1.a DESC
```
