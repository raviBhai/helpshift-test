Steps to run:
Open terminal
Navigate to <your-dir-path>/sqlServer
Run: mvn clean install

To run the server:
Open a new terminal window
Navigate to <your-dir-path>/sqlServer/target
Run: java -cp sqlserver-1.0-SNAPSHOT.jar com.sqlServer.Server

To run the client:
Open a new terminal window
Navigate to <your-dir-path>/sqlServer/target
Run: java -cp sqlserver-1.0-SNAPSHOT.jar com.sqlServer.Client


Functionalities covered in this task:
Query Syntax validation
Query Data validation

Pending behaviours:
Load data, filter data and return result.

Flow:

Server.java calls SqlServer.getResultSetFromQuery()
It then calls SyntaxValidator.validateSyntax() to validate query syntax.
If valid syntax, then we populate the query in a pojo.
Done using QueryBuilder.buildBean();
Then validate the data passed through the query. This checks for correct columns names and table names.
Done using QueryDataValidator.validate();
Finally, execute the query using QueryExecutor.executeQuery();
