package one.business;
import java.io.Serializable;

/**
 *
 * @author Khalil
 */
public class Attendance implements Serializable{
    
    private int absentDays;
    private int presentDays;
    
    public Attendance(){

        this.absentDays = 0;
        this.presentDays = 0;
    }
    
    public Attendance(int absentDays, int presentDays){
        this.absentDays = absentDays;
        this.presentDays = presentDays;
    }
    
    public int getAbsentDays(){
        return absentDays;
    }
    
    public void setAbsentDays(int absentDays){
        this.absentDays = absentDays;
    }
    
    public int getPresentDays(){
        return presentDays;
    }
    
    public void setPresentDays(int presentDays){
        this.presentDays = presentDays;
    }

}
