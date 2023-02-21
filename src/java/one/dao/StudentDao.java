package one.dao;

import java.sql.*;
import java.time.LocalDate;
import one.business.*;
import one.business.ParentBuilder;
import one.business.StudentBuilder;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Programmer
 */
public class StudentDao {
    
    /**
     * Function to add and store the new Student information. The function 
     * will add the information into both the table tblPersion and tblStudent. 
     * 
     * @param student to be saved
     * @return true if added, false otherwise
     */
    public boolean addStudent(Student student) {
        boolean result = false; 
        int personId = 0;
        try {
            
            PersonDao dao = new PersonDao();
            // Insert Person Data
            if(dao.addPerson(student.getPerson())) {
                
                // Add specific Data
                
                //Find personId               
                personId = dao.getPersonId(student.getPerson());
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "INSERT INTO tblStudent VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    System.out.println("arrived");
                    
                    // set parameters
                    stmt.setString(1, student.getStudentId());
                    stmt.setDate(2, Date.valueOf(student.getdOfBirth()));
                    stmt.setString(3, student.getGender());
                    stmt.setString(4, student.getBloodGroup());
                    stmt.setDouble(5, student.getTuitionPaid().doubleValue());
                    stmt.setInt(6, personId);
                    stmt.setInt(7, student.getLevelId());
                    stmt.setInt(8, student.getSectionId());
                    
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
    
     /**
     * Function to add Parent into the database. 
     * Fill both the tables tblPerson & tblParent
     * 
     * @param parent to be saved
     * @return true if added
     */
    public boolean addParent(Parent parent) {
        boolean result = false; 
        int personId = 0;
        
        
        try {
            
            PersonDao dao = new PersonDao();
            // Insert Person Data
            if(dao.addPerson(parent.getPerson())) {
                
                //Find personId               
                personId = dao.getPersonId(parent.getPerson());
                
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "INSERT INTO tblParent VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);

                // set parameters
                stmt.setString(1, parent.getEmail());
                stmt.setString(2, parent.getGender());
                stmt.setString(3, parent.getMobNumber());
                stmt.setString(4, parent.getHomNumber());
                stmt.setString(5, parent.getBusNumber());
                stmt.setInt(6, personId);

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
    
     /**
     * Function to associate a parent to a student, Return true if the student
     * is updated or false. 
     * 
     * @param studentId 
     * @param email
     * @return true if updated
     */
    public boolean attachToStudent(int studentId, String email) {
        boolean result = false; 

        try {
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "INSERT INTO tblstudent_has_tblparent VALUES(?, ?)";
            // set parameters
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // set parameters
                stmt.setInt(1,studentId);
                stmt.setString(2, email);

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
     * Function to update an existing student, Return true if the student
     * is updated or false. 
     * 
     * @param student to update
     * @return true if updated
     */
    public boolean updateStudent(Student student) {
        boolean result = false; 
        int personId = 0;
        try {
            
            PersonDao dao = new PersonDao();
            //Find personId               
            personId = dao.getPersonId(student.getPerson());
            
            // Insert Person Data
            if(dao.updatePerson(student.getPerson(), personId)) {
                
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "UPDATE tblStudent SET DOB=?, Gender=?, BloodGroup=?,"
                        + "TuitionPaid=?, LevelId=?, SectionId =? where StudentId=? AND Visible = 'true' ";
                PreparedStatement stmt = conn.prepareStatement(query);

                // set parameters
                stmt.setDate(1, Date.valueOf(student.getdOfBirth()));
                stmt.setString(2, student.getGender());
                stmt.setString(3, student.getBloodGroup());
                stmt.setDouble(4, student.getTuitionPaid().doubleValue());
                stmt.setInt(5, student.getLevelId());
                stmt.setInt(6, student.getSectionId());
                stmt.setString(7, student.getStudentId());
                

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
    
     /**
     * Function to delete/hide an existing student, Return true if the student
     * is updated or false. 
     * 
     * @param studentId to update
     * @return true if updated
     */
    public boolean deleteStudent(String studentId) {
        boolean result = false; 
  
        try {
            
                
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "UPDATE tblStudent SET Visible = 'false' where StudentId=? ";
                PreparedStatement stmt = conn.prepareStatement(query);

                // set parameters
                stmt.setString(1, studentId);
                

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
            String query = "SELECT Email FROM tblparent where Email=?";
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
     * Function to compute the next Student Id and return it. 
     * 
     * @return new student id 
     */
    public String getStudentId() {
        
        String studentId = ""; 
        int max = 0;
        
        try {
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT StudentId FROM tblStudent ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                int id = Integer.parseInt(rs.getString(1));
                
                if(id > max) {
                    max = id; 
                }
            }
            
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
       
        if(max == 0) {
            studentId = "121234";
        } else {
            studentId = String.valueOf(max + 1);
        }
        
        return studentId; 
    }
    
    // Function to get Student by given Id
    public Student getStudent(String studentId) {
        
        Student student = null; 
        
        try {
            
            PersonDao dao = new PersonDao();
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT * FROM tblStudent where StudentId=? AND Visible = 'true' ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, studentId);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                
                LocalDate date = rs.getDate(2).toLocalDate();
                String gender = rs.getString(3);
                String bloodGroup = rs.getString(4);
                String tuitionPaid = Double.toString(rs.getDouble(5));
                int personId = rs.getInt(6);
                int levelId = rs.getInt(7);
                int sectionId = rs.getInt(8);
                
                
                Person person = dao.getPerson(personId);
                
                student = new StudentBuilder().setFirstName(person.getFirstName())
                        .setLastName(person.getLastName()).setAddress(person.getAddress())
                        .setCity(person.getCity()).setPostalCode(person.getPostalCode())
                        .setStudentId(studentId).setGender(gender).setDateOfBirth(date.toString())
                        .setBloodGroup(bloodGroup).setTuitionPaid(tuitionPaid)
                        .setLevelId(levelId).setSectionId(sectionId).createPerson();
            }
            
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return student;
    }
    
    /**
     * Function to fetch the Parent from the Database. 
     * 
     * @param studentId to fetch the parent
     * @return parent data read from file
     */
    public List<Parent> getParent(String studentId) {
        List<Parent> parents = new ArrayList<>(); 
        Parent parent = null; 
        
        try {
            
            PersonDao dao = new PersonDao();
            
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT tblperson.*, tblparent.* FROM tblstudent "
                    + "INNER JOIN tblstudent_has_tblparent USING(StudentId) "
                    + "INNER JOIN tblparent USING(Email) "
                    + "INNER JOIN tblperson ON tblparent.PersonId = tblperson.PersonId "
                    + "WHERE StudentId = ? AND tblstudent.Visible = 'true' ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, studentId);
            
            
            System.out.println("Her13");
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String postalCode = rs.getString(6);
                String email = rs.getString(7);
                String gender = rs.getString(8);
                String mobileNumber = rs.getString(9);
                String homeNumber = rs.getString(10);
                String businessNumber = rs.getString(11);

                
                parent = new ParentBuilder().setFirstName(firstName)
                        .setLastName(lastName).setAddress(address)
                        .setCity(city).setPostalCode(postalCode).setEmail(email)
                        .setGender(gender).setMobNumber(mobileNumber)
                        .setHomNumber(homeNumber).setBusNumber(businessNumber).createPerson();
                
                parents.add(parent);
            }
            
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return parents; 
    }
   
}
