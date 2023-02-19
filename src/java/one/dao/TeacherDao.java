package one.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import one.business.Person;
import one.business.Teacher;
import one.business.TeacherBuilder;

/**
 *
 * @author Programmer
 */
public class TeacherDao {
    /**
     * Function to add and store the new Teacher information. The function 
     * will add the information into both the table tblPersion and tblTeacher. 
     * 
     * @param teacher to be saved
     * @param userName to be saved
     * @return true if added, false otherwise
     */
    public boolean addTeacher(Teacher teacher, String userName) {
        boolean result = false; 
        int personId = 0;
        
        try {
            
            PersonDao dao = new PersonDao();
            
            // Insert Person Data
            if(dao.addPerson(teacher.getPerson())) {
                
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();
                
                //Find personId               
                personId = dao.getPersonId(teacher.getPerson());

                // prepare statement
                String query = "INSERT INTO tblTeacher VALUES(?, ?, ?, ?)";
                // set parameters
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    // set parameters
                    stmt.setString(1, teacher.getEmail());
                    stmt.setDate(2, Date.valueOf(teacher.getStartDate()));
                    stmt.setInt(3, personId);
                    stmt.setString(4, userName);
                    
                    int inserted = stmt.executeUpdate();
                    
                    result = inserted >= 1;
                }
            DBConnection.close();
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result; 
    }
    
    // Function to get Teacher by a given Email
    public Teacher getTeacher(String email) {
        
        Teacher teacher = null; 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT * FROM tblTeacher where Email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, email);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            PersonDao dao = new PersonDao();
            
            // read data if exist
            while(rs.next()) {
                LocalDate date = rs.getDate(2).toLocalDate();
                int personId = rs.getInt(3);
                Person person = dao.getPerson(personId);
                
                teacher = new TeacherBuilder().setFirstName(person.getFirstName())
                        .setLastName(person.getLastName()).setAddress(person.getAddress())
                        .setCity(person.getCity()).setPostalCode(person.getPostalCode())
                        .setEmail(email).setStartDate(date.toString()).createPerson();
            }
            
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return teacher;
    }
    
    /**
     * Function to check that a given email exist in the database. 
     * 
     * @param email to check
     * @return true if exists, otherwise false. 
     */
    public boolean isExist(String email) {
        boolean exist = false; 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT Email FROM tblteacher where Email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // set parameters
            stmt.setString(1, email);
            
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
    
    /**
     * Function to update an existing teacher, Return true if the teacher
     * is updated or false. 
     * 
     * @param teacher to update
     * @return true if updated
     */
    public boolean updateTeacher(Teacher teacher) {
        boolean result = false; 
        int personId = 0;
        
        try {
            
            PersonDao dao = new PersonDao();
            
            //Find personId               
            personId = dao.getPersonId(teacher.getPerson());
            
            // Insert Person Data
            if(dao.updatePerson(teacher.getPerson(), personId)) {
                
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "UPDATE tblteacher SET Email=?, StartDate=?"
                        + "where PersonId=?";
                PreparedStatement stmt = conn.prepareStatement(query);

                // set parameters
                stmt.setString(1, teacher.getEmail());
                stmt.setDate(2, Date.valueOf(teacher.getStartDate()));

                int inserted = stmt.executeUpdate();

                result = inserted >= 1;
            
            stmt.close();
            DBConnection.close();
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result; 
    }
    
    // Get the List of all the teachers
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>(); 
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT * FROM tblTeacher";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            PersonDao dao = new PersonDao();
            
            // read data if exist
            while(rs.next()) {
                String email = rs.getString(1);
                LocalDate date = rs.getDate(2).toLocalDate();
                int personId = rs.getInt(3);
                
                Person person = dao.getPerson(personId);
           
                Teacher teacher = new TeacherBuilder().setFirstName(person.getFirstName())
                        .setLastName(person.getLastName()).setAddress(person.getAddress())
                        .setCity(person.getCity()).setPostalCode(person.getPostalCode())
                        .setEmail(email).setStartDate(date.toString()).createPerson();
                
                teachers.add(teacher);
            }
            
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return teachers;
    }
}
