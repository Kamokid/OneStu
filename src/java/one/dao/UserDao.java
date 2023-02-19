/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import one.business.User;
/**
 *
 * @author Khalil
 */
public class UserDao {
    
    /**
     * Function to add a user to the database. The function 
     * will add the information into both the userpass table. 
     * 
     * @param user to be saved
     * @return true if added, false otherwise
     */
    public boolean addUser(User user) {
        boolean result = false; 
        boolean role = false;
        
        try {
                         
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();
                

                // prepare statement
                String query = "INSERT INTO userpass VALUES(?, ?)";
                // set parameters
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    // set parameters
                    stmt.setString(1, user.getUserName());
                    stmt.setString(2, user.getPassword());
                    
                    int inserted = stmt.executeUpdate();
                    
                    result = inserted >= 1;
                }
                
            role = addRole(user.getUserName(), "teacher");
            DBConnection.close();
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result; 
    }
    
    
     /**
     * Function to add a user and role to the database. The function 
     * will add the information into both the userrole table. 
     * 
     * @param userName to be saved
     * @param role to be saved
     * @return true if added, false otherwise
     */
    public boolean addRole(String userName, String role) {
        boolean result = false; 
        
        try {
                         
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();
                

                // prepare statement
                String query = "INSERT INTO userrole VALUES(?, ?)";
                // set parameters
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    // set parameters
                    stmt.setString(1, role);
                    stmt.setString(2, userName);
                    
                    int inserted = stmt.executeUpdate();
                    
                    result = inserted >= 1;
                }
            DBConnection.close();
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result; 
    }
    
     /**
     * Function to check that a given username exists in the database. 
     * 
     * @param userName to check
     * @return true if exists, otherwise false. 
     */
    public boolean isExist(String userName) {
        boolean exist = false; 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT userName FROM userpass where username=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // set parameters
            stmt.setString(1, userName);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                exist = true; 
            }
            stmt.close();
            rs.close();
            conn.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return exist; 
    }
    
}
