## Constraints

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

Finally, a **default** constraint allows setting default values on columns for records that are inserted into the table.

Finally **Auto-increment** allows a unique number to be generated automatically when a new record is inserted into a table. Very often the *primary key* of a table needs to be created automatically, and we define that field as AUTO INCREMENT field. Following is the syntax for creating an AUTO INCREMENT field.

```SQL
CREATE TABLE TableName (
Column1 DataType AUTO_INCREMENT PRIMARY KEY,
Column2 DataType, 
);
```

### Candidate and Composite Keys

Usually a primary key consists of a single column; however, sometimes we may have a scenario in which there could be multiple columns that together create a primary key to uniquely identify rows. We call these **candidate keys**. Once we identify the actual combination of columns to use as the primary key, we call this a **composite key**. For example, if you are modeling your CD collection, you might have fields such as `track_no`, `album_id`, and `genre` in the `Track` table. The `track_no` itself cannot work as a primary key because many different albums can have a track #1, for example. So we would need to create a composite key here, consisting of the `track_no` and the `album_id` columns. Using both of these columns together we can find the specific track we are looking for.
