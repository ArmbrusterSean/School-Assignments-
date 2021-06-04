/* 
 * Sean Armbruster 
 * CSC 251 420
 * Data Manipulation Homework
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class employeeDataViewer {

	public static void main(String[] args) {
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:derby:DTEMPLOYEES;create=true";

		try
		{
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// view data
			viewEmployeeTable(conn);
			
			// modify record
			modEmployeeTable(conn);
			
			viewEmployeeTable(conn);
			
			// Close the connection.
			conn.close();

		}
		catch (Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}


	}  // end main



	public static void viewEmployeeTable(Connection conn)
	{
		//create var for result set
		ResultSet resultset = null;

		try
		{
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// View the table.
			resultset = stmt.executeQuery("SELECT * FROM Employee");

			// process results
			ResultSetMetaData metaData = resultset.getMetaData();
			
			System.out.println("Data from Employee Table:");

			int numberOfColumns = metaData.getColumnCount();
			// for loop to field names
			for (int i = 1; i <= numberOfColumns; i++){
				System.out.printf("%s\t", metaData.getColumnName(i));
			}
			System.out.println();
			
			// while loop to display data
			while (resultset.next()){
				for (int i = 1; i <= numberOfColumns; i++){
					System.out.printf("%s\t", resultset.getObject(i));
				}
				System.out.println();
			}

		}
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
	}	


	public static void modEmployeeTable(Connection conn)
	{
		//create var for result set
		ResultSet resultset = null;

		try
		{
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// update record
			stmt.executeUpdate("UPDATE Employee SET Department = 'Security' WHERE Emp_ID = '980191919'");
			stmt.executeUpdate("UPDATE Employee SET FirstName = 'Ellis', HourlyWage = 30.00 WHERE Emp_ID = '807223230'");
			stmt.executeUpdate("DELETE FROM Employee WHERE Emp_ID = '899090111'");

			System.out.println("Record updated");

		}
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
	}	
	

}  // end class
