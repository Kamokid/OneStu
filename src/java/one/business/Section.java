/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Section implements Serializable{
    
    private int number;
    private String homRoomTeacher;
   
    
    public Section(){
        this.number = 0;
        this.homRoomTeacher = "";
    }
    
    public Section(int number, String homRoomTeacher){
        this.number = number;
        this.homRoomTeacher = homRoomTeacher;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }

    public String getHomRoomTeacher() {
        return homRoomTeacher;
    }

    public void setHomRoomTeacher(String homRoomTeacher) {
        this.homRoomTeacher = homRoomTeacher;
    }
}
