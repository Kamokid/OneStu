package one.business;
import java.time.LocalDate;
import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Teacher extends PersonRole implements Serializable {
    
    private String email;
    private String startDate;
    private LocalDate sDate;
   
    public Teacher(){
        super();
        this.email = "";
        this.startDate = "";
    }
    
    public Teacher(String firstName, String lastName, String address, String postalCode,
            String city, String email, String startDate){
         super(firstName, lastName, address, postalCode, city);
         this.email = email;
         this.startDate = startDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getStartDate(){
        return startDate;
    }
    
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
}
