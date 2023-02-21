/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import one.business.Attendance;
import one.business.Registration;
import java.util.ArrayList;
import java.util.List;
import one.business.Parent;
/**
 *
 * @author Khalil
 */
public class UtilityDao {
    
    // Function to get attendance by given Id
    public Attendance getAttendance(String studentId) {
                
        Attendance student = null;
        try {
                       
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT AbsentDays, PresentDays FROM tblattendance where StudentId=? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, studentId);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                
                int absentDays = rs.getInt(1);
                int presentDays = rs.getInt(2);
                
                student = new Attendance();
                student.setAbsentDays(absentDays);
                student.setPresentDays(presentDays);
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return student;
    }
    
    // Function to get registration by studentID & courseId
    public Registration getRegistration(String studentId, int courseId) {
                
        Registration student = new Registration();
        try {
                       
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT Remarks, Grade FROM tblregistration "
                    + "where StudentId=? AND CourseId=? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, studentId);
            stmt.setInt(2, courseId);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                
                
                String remarks = rs.getString(1);
                double grade = rs.getDouble(2);
                

                student.setStudentId(studentId);
                student.setGrade(grade);
                student.setRemarks(remarks);
                student.setCourseId(courseId);
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
     * Function to update an existing attendance record, Return true if the 
     * update is successful or false if not. 
     * 
     * @param attendance to update
     * @param studentId to find entry
     * @return true if updated
     */
    public boolean updateAttendance(Attendance attendance, String studentId) {
        boolean result = false; 

        try {
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "UPDATE tblattendance SET AbsentDays=?, PresentDays=?"
                        + " where StudentId=?";
                PreparedStatement stmt = conn.prepareStatement(query);

                // set parameters
                stmt.setInt(1, attendance.getAbsentDays());
                stmt.setInt(2, attendance.getPresentDays());
                stmt.setString(3, studentId);
                

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
     * Function to update an existing registration, Return true if the 
     * update is successful or false if not. 
     * 
     * @param studentId to find entry
     * @param courseId to find entry
     * @param grade to be updated
     * @return true if updated
     */
    public boolean updateRegistration(String studentId, int courseId, double grade) {
        boolean result = false; 

        try {
                // Add specific Data
                
                // get connection
                Connection conn = DBConnection.open();

                // prepare statement
                String query = "UPDATE tblregistration SET Grade=? "
                        + " where StudentId=? AND CourseId=? ";
                PreparedStatement stmt = conn.prepareStatement(query);

                // set parameters
                stmt.setDouble(1, grade);
                stmt.setString(2, studentId);
                stmt.setInt(3, courseId);
                

                int inserted = stmt.executeUpdate();

                result = inserted >= 1;
            
            stmt.close();
            DBConnection.close();
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result; 
    }
    
    
    // Function to get attendance by given Id
    public List<Registration> getRegistration(String studentId) {
        List<Registration> reg = new ArrayList<>(); 
        
        try {
                       
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT CourseId, Grade, Remarks "
                    + " FROM tblregistration where StudentId=? ORDER BY CourseId";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, studentId);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                
                int courseId = rs.getInt(1);
                double grade = rs.getDouble(2);
                String remarks = rs.getString(3);
                
                Registration registration = new Registration();
                registration.setStudentId(studentId);
                registration.setCourseId(courseId);
                registration.setGrade(grade);
                registration.setRemarks(remarks);

                 reg.add(registration);
     
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
       
        
        return reg;
    }
    
}
