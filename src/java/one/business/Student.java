package one.business;


import java.time.LocalDate;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 *
 * @author Khalil
 */
public class Student extends PersonRole implements Serializable {
    
    private String studentId;
    private String gender;
//    private String dateOfBirth;
    private LocalDate dOfBirth;
    private String bloodGroup;
    private BigDecimal tuitionPaid;
    private int levelId;
    private int sectionId;

    
    public Student(){
        this.studentId = "";
        this.gender = "";
        dOfBirth = LocalDate.now();
        this.bloodGroup = "";
        this.tuitionPaid = new BigDecimal(0);
        this.levelId = 0;
        this.sectionId = 0;

    }
     
     public Student(String firstName, String lastName, String address, String postalCode,
             String city, String studentId, String gender, String dateOfBirth, String bloodGroup, 
             String tuitionPaid, int levelId, int sectionId){
        super(firstName, lastName, address, postalCode, city);
        this.studentId = studentId;
        this.gender = gender;
        dOfBirth = LocalDate.parse(dateOfBirth);
        this.bloodGroup = bloodGroup;
        this.tuitionPaid = new BigDecimal(tuitionPaid);
        this.levelId = levelId;
        this.sectionId = sectionId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public LocalDate getdOfBirth() {
        return dOfBirth;
    }

    public void setdOfBirth(LocalDate dOfBirth) {
        this.dOfBirth = dOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BigDecimal getTuitionPaid() {
        return tuitionPaid;
    }

    public void setTuitionPaid(String tuitionPaid) {
        this.tuitionPaid = new BigDecimal(tuitionPaid);
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
    

    public String toString(){
        return String.format("%s %n%s: %s %n%s: %s %n%s: %s %n%s: %s "
                + "%n%s: %s", 
                super.toString(),
                "Student ID", studentId,
        "Gender", gender, "Date of Birth", dOfBirth,
        "Blood Group", bloodGroup, 
        "Tuition Paid", tuitionPaid);
    }
}
