# Creating new user, and adjusting permissions
CREATE USER 'newuser' IDENTIFIED BY 'password'
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, ALTER ON demo.* TO  'newuser';
REVOKE CREATE, DROP, ALTER ON demo.* FROM 'newuser'


# If you ever need to change a user account password:
SET PASSWORD FOR 'admin' = PASSWORD('P4ssw0rd!');


# Transaction Control example
# Start transaction, do an update, make savepoint, do another update, roll that update back
# do a final update, and then commit nly the first and last updates. The middle one was ignored
# becuase we rolled it back.
START TRANSACTION;
UPDATE associates 
SET age = age + 1;
SAVEPOINT A;
UPDATE associates 
SET last_name = UCASE(last_name);
ROLLBACK TO A;
UPDATE associates 
SET first_name = UCASE(first_name);
COMMIT;


# making changes to our table schema, we add some columns, but then remove the state
# column because we decided to utilize a lookup table for states.

ALTER TABLE associates 
ADD COLUMN email VARCHAR(200)
ADD COLUMN state CHAR(2);

ALTER TABLE associates 
DROP COLUMN state
ADD COLUMN state_id INT;

# create our state lookup table, a lookup table is a normalization and optimization technique
# where values that are inserted and rarely changed are placed in their own smaller table
CREATE TABLE state_lookup (
	state_id INT NOT NULL,
	state CHAR(2) NOT NULL,
	state_name VARCHAR(20),
	CONSTRAINT state_lookup_pk PRIMARY KEY (state_id)
);

# Here we add the foreign key constraint to the associates table, creating a relation
# between it and the state lookup table.
ALTER TABLE associates 
ADD CONSTRAINT associates_state_lookup_fk FOREIGN KEY (state_id) REFERENCES state_lookup (state_id);


# insert values into our state lookup table
INSERT INTO state_lookup (state_id, state, state_name) 
VALUES 
(1, 'TN', 'Tennessee'),
(2, 'MD', 'Maryland'),
(3, 'MO', 'Missouri'),
(4, 'NY', 'New York'),
(5, 'TX', 'Texas')



# look up associates and include the state from the lookup table
SELECT first_name, last_name, s.state_name 
FROM associates a 
JOIN state_lookup s ON a.state_id = s.state_id 


# Let's talk about sequences and auto generated ids. There are two good ways to handle auto generated ids:
# Auto incrementing INT
# UUIDs

# Auto incrementing sequence, every time we insert a new row (without specifying the ID)
# it gives us an ID which is the current greatest value + 1

CREATE TABLE auto_id (
	id INT AUTO_INCREMENT,
	string VARCHAR(200),
	CONSTRAINT auto_id_pk PRIMARY KEY (id)
);

select * from auto_id;
# This next statement inserts without an ID, so the database engine provides it
INSERT INTO auto_id (string) VALUES ("message");

# we can also force our own ID into the table, provided it's unique
INSERT INTO auto_id VALUES (16, "Not automatic ID");


DELETE FROM auto_id WHERE id > 5;

# SEPCIFICALLY FOR HIBERNATE:
# When we insert into this table from Java code (JDBC) just make sure the entity is using Integer, 
# and not int. This is because int cannot be null, and Hibernate wants to see nulls where it 
# auto increments the value.



# This is ugly because it's not properly supported in MariaDB
# So, don't bother with it. It's much better and properly supported in Postgres and MS Transact-SQL
CREATE TABLE auto_uuid (
	id BINARY(16) NOT NULL,
	string VARCHAR(200),
	CONSTRAINT auto_uuid_pk PRIMARY KEY (id)
	
);

select * from auto_uuid;
INSERT INTO auto_uuid VALUES (UNHEX(REPLACE(UUID(), '-', '')), "message");

