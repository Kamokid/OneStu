package one.business;
import java.time.LocalDate;
import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Teacher extends PersonRole implements Serializable {
    
    private String email;
    private LocalDate sDate;
   
    public Teacher(){
        super();
        this.email = "";
        sDate = LocalDate.now();
    }
    
    public Teacher(String firstName, String lastName, String address, String postalCode,
            String city, String email, String startDate){
         super(firstName, lastName, address, postalCode, city);
         this.email = email;
         sDate = LocalDate.parse(startDate);
         
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getStartDate(){
        return sDate;
    }
    
    public void setStartDate(LocalDate startDate){
        this.sDate = startDate;
    }
    
}
