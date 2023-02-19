/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;


import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Registration implements Serializable{
    
    private String studentId;
    private double grade;
    private int courseId;
    private String remarks;
    
    public Registration(){

        this.studentId = "";
        this.grade = 0;
        this.courseId = 0;
        this.remarks = "";
    }
    
    public Registration( String studentId, 
                double grade, int courseId, String remarks){
   
        this.studentId = studentId;
        this.grade = grade;
        this.courseId = courseId;
        this.remarks = remarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
