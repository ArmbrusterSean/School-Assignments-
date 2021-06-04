// Needed for JDBC classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This program creates the CoffeeDB database.
 */
public class CreateCoffeeDBstudent {
	public static void main(String[] args)
	{
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:derby:CoffeeStudentDB;create=true";

		try
		{
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// If the DB already exists, drop the tables.
			dropTables(conn);

			// Build the Coffee table and insert records.
			buildCoffeeTable(conn);

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
	 * The buildCoffeeTable method creates the
	 * Coffee table and adds some rows to it.
	 */
	public static void buildCoffeeTable(Connection conn)
	{
		try
		{
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// Create the table.
			stmt.execute( "CREATE TABLE Coffee (Description CHAR(25), ProdNum CHAR(10) NOT NULL PRIMARY KEY, Price DOUBLE)" );

			// Insert row #1.
			stmt.execute(  "INSERT INTO Coffee VALUES ('Bolivian Dark', '14-001', 8.95 )"   );

			// Insert row #2.
			stmt.execute(  "INSERT INTO Coffee VALUES ( 'Bolivian Medium', '14-002', 8.95 )"   );

			// Insert row #3.
			stmt.execute(  "INSERT INTO Coffee VALUES ( 'Brazilian Dark', '15-001', 7.95 )"    );


			System.out.println("Coffee table created.");
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
			Statement stmt  = conn.createStatement();;

			try
			{
				// Drop the Coffee table.
				stmt.execute("DROP TABLE Coffee");
				System.out.println("Coffee table dropped.");
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
