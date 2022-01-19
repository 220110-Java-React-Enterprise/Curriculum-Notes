# SQL Schema

This module covers schemas, constraints, multiplicity, and normalization in RDBMS systems.

### Helpful References

* [Oracle Docs - Constraints](https://docs.oracle.com/cd/B19306_01/server.102/b14200/clauses002.htm#:~:text=Use%20a%20constraint%20to%20define,declare%20them%20in%20two%20ways.)

### Defining 'Schema'

A [database schema](https://en.wikipedia.org/wiki/Database_schema) refers to the formal **structure** of data defined in a relational database. This includes the various tables in the database as well as their columns, data types, and the relationship between tables. Schemas are enforced using **constraints** when defining tables, and we can visualize the schema of relational databases through entity-relationship diagrams, or **ERD**s.

*NOTE: In Oracle databases, schema can also refer to a logical data storage structure. Oracle systems create a separate "schema" for each database user. However, we will refer to the original definition above from now on when we mention schema. Don't let this confuse you.*

### Constraints

We can put integrity **constraints** on specific columns in our database when defining tables, which allow us to enforce the schema by ensuring consistency and integrity of the data in the table. The different constraints are listed below:

* PRIMARY KEY
* FOREIGN KEY
* NOT NULL
* UNIQUE
* CHECK
* DEFAULT
* AUTO INCREMENT

A **primary key** is a constraint that uniquely identifies a record in a table. Often, this constraint will be enforced on some sort of "ID" field, such as "employee_id". A primary key is inherently composed of two other constraints - unique and not null. Thus, a primary key *MUST* be provided when inserting a record into a table, unless the RDBMS system is generating it automatically behind the scenes.

A **foreign key** constraint signifies that a column represents a reference to the primary key of another table. This allows us to create relationships between tables. For example, if we are modeling cars and the owners of those cars, we might have a `Car` table with an `owner_id` foreign key that references the `user_id` field in the `People` table. We can then lookup the owner of any car by fetching the `owner_id` of the car and finding the matching `user_id` in the `People` table.

A **not null** constraint simply enforces that all records must have a field for the column on which this constraint is applied. For example, we know that every person has a social security number, so we might want to consider placing a not null constraint on that field in our users table (assuming we want to store the social security numbers). This prevents users of the database from leaving the table in an inconsistent or invalid state. The **unique** constraint works similarly - records cannot be inserted if another record already has the same value for the column on which this is declared.

The **check** constraint provides a way of performing validation on values before records are entered into the table. For example, we may want to ensure that a bank account can never have a negative balance, so we might set a check constraint (`CHECK (balance >= 0)`).

A **default** constraint allows setting default values on columns for records that are inserted into the table.

Finally **Auto-increment** allows a unique number to be generated automatically when a new record is inserted into a table. Very often the *primary key* of a table needs to be created automatically, and we define that field as AUTO INCREMENT field. Following is the syntax for creating an AUTO INCREMENT field.

```SQL
CREATE TABLE TableName (
Column1 DataType AUTO_INCREMENT PRIMARY KEY,
Column2 DataType, 
);
```

#### Candidate and Composite Keys

Usually a primary key consists of a single column; however, sometimes we may have a scenario in which there could be multiple columns that together create a primary key to uniquely identify rows. We call these **candidate keys**. Once we identify the actual combination of columns to use as the primary key, we call this a **composite key**. For example, if you are modeling your CD collection, you might have fields such as `track_no`, `album_id`, and `genre` in the `Track` table. The `track_no` itself cannot work as a primary key because many different albums can have a track #1, for example. So we would need to create a composite key here, consisting of the `track_no` and the `album_id` columns. Using both of these columns together we can find the specific track we are looking for.

### Multiplicity

As mentioned before, table relationships can be defined using foreign key constraints. There are several different kinds of relationships that exist between tables in relational databases:

* One to one
* One to Many / Many to One
* Many to Many

A one-to-one relationship means that each entity in the table only relates to a single entity in the other table. For example, if we are modeling a school, where each classroom has a single projector in it, we would want to make this relationship a one to one between the `Classroom` and the `Projector` tables. In our database, we can provide the classroom table a `projector_id` foreign key and provide the projector table a `classroom_id` foreign key. To enforce the one to one aspect, we should also apply a *unique* constraint on the foreign key columns. Otherwise, a user could add another projector record with the same `classroom_id` as an existing record, and then our one to one relationship would be broken.

A one to many (or vice versa, many to one) relationship is where one entity can belong to, own, or otherwise relate to multiple other entities. In our school modeling example, a Student could have many books, so this would be a one to many relationship. To create this in the database, we add the foreign key **only on the many side of the relationship** - so a book entity would have a field such as `student_id` as a foreign key to identify the owning student.

A many-to-many relationship implies a one-to-many relationship in both directions on the entities. For example, a Teacher can have many Students, but a Student could have many Teachers as well. In this case, **we cannot provide a direct link between the tables in the database - instead, we need to create what is called a *junction table* or *bridge table* to relate the two tables**. So, in our student-teacher example, we could create a `Class` table which contains two foreign keys - one that refers to the Teacher table's primary key and one that refers to the Student table's primary key. This creates a list of unique Teacher-Student mappings that can be used to look up which students a particular teacher teaches, or which teachers a particular student has. An example is shown below.

#### Class Table

| ClassId | TeacherId | StudentId |
| -------- | ---------- | ---------- |
| 1        | 1          | 1          |
| 1        | 1          | 2          |
| 2        | 1          | 3          |
| 3        | 2          | 1          |
| 3        | 2          | 3          |

We can see above that Teacher 1 teaches both Student 1 and 2 in the same class. Teacher 2 teaches Student 1 and 3 in a different class. Teacher 1 also has another class where he just teaches Student 3.

### Referential Integrity

When we create table relationships as demonstrated above, it is important that our data remains in a consistent state throughout the database. For example, we never want a record on our class table to be pointing to a record in either the Teacher or the Student table that does not exist. We call enforcing this property as maintaining **referential integrity**. When we break referential integrity, we will find **orphan records** in the database - these are records whose foreign keys do not point to an existing record in the other table. One way of preventing this from occuring is by using a setting called **CASCADE DELETE** - when we enable this, deleting a record in the table will also cascade that operation and delete any records in tables that reference the that record via foreign keys.

### Normalization

[**Normalization**](https://en.wikipedia.org/wiki/Database_normalization) refers to an optimization process of structuring a relational database in a way that *reduces redundancy* of data and improves data integrity and consistency. There are many different normal forms, which relate to the degree to which a database has been normalized. We will look at the first three normal forms, each of which build upon the previous:

* 1NF - must have a primary key, no repeating groups, and atomic columns
* 2NF - must already be in 1NF, plus have no partial dependencies
* 3NF - must already be in 2NF, plus have no transitive dependencies

The first normal form enforces that a table **must**:
* Have a primary key
* Each column should be as granular as possible (e.g. "Name" column should be broken up into: "First Name", "Last Name", "Middle Name", etc..)

To be in second normal form, a table must **also**:
* Cannot have columns that are dependent on only one part of the key
* If there are no composite primary keys, you are automatically in 2NF

Finally, to get to third normal form, a table must **also**:
* Not have transitive dependencies
* This means that if column C relates to column B which relates to column A which is the primary key, this is not in 3NF because C is related to the primary key but indirectly (it is a transitive dependency)

To advance into higher normal forms, we typically "break up" tables into multiple tables and relate them to each other via foreign keys.

A good way of remembering these normal forms in order is to remember the legal proceeding of swearing to tell the truth, the whole truth, and nothing but the truth. In relational databases, we must have **the key (1NF), the whole key (2NF), and nothing but the key (3NF)** so help me Codd.

One way to eschew all of this for the purposes of this training class is to simply always use a single column primary key whose sole purpose is to uniquely identify any row in the table. Doing this will cover all of the primary key considerations from 1NF to 3NF. The only other thing we would be concerned with for this training would be the atomicity of columns, that is columns should be as granular and specific as possible.
