# Module - JDBC

JDBC stands for Java Database Connectivity. It is a relatively low-level API used to write Java code that interacts with relational databases via SQL.

## JDBC Introduction
The [JDBC classes and interfaces](https://docs.oracle.com/javase/8/docs/api/index.html?java/sql/package-summary.html) are located in the `java.sql` and `javax.sql` packages. There are several key classes and interfaces that are commonly encountered when writing JDBC code:
* `DriverManager` class - to make a connection with a database driver
* `DataSource` interface - for retrieving connections, an alternative to `DriverManager`
* `Connection` interface - represents a physical connection with a database
* `SQLException` class - a general exception thrown when something goes wrong when accessing the database
* `Statement` interface - used for executing static SQL statements
* `PreparedStatement` interface - represents pre-compiled SQL statements
* `CallableStatement` interface - used to execute stored procedures
* `ResultSet` interface - represents data returned from the database

## Creating a Database Connection
In order to interact with a database, we need to do several things:
1. Register the JDBC driver
2. Open a connection using:
  - Database URL
  - Username
  - Password
3. Execute some SQL statement using either:
  - `Statement`
  - `PreparedStatement`
  - `CallableStatement`
4. Retrieve the results that are returned in a `ResultSet` object

### Database JDBC Drivers
Because JDBC is a Java language API, it is database agnostic. It uses database drivers which implement the interfaces defined in the JDBC API for the given database. For example, to connect with an Oracle database, you would use an [OJDBC driver](https://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html). Other database vendors have different drivers which implement the JDBC API.

Many JDBC drivers are available through Maven's central repository and can be added as a dependency in the `pom.xml` file. Oracle is a special exception due to license restrictions. You must accept the licese agreement, download, and install it to your local Maven repository ([tutorial here](https://www.mkyong.com/maven/how-to-add-oracle-jdbc-driver-in-your-maven-local-repository/) before you can add it to the `pom.xml` file.

Finally, in your application code, you can register the driver using:
```
try {
   Class.forName("oracle.jdbc.driver.OracleDriver");
}
catch(ClassNotFoundException e) {
   System.out.println("Can't load driver class!");
}
```

This step is only necessary for drivers prior to JDBC 4.0 (released with Java SE 6). After JDBC 4.0, drivers will be autoloaded if they are included in the classpath.

### Creating a Connection
Now we can use the `DriverManager` class to get a `Connection` to the database, given that we have the JDBC URL, username, and password. Generally these parameters should be stored in an external configuration file that can be loaded dynamically and changed without affecting the application code.

```java
try ( Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);){
  // more code goes here
} catch (SQLException e) {}
```

Alternatively, the `DataSource` interface could be used to make connections and is covered extensively in this [Oracle tutorial](https://docs.oracle.com/javase/tutorial/jdbc/basics/sqldatasources.html).

It's always a good idea to close your resources - here we've used the `try-with-resources` syntax to automatically close the `Connection` being created after the block ends.

#### Autocommit mode
By default, when a connection is created it is in auto-commit mode, so every SQL statement acts as a transaction and is committed immediately after execution. In order to manually group statements into a transaction, simply call:

```java
Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
conn.setAutoCommit(false);
// execute some SQL statements...
con.commit();
```

#### JDBC String

The database URL is an address pointing to the database to be used, also known as the JDBC String. The format of this URL varies between database vendors, as shown in the table below:

| RDBMS | JDBC driver | URL format |
| ----- | ----------- | ---------- |
| MariaDB | `org.mariadb.jdbc.Driver` | jdbc:mariadb://hostname:port/databaseName?user=username&password=password |
| MySQL | `com.mysql.jdbc.Driver` | jdbc:mysql://hostname/databaseName |
| Oracle | `oracle.jdbc.driver.OracleDriver` | jdbc:oracle:thin:@hostname:portNumber:databaseName |
| SQLServer | `com.microsoft.sqlserver.jdbc.SQLServerDriver` | jdbc:sqlserver://serverName:portNumber;property=value |
| PostgreSQL | `org.postgresql.Driver` | jdbc:postgresql://hostname:port/databaseName |

### Executing SQL
Once we have the `Connection` object, we can write our SQL and execute it:

```java
Statement stmt = conn.createStatement();
String sql = "SELECT * FROM employees";
ResultSet rs = stmt.executeQuery(sql);
```

Alternatively, a `PreparedStatement` can be used. This interface gives us the flexibility of specifying parameters with the `?` symbol. It also protects against [SQL injection](https://en.wikipedia.org/wiki/SQL_injection) when user input is used by pre-compiling the SQL statement.

```java
String sql = "SELECT * FROM employees WHERE age > ? AND location = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setInt(1, 40);
ps.setString(2, "New York");
ResultSet rs = ps.executeQuery();
```

The `Statement` and `PreparedStatement` also have additional methods for sending SQL, including:
* `.execute()` - for any kind of SQL statement, returns a `boolean`
* `.executeUpdate()` - for DML statements, returns an `int` which is the number of rows affected

### Retreiving Results
Results from an SQL query are returned as a `ResultSet`, which can be iterated over to extract the data:

```java
List<Employee> empList = new ArrayList<>();
while (rs.next()) {
  int id = rs.getInt("id");
  String name = rs.getString("first_name");
  empList.add(new Employee(id, name));
}
```

## Data Access Objects
When writing JDBC code, the application business logic may get mixed in with JDBC boilerplate code for querying the database, resulting in hard to read spaghetti code. One way to address this problem is to logically separate the code that accesses the database into Data Access Objects - this is referred to as the **DAO design pattern**.

To use the DAO design pattern, define an interface which declares methods through which the database will be queried. Then, concrete implementation classes can implement the interface and contain the data access logic to return the required data.

For example, if we have an Employee table in our database we'd like to query, we would create a `EmployeeDAO` interface:

```java
public interface EmployeeDAO {
  // define some CRUD operations here
  public List<Employee> getAllEmployees();
  public List<Employee> getEmployeesByLocation(String location);
  public void updateEmployeeById(int id);
  public void deleteEmployeeById(int id);
  public void addEmployee(Employee e);
}
```

This interface would be implemented for a specific database - e.g. Oracle:

```java
public class EmployeeDAOImplOracle implements EmployeeDAO {
  public List<Employee> getAllEmployees() {
    List<Employee> list = new ArrayList<>();
    // JDBC code here...
	return list;
  };
  public List<Employee> getEmployeesByLocation(String location) {
    List<Employee> list = new ArrayList<>();
    // JDBC code here...
	return list;
  };
  public void updateEmployeeById(int id) {
    // JDBC code here...
  };
  public void deleteEmployeeById(int id) {
    // JDBC code here...
  };
  public void addEmployee(Employee e) {
    // JDBC code here...
  };
}
```

Now whenever we need to query the Employee table in the database, we have a simple, clean interface which abstracts the data access logic:

```java
EmployeeDAO dao = new EmployeeDAOImplOracle();
List<Employee> allEmpls = dao.getAllEmployees();
allEmpls.forEach( e -> System.out.println(e));

List<Employee> NYEmpls = dao.getEmployeesByLocation("New York");
NYEmpls.forEach( e -> System.out.println(e));
```

Also, we can simply swap out the concrete class `EmployeeDAOImplOracle` for another database-specific class if we need to at some point in the future, since we rely only on the `EmployeeDAO` interface. The implementation doesn't even need to be talking to a database - it could be reading and writing to files for all we know! We don't care **how** the data is being read or written, we just care **what operations** are defined for the object. That is the benefit the DAO design pattern brings to the table.
