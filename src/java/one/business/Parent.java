package one.business;

import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Parent extends PersonRole implements Serializable{
    
    private String email;
    private String gender;
    private String mobNumber;
    private String homNumber;
    private String busNumber;
    
    public Parent(){
        super();
        this.email = "";
        this.gender = "";
        this.mobNumber = "";
        this.homNumber = "";
        this.busNumber = "";
    }
    
    public Parent(String firstName, String lastName, String address, String postalCode, 
            String city, String email, String gender, String mobNumber, String homNumber, String busNumber){
         super(firstName, lastName, address, postalCode, city);
         this.email = email;
         this.gender = gender;
         this.mobNumber = mobNumber;
         this.homNumber = homNumber;
         this.busNumber = busNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getMobNumber(){
        return mobNumber;
    }
    
    public void setMobNumber(String mobNumber){
        this.mobNumber = mobNumber;
    }
    
    public String getHomNumber(){
        return homNumber;
    }
    
    public void setHomNumber(String homNumber){
        this.homNumber = homNumber;
    }
    
    public String getBusNumber(){
        return busNumber;
    }
    
    public void setBusNumber(String busNumber){
        this.busNumber = busNumber;
    }
}
