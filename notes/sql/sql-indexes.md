### Creating Indexes
The syntax to create an index on a table's column is:

```sql
CREATE INDEX index_name ON table_name (col1, col2, ...)
```
### Deleting Indexes
```sql
ALTER TABLE table_name DROP INDEX index_name
```
### Best Practices
You should consider adding an index to a column when you anticipate or already know that the column will often be used when searching the table for records. Often you will not know which columns should be indexed until you have gathered some data about queries run on the system in production.
