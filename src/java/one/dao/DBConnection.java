package one.dao;

import java.sql.*;

/**
 *
 * @author Programmer
 */
public class DBConnection {

    // Database Constants
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASSWORD = "CST2355Database";
    private static final String DBNAME = "studb";

    // Connection handler
    private static Connection connection;

    /**
     * Function to Connect to the Database based on class constant fields
     *
     * @return connection
     */
    public static Connection open() {

        try {
            //Load driver
            Class.forName(DRIVER).newInstance();

            // Create Connection
            connection = DriverManager.getConnection(URL + DBNAME, USER, PASSWORD);
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState:     " + se.getSQLState());
            System.out.println("VendorError:  " + se.getErrorCode());
            se.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    // Simple testing
    public static void main(String[] args) {
        Connection conn = open();
        
        if(conn != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Not connected");
        }
        
        close();
    }

    /**
     * Utility Function to close the database connection
     */
    public static void close() {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState:     " + se.getSQLState());
            System.out.println("VendorError:  " + se.getErrorCode());
            se.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
