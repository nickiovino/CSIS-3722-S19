package javaapplication4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaApplication4
{
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test.db";
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        // Set up and connect to our database.
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, "user", "password");

        // Execute some queries to create the table and insert data
        Statement stmt = conn.createStatement();
        stmt.execute(
                "CREATE TABLE IF NOT EXISTS users "
                + "( "
                + "  id IDENTITY, "
                + "  first_name VARCHAR(255), "
                + "  last_name VARCHAR(255)"
                + ");");
        stmt.execute(
                "INSERT INTO users (first_name, last_name)"
                        + "VALUES('Nick', 'Iovino');");
        
        // Get some data back and hold it in a ResultSet
        ResultSet rs = stmt.executeQuery("SELECT * FROM users;");
        
        // Iterate over the rows in the ResultSet.
        while(rs.next())
        {
            // Get the user's ID as an integer
            int id = rs.getInt("id");
            
            // Get the user's first name
            String first_name = rs.getString("first_name");
            
            // Print them out
            System.out.println(id);
            System.out.println(first_name);
        }
        
        // Close our result set.  Important to free up system resources!
        rs.close();
        
        // Clean up and disconnect.
        stmt.close();
        conn.close();
    }
}
