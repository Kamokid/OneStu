/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;



public class TeacherBuilder extends PersonBuilder <TeacherBuilder> {

    private String email;
    private String startDate;

    public TeacherBuilder() {
    }

    public TeacherBuilder setEmail(String email){
        this.email = email;
        return this;
    }
    
    public TeacherBuilder setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @Override
    public Teacher createPerson() {
        return new Teacher(firstName, lastName, address, postalCode, city, email, startDate);
    }
    
}