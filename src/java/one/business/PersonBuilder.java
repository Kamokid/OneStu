/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;


public class PersonBuilder <T extends PersonBuilder<T>> {

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String postalCode;
    protected String city;

    public PersonBuilder() {
    }

    public T setFirstName(String firstName) {
        this.firstName = firstName;
        return (T) this;
    }

    public T setLastName(String lastName) {
        this.lastName = lastName;
        return (T) this;
    }

    public T setAddress(String address) {
        this.address = address;
        return (T) this;
    }

    public T setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return (T) this;
    }
    
     public T setCity(String city) {
        this.city = city;
        return (T)this;
    }

    public Person createPerson() {
        return new Person(firstName, lastName, address, postalCode, city);
    }
    
}
