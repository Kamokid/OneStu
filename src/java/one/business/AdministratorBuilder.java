/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;


public class AdministratorBuilder extends PersonBuilder <AdministratorBuilder> {

    private String email;
    private String jobFunction;

    public AdministratorBuilder() {
    }

    public AdministratorBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public AdministratorBuilder setJobFunction(String jobFunction) {
        this.jobFunction = jobFunction;
        return this;
    }

    @Override
    public Administrator createPerson() {
        return new Administrator(firstName, lastName, address, postalCode, city, email, jobFunction);
    }
    
}
