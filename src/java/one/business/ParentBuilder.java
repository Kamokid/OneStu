/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;


public class ParentBuilder extends PersonBuilder <ParentBuilder>{

    private String email;
    private String gender;
    private String mobNumber;
    private String homNumber;
    private String busNumber;

    public ParentBuilder() {
    }

    public ParentBuilder setEmail(String email){
        this.email = email;
        return this;
    }
    
    public ParentBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public ParentBuilder setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
        return this;
    }

    public ParentBuilder setHomNumber(String homNumber) {
        this.homNumber = homNumber;
        return this;
    }

    public ParentBuilder setBusNumber(String busNumber) {
        this.busNumber = busNumber;
        return this;
    }

    @Override
    public Parent createPerson() {
        return new Parent(firstName, lastName, address, postalCode, city, email, gender, mobNumber, homNumber, busNumber);
    }
    
}
