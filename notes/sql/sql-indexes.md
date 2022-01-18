### Indexes

To explain the concept of [**indexes**](https://en.wikipedia.org/wiki/Database_index), think of the purpose of indexes in a book - you use them to speed up the process of locating some specific piece of information. You wouldn't want to skim an entire book to find where one word was mentioned; similarly, indexes allow databases to speed up the process of retrieving data.

When an index is created on a database column, a separate data structure is created in the database (typically some sort of balanced tree), which stores references that point to the actual records in the table. This data structure can be searched much more quickly than searching through the entire table itself. Significant performance benefits can be achieved by implementing indexes on commonly queried columns. For this reason, primary keys are automatically indexed by the RDBMS system.

#### Creating Indexes

The syntax to create an index on a table's column is:

```
CREATE INDEX index_name ON table_name (col1, col2, ...)
```

#### Deleting Indexes

```
ALTER TABLE table_name DROP INDEX index_name
```

#### Best Practices

You should consider adding an index to a column **when you anticipate or already know that the column will often be used** when searching the table for records. Often you will not know which columns should be indexed until you have gathered some data about queries run on the system in production.

### Types of Indexes

Indexes can be categorized into two types: clustered and non-clustered. Clustered indexes alter the order in which the records are physically stored on disk. Thus only one clustered index can be created on a given table. Non-clustered indexes specify a logical ordering of rows but do not affect the physical ordering, so there may be more than one non-clustered index in a table.

Additionally, there are further types of indexes:

* Bitmap
* Dense
* Sparse
* Reverse
* Primary
* Secondary

In-depth knowledge of indexes is not necessary for our training purposes, however.
