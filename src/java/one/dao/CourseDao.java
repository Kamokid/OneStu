package one.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import one.business.Course;
import one.business.Person;
import one.business.Teacher;

/**
 *
 * @author Programmer
 */
public class CourseDao {

    /**
     * Function to add new course to database.
     *
     * @param course
     * @return true if added, false otherwise
     */
    public boolean addCourse(Course course) {
        boolean result = false;

        try {

            // Add specific Data
            // get connection
            Connection conn = DBConnection.open();

            // prepare statement
            String query = "INSERT INTO tblCourse VALUES(?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            // set parameters
            stmt.setString(1, course.getCourseId());
            stmt.setString(2, course.getCourseName());
            stmt.setString(3, course.getTeacherEmail());

            int inserted = stmt.executeUpdate();

            result = inserted >= 1;

            stmt.close();
            DBConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Function to get Course by a given courseId
    public Course getCourse(String courseId) {

        Course teacher = null;

        try {

            // get connection
            Connection conn = DBConnection.open();

            // prepare statement
            String query = "SELECT * FROM tblCourse where CourseId=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, courseId);

            // Get result set
            ResultSet rs = stmt.executeQuery();

            StudentDao dao = new StudentDao();

            // read data if exist
            while (rs.next()) {
                String courseName = rs.getString(2);
                String email = rs.getString(3);
                teacher = new Course(courseId, courseName, email);
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return teacher;
    }

    /**
     * Function to update an existing course, Return true if the course is
     * updated or false.
     *
     * @param course to update
     * @return true if updated
     */
    public boolean updateCourse(Course course) {
        boolean result = false;

        try {
            // get connection
            Connection conn = DBConnection.open();

            // prepare statement
            String query = "UPDATE tblCourse SET CourseName=?, TeacherEmail=? where CourseId=?";
            PreparedStatement stmt = conn.prepareStatement(query);

            // set parameters
            stmt.setString(3, course.getCourseId());
            stmt.setString(1, course.getCourseName());
            stmt.setString(2, course.getTeacherEmail());
            

            int inserted = stmt.executeUpdate();

            result = inserted >= 1;

            stmt.close();
            DBConnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Function to compute the next Student Id and return it.
     *
     * @return new student id
     */
    public String getCourseId() {

        String courseId = "";
        int max = 0;

        try {

            // get connection
            Connection conn = DBConnection.open();

            // prepare statement
            String query = "SELECT count(*) as num FROM tblCourse";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Get result set
            ResultSet rs = stmt.executeQuery();

            int count = 0;

            // read data if exist
            while (rs.next()) {
                max = Integer.parseInt(rs.getString(1));
            }

            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        courseId = "CRS" + (100 + max);

        return courseId;
    }
}
