## Module - Joins & Set Operations

### Joins

Used to combine two or more tables, joins are a database technique used in SELECT statements. Joins are normally performed comparing primary keys to foreign keys, however, they can be performed with any type of column, as long as the types match. Joins are a way of *denormalizing* a set of tables in order to aggregate or process some query.

They can be performed in many ways:
* INNER JOIN.
  * The most commonly used type of join, returns rows only if the columns specified in the join clause match.
* OUTER JOIN.
  * The OUTER keyword can be used with LEFT, RIGHT or FULL keywords to obtain rows which some of the join columns are NULL.
  * However, in Oracle, this word is optional. LEFT, RIGHT or FULL will be automatically OUTER.
* LEFT [OUTER] JOIN.
  * Returns the matching rows plus the ones that where null in the first table.
* RIGHT [OUTER] JOIN.
  * Returns the matching rows plus the ones that where null on the second table.
* FULL [OUTER] JOIN.
  * Returns all rows from both tables specified including the ones which had null values on either side.
* CROSS JOIN.
  * Returns the cartesian product two or more tables.
* SELF JOIN.
  * An INNER JOIN performed matching two columns existing in the same table.
  * They represent hierarchies.
* NATURAL JOIN
  * Used as a shortcut so that the join predicate is not needed to be specified
  * The tables are joined on matching column names

As you can see, all JOINS are INNER unless otherwise specified with keywords.

To write a join:
```sql
SELECT A.FIRSTNAME, C.NAME FROM STUDENT S INNER JOIN COURSE C  ON S.COURSEID = C.ID;
SELECT A.FIRSTNAME, C.NAME FROM STUDENT S, COURSE C  WHERE S.COURSEID = C.ID;
SELECT A.FIRSTNAME, C.NAME FROM STUDENT S, COURSE C  WHERE S.COURSEID = C.ID(+);
```

To optimize joins, put the tables to join from more data to less data, and then perform the joins in order.

#### Sub Queries

SELECT statements that can be performed in place of any DML statement.
* INSERT
  * In the VALUES clause as long as the SELECT returns only one row
  * To ensure this, add ROWNUM = 1 in the WHERE clause
* UPDATE
  * In the SET clause as long as the SELECT statement returns one row
  * In the WHERE clause (same SELECT WHERE rules apply)
* DELETE
  * In the WHERE clause (same SELECT WHERE rules apply)
* SELECT
  * In the FROM clause
  * In the WHERE clause
  * If the SELECT returns more than one row, use the keyword IN instead of the = operator

By theory, JOINS are faster than sub-queries, however, these last ones come in handy in many cases and there are some cases that they might perform better than a join.

### Set Operators

Set operators are different from joins. Instead of combining columns of two tables, set operators combine the rows of different result sets. Essentially, set operators perform some kind of (set) operation on two different queries.

Some set operators are:

* UNION [ALL]
  * UNION does not keep duplicates, but UNION ALL will
* INTERSECT
  * Only returns records in common between the queries
* MINUS
  * Removes from the first result set any rows that appear in the second result set and returns what remains
* EXCEPT
  * Same as MINUS, but for SQLServer instead of Oracle

<br>

## Alias

It can be used to rename a `table` or a `column` temporarily by giving another name known as **Alias**. The use of table aliases is to rename a table in a specific SQL statement. The renaming is a temporary change and the actual table name does not change in the _database_. The column aliases are used to rename a table's columns for the purpose of a particular SQL query.

The basic syntax of a table alias is as follows.
```SQL
SELECT column1, column2 FROM table_name AS alias_name
WHERE [condition];
```
The basic syntax of a column alias is as follows.

```SQL
SELECT column_name AS alias_name FROM table_name
WHERE [condition];
```
### Example

Table 1 :- Employee_Table

| Emp_ID | Emp_Name | Emp_Age | Emp_Address | Emp_Salary |
| :------: | :------: | :-----: | :------: |  :-----:
| 101 | John | 33 | New York | $32000 |
| 102 | Robert | 37 | Los Angeles | $39000 |
| 103 | Vincent | 28 | California | $23000 |
| 104 | Charles | 41 | Reston | $50000 |
| 105 | Peter | 48  | Florida | $62000 |
| 106 | David | 25  | Arlington | $27000 |

<br>
Table 2 :- Department_Table

| Dep_ID | Dep_Name | Emp_ID | Dep_Incentives |
| :------: | :------: | :-----: |  :-----: |
| 1104 | Sales | 101 | $756 |
| 1106 | IT | 102 | $815  |
| 1109 | Marketing | 103 | $230 |
| 1104 | Sales | 101 | $345|
| 1107 | HR | 106 | $467 |

Now the following code block will show the usage of **Alias in Table**.
```SQL
SELECT E.Emp_ID, E.Emp_Name, E.Emp_Salary, D.Dep_Incentives
FROM Employee_Table AS E, Department_Table AS D 
WHERE E.Emp_ID = D.Dep_ID;
```
This query will produce following result. 

| Emp_ID | Emp_Name | Emp_Salary | Dep_Incentives |
| :------: | :------: | :-----: |  :-----: |
| 101 | John | $32000 | $756 |
| 101 | John | $32000 | $1300 |
| 102 | Robert | $39000 | $815 |
| 103 | Vincent | $23000 | $230 |
| 106 | David | $27000 | $467 |
<br>

Following query shows the usage of **Alias in column** :-
```SQL
SELECT Emp_ID AS E_id, Emp_Name AS E_Name
FROM Employee_Table
WHERE Emp_Salary >= $30000;
 ```

| E_id | E_Name | 
| :------: | :------: | 
| 101 | John |
| 102 | Robert |
| 104 | Charles |
| 105 | Peter |
