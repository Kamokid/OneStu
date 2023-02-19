package one.business;

import java.io.Serializable;

/**
 *
 * @author Khalil
 */
public class Person implements Serializable {
    

    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;

    
    public Person (){
        firstName = "";
        lastName = "";
        address = "";
        postalCode = "";
        city = "";
    }

    public Person (String firstName, String lastName, String address, String postalCode, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

      
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName (String lastName){
        this.lastName = lastName;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
            this.address = address;
    }
    
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String getCity() {
        return city;
    }
   
    public void setCity(String city) {
        this.city = city;
    } 
    
    
    @Override
    public String toString(){
        return String.format("%s: %s %n%s: %s %n%s: %s",
                "First Name", firstName,
        "Last Name", lastName, "Address", address);
    }

}