package one.business;

/**
 *
 * @author Khalil
 */
public abstract class PersonRole extends Person{
    
    private Person person;
    
    public PersonRole(){
        person = new Person();
    }
    
    public PersonRole(String firstName, String lastName, String address, 
            String postalCode, String city){
        person = new PersonBuilder().setFirstName(firstName).setLastName(lastName)
                .setAddress(address).setPostalCode(postalCode).setCity(city).createPerson();
    }
    
    public Person getPerson(){
        return person;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
    
    
    public String toString(){
        return String.format("%s",person.toString());
    }
    
    
}
