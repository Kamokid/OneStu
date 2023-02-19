/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package one.business;


public class StudentBuilder extends PersonBuilder <StudentBuilder> {

   
    private String studentId;
    private String gender;
    private String dateOfBirth;
    private String bloodGroup;
    private String tuitionPaid;
    private int levelId;
    private int sectionId;


    public StudentBuilder() {
    }

    public StudentBuilder setStudentId(String studentId) {
        this.studentId = studentId;
        return this;
    }

    public StudentBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public StudentBuilder setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public StudentBuilder setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
        return this;
    }

    public StudentBuilder setTuitionPaid(String tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
        return this;
    }

    public StudentBuilder setLevelId(int levelId) {
        this.levelId = levelId;
        return this;
    }
    
    public StudentBuilder setSectionId(int sectionId){
        this.sectionId = sectionId;
        return this;
    }

    @Override
    public Student createPerson() {
        return new Student(firstName, lastName, address, postalCode, city, 
                studentId, gender, dateOfBirth, bloodGroup, tuitionPaid, 
                levelId, sectionId);
    }
}