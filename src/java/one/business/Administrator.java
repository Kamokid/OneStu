package one.business;
import java.io.Serializable;
/**
 *
 * @author Khalil
 */
public class Administrator extends PersonRole implements Serializable {
    
    private String email;
    private String jobFunction;
   
    public Administrator(){
        super();
        this.email = "";
        this.jobFunction = "";
    }
    
    public Administrator(String firstName, String lastName, String address, String postalCode,
            String city, String email, String jobFunction){
         super(firstName, lastName, address, postalCode, city);
         this.email = email;
         this.jobFunction = jobFunction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getJobFunction(){
        return jobFunction;
    }
    
    public void setJobFunction(String jobFunction){
        this.jobFunction = jobFunction;
    }    
}
