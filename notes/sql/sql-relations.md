## Multiplicity

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
| 2        | 1          | 2          |
| 3        | 1          | 3          |
| 4        | 2          | 1          |
| 5        | 2          | 3          |

We can see above that Teacher 1 teaches both Student 1 and 2 in the same class. Teacher 2 teaches Student 1 and 3 in a different class. Teacher 1 also has another class where he just teaches Student 3.


## Referential Integrity

When we create table relationships as demonstrated above, it is important that our data remains in a consistent state throughout the database. For example, we never want a record on our class table to be pointing to a record in either the Teacher or the Student table that does not exist. We call enforcing this property as maintaining **referential integrity**. When we break referential integrity, we will find **orphan records** in the database - these are records whose foreign keys do not point to an existing record in the other table. One way of preventing this from occuring is by using a setting called **CASCADE DELETE** - when we enable this, deleting a record in the table will also cascade that operation and delete any records in tables that reference the that record via foreign keys.


