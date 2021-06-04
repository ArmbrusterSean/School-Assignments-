/* 
 * Sean Armbruster 
 * CSC 251 420
 * Data Manipulation Homework
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This program creates the DEMPLOYEE database.
 */
public class employeeData {
	public static void main(String[] args)
	{
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:derby:DTEMPLOYEES;create=true";

		try
		{
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// If the DB already exists, drop the tables.
			dropTables(conn);

			// Build the Employee table and insert records.
			BuildEmployeeTable(conn);

			// Close the connection.
			conn.close();
			
			System.out.println("DB creation success!");
		}
		catch (Exception ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
	} // end main
	
	/**
	 * The Employee method creates the
	 * Employee table and adds some rows to it.
	 */
	public static void BuildEmployeeTable(Connection conn)
	{
		try
		{
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// Create the table.
			stmt.execute(   "CREATE TABLE Employee (Emp_ID CHAR(10) NOT NULL PRIMARY KEY, LastName CHAR(20), FirstName CHAR(15), Department CHAR(25), HourlyWage DOUBLE)"   );

			// Insert row #1.
			stmt.execute(  "INSERT INTO Employee VALUES ('899090111', 'Rothlisberger', 'Ben', 'IT', 35.90 )"   );

			// Insert row #2.
			stmt.execute(  "INSERT INTO Employee VALUES ('129020202', 'Manning', 'Peyton', 'English', 45.85 )"   );

			// Insert row #3.
			stmt.execute(  "INSERT INTO Employee VALUES ('890101030', 'Brady', 'Tom', 'Accounting', 28.65 )"    );
			
			//Insert row #4
			stmt.execute(  "INSERT INTO Employee VALUES ('980191919', 'Rodgers', 'Aaron', 'Networking', 56.00 )"    );
			
			//Insert row #5
			stmt.execute(  "INSERT INTO Employee VALUES ('807223230', 'Manning ', 'Eli', 'Securities', 28.61 )"   );
			


			System.out.println("Employee table created.");
		}
		catch (SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
		}
	} // end build
	
	
	/**
	 * The dropTables method drops any existing
	 * in case the database already exists.
	 */
	public static void dropTables(Connection conn)
	{
		System.out.println("Checking for existing table.");

		try
		{
			// Get a Statement object.
			Statement stmt  = conn.createStatement();

			try
			{
				// Drop the Coffee table.
				stmt.execute("DROP TABLE Employee");
				System.out.println("Employee table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
		}
		catch(SQLException ex)
		{
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	} // end drop tables
	
}  // end class