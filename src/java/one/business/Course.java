package one.business;
import java.io.Serializable;

/**
 *
 * @author Khalil
 */
public class Course implements Serializable {
    
    private String courseId;
    private String courseName;
    private String teacherEmail;
    
    public Course(){
        this.courseId = "";
        this.courseName = "";
        this.teacherEmail = "";
    }
    
    public Course(String courseId, String courseName, String teacherEmail){
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherEmail = teacherEmail;
    }
    
    public String getCourseId(){
        return courseId;
    }
    
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
}
