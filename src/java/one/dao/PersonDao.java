/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import one.business.Person;
import one.business.PersonBuilder;

/**
 *
 * @author Khalil
 */
public class PersonDao {
    
    /**
     * Function to add a Person Record into the database. 
     * 
     * @param person person
     * @return true if added
     */
    public boolean addPerson(Person person) {
        boolean result = false; 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "INSERT INTO tblPerson VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // set parameters
            stmt.setString(1, person.getFirstName());
            stmt.setString(2, person.getLastName());
            stmt.setString(3, person.getAddress());
            stmt.setString(4, person.getCity());
            stmt.setString(5, person.getPostalCode());
            
            int inserted = stmt.executeUpdate();
            
            result = inserted >= 1;
            
            stmt.close();
            DBConnection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result; 
    }
    
     /**
     * Function to update a given person's personal details. 
     * 
     * @param personId
     * @param person
     * @return true if updated, otherwise false 
     */
    public boolean updatePerson(Person person, int personId) {
        boolean result = false; 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
  
            
            // prepare statement
            String query = "UPDATE tblPerson SET FirstName=?, LastName=?, "
                    + "Address=?, City=?, PostalCode=? "
                    + "where PersonId=?";
            // set parameters
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // set parameters
                stmt.setString(1, person.getFirstName());
                stmt.setString(2, person.getLastName());
                stmt.setString(3, person.getAddress());
                stmt.setString(4, person.getCity());
                stmt.setString(5, person.getPostalCode());
                stmt.setInt(6,personId);
                
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
     * Function to load Person from the database identified by Email. 
     * 
     * @param personId of the person
     * @return person object
     */
    public Person getPerson(int personId) {
        Person person = null; 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT * FROM tblPerson where PersonId=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // set parameters
            stmt.setInt(1, personId);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {                
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String postalCode = rs.getString(6);

                
                person = new PersonBuilder().setFirstName(firstName)
                        .setLastName(lastName).setAddress(address).setCity(city)
                        .setPostalCode(postalCode).createPerson();
            }
            stmt.close();
            rs.close();
            conn.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return person; 
    }
    
     /**
     * Function to get PersonId from the database. 
     * 
     * @param person person
     * @return int if found
     */
    public int getPersonId(Person person) {
        int id = 0;
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // statement
            String query = "SELECT PersonId FROM tblPerson WHERE FirstName =?"
                    + "AND LastName=? AND Address=? AND City=? AND PostalCode=?";
            // set parameters
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                
                // set parameters
                stmt.setString(1, person.getFirstName());
                stmt.setString(2, person.getLastName());
                stmt.setString(3, person.getAddress());
                stmt.setString(4, person.getCity());
                stmt.setString(5, person.getPostalCode());
                
                ResultSet rs = stmt.executeQuery();
                
                rs.next();
                
                id = rs.getInt("PersonId");
            }
            DBConnection.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return id; 
    }
}
