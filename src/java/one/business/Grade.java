/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;
import java.math.BigDecimal;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Grade implements Serializable {
    
    private String studentEmail;
    private int level;
    private BigDecimal tuition;
    
    public Grade(){
        this.studentEmail = "";
        this.level = 0;
        this.tuition =  new BigDecimal(0);
    }
    
    public Grade(String studentEmail, int level, String tuition){
        this.studentEmail = studentEmail;
        this.level = level;
        this.tuition = new BigDecimal(tuition);
    }
    
    public int getLevel(){
        return level;
    }
    
    public void setLevel(int level){
        this.level = level;
    } 
    
    public BigDecimal getTuition(){
        return tuition;
    }
    
    public void setTuition(String tuition){
        this.tuition = new BigDecimal(tuition);
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    
    
}
