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
    
    // Function to get attendance by given Id
    public List<Registration> getRegistration(String studentId) {
        List<Registration> reg = new ArrayList<>(); 
        Registration registration = new Registration();
        try {
                       
            // get connection
            Connection conn = DBConnection.open();
            
            // prepare statement
            String query = "SELECT CourseId, Grade, Remarks "
                    + " FROM tblregistration where StudentId=? ";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, studentId);
            
            // Get result set
            ResultSet rs = stmt.executeQuery();
            
            // read data if exist
            while(rs.next()) {
                
                int courseId = rs.getInt(1);
                double grade = rs.getDouble(2);
                String remarks = rs.getString(3);
                
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
