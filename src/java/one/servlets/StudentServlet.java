package one.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import one.business.Parent;
import one.business.ParentBuilder;
import one.business.Student;
import one.business.StudentBuilder;
import one.business.Attendance;
import one.business.Registration;
import one.business.Fees;
import one.dao.StudentDao;
import one.dao.UtilityDao;

/**
 *
 * @author Programmer
 */
public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        String requestURI = request.getRequestURI();
//        String url = "/admin";
//        if (requestURI.endsWith("/saveStudent")) {
//            url = saveStudent(request, response);
//        } else if (requestURI.endsWith("/displayInvoices")) {
//            url = displayInvoices(request, response);
//        } else if (requestURI.endsWith("/displayInvoices")) {
//            url = displayInvoices(request, response);
//        } else if (requestURI.endsWith("/displayInvoices")) {
//            url = displayInvoices(request, response);
//        } 
//
//        getServletContext()
//                .getRequestDispatcher(url)
//                .forward(request, response);
//        
        
        String type = request.getParameter("type");

        if (type.equalsIgnoreCase("add-parent")) {
            saveParent(request, response);
        } else if (type.equalsIgnoreCase("add-student")) {
            saveStudent(request, response);
        } else if (type.equalsIgnoreCase("get-student")) {
            loadStudent(request, response, type);
            System.out.println("Looking for load");
        } else if (type.equalsIgnoreCase("get-student-edit")) {
            loadStudent(request, response, type);
        } else if (type.equalsIgnoreCase("get-student-delete")) {
            loadStudent(request, response, type);
        } else if(type.equalsIgnoreCase("update-student")) {
            updateStudent(request, response);
        } else if(type.equalsIgnoreCase("update-attendance")) {
            updateAttendance(request, response);
        } else if(type.equalsIgnoreCase("update-grade")) {
            updatePerformance(request, response);
        } else if(type.equalsIgnoreCase("update-fees")) {
            updateFees(request, response);
        } else if(type.equalsIgnoreCase("delete-student")) {
            deleteStudent(request, response);
        }            
        
        
        
    }

    // Save Student Data
    private void saveStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        String studentId = request.getParameter("studentId");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String bloodGroup = request.getParameter("bloodGroup");
        String tuitionPaid = request.getParameter("tuitionPaid");
        int levelId = Integer.parseInt(request.getParameter("levelId"));
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        System.out.println("Date of Birth: " + dob);


        Student student = new StudentBuilder().setFirstName(firstName).setLastName(lastName).setAddress(address)
                .setCity(city).setPostalCode(postalCode)
                .setStudentId(studentId).setGender(gender).setDateOfBirth(dob)
                .setBloodGroup(bloodGroup).setTuitionPaid(tuitionPaid)
                .setLevelId(levelId).setSectionId(sectionId)
                .createPerson();
        StudentDao dao = new StudentDao();

        HttpSession session = request.getSession(true);


        // add student
        if (dao.addStudent(student)) {
            session.setAttribute("msg", "Student Data has been saved to database");
            session.setAttribute("studentId", studentId);
            request.getRequestDispatcher("admin/add-parent.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Student data is not saved into database");
            request.getRequestDispatcher("admin/add-student.jsp").forward(request, response);
        }
    }

    // Load Student data and both the parents
    private void loadStudent(HttpServletRequest request, HttpServletResponse response,
            String type)
            throws ServletException, IOException {

        String role = request.getParameter("role");
        String studentId = request.getParameter("studentId");

        // Get Student Data
        StudentDao dao = new StudentDao();

        HttpSession session = request.getSession(true);

        Student student = dao.getStudent(studentId);

        System.out.println("Looking for load2");
        if (student == null) {
            session.setAttribute("msg", "Student with given ID: " + studentId + " doesn't exist");
            if (type.equalsIgnoreCase("get-student")) {
                request.getRequestDispatcher("admin/student.jsp").forward(request, response);
            } else if (type.equalsIgnoreCase("get-student-edit")) {
                request.getRequestDispatcher("admin/manage-student.jsp").forward(request, response);
            }
        }

//        System.out.println("Her1");
        List<Parent> parents = dao.getParent(studentId);
        Parent one = null;
        Parent two = null;
//        System.out.println("Her12");
        
        
        if(!parents.isEmpty()){
           
            if (parents.size() == 1){
                one = parents.get(0);
                session.setAttribute("parentOne", one);
            } else if (parents.size() == 2)
            {
                one = parents.get(0);
                two = parents.get(1);
                session.setAttribute("parentOne", one);
                session.setAttribute("parentTwo", two);
            }
  
        }
        
        UtilityDao utd = new UtilityDao();
        Attendance attendance = utd.getAttendance(studentId);
        Fees fees = utd.getFee(studentId);
        
        
        List<Registration> registration = utd.getRegistration(studentId);
        Registration r1 = null;
        Registration r2 = null;
        Registration r3 = null;
        Registration r4 = null;

         if(!registration.isEmpty()){
            r1 = registration.get(0);
            r2 = registration.get(1);
            r3 = registration.get(2);
            r4 = registration.get(3);
         
        session.setAttribute("student", student);
//        session.setAttribute("parentOne", one);
//        session.setAttribute("parentTwo", two);
        session.setAttribute("fees",fees);
        session.setAttribute("attendance", attendance);
        session.setAttribute("r1", r1);
        session.setAttribute("r2", r2);
        session.setAttribute("r3", r3);
        session.setAttribute("r4", r4);
        
        
        System.out.println("Looking for load3");
        if (type.equalsIgnoreCase("get-student")) {
            session.removeAttribute("msg");
             if (role.equalsIgnoreCase("admin")){
                   request.getRequestDispatcher("admin/personal-info.jsp").forward(request, response);
             }else{
                   request.getRequestDispatcher("teacher/personal-info.jsp").forward(request, response);
             }
        } else if (type.equalsIgnoreCase("get-student-edit")) {
            session.removeAttribute("msg");
            request.getRequestDispatcher("admin/update-student.jsp").forward(request, response);
        } else if (type.equalsIgnoreCase("get-student-delete")) {
            session.removeAttribute("msg");
            request.getRequestDispatcher("admin/delete-student.jsp").forward(request, response);
        }

    }
         
    }
    // Update Student 
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        String studentId = request.getParameter("studentId");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String bloodGroup = request.getParameter("bloodGroup");
        String tuitionPaid = request.getParameter("tuitionPaid");
        int levelId = Integer.parseInt(request.getParameter("levelId"));
        int sectionId = Integer.parseInt(request.getParameter("sectionId"));
        
        
        Student student = new StudentBuilder().setFirstName(firstName).setLastName(lastName).setAddress(address)
                .setCity(city).setPostalCode(postalCode)
                .setStudentId(studentId).setGender(gender).setDateOfBirth(dob)
                .setBloodGroup(bloodGroup).setTuitionPaid(tuitionPaid)
                .setLevelId(levelId).setSectionId(sectionId)
                .createPerson();
      
        StudentDao dao = new StudentDao();
        
        HttpSession session = request.getSession(true);     
        
        // update student
        if (dao.updateStudent(student)) {
            student = dao.getStudent(studentId);
            session.removeAttribute("student");
            session.setAttribute("student", student);
            session.setAttribute("msg", "Student Data has been updated in the database");
            request.getRequestDispatcher("admin/update-student.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Student data is not been updated in the database");
            request.getRequestDispatcher("admin/update-student.jsp").forward(request, response);
        }
    }
    
    // Delete Student 
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        HttpSession session = request.getSession(true);    
        
        Student student = (Student) session.getAttribute("student");
        
        String studentId = student.getStudentId();
        
        StudentDao dao = new StudentDao();
        // delete student
        if (dao.deleteStudent(studentId)) {
            session.removeAttribute("student");
            session.setAttribute("msg", "Student Data has been deleted from the database");
            request.getRequestDispatcher("admin/delete-student.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Student Data has not been deleted from the database");
            request.getRequestDispatcher("admin/delete-student.jsp").forward(request, response);
        }
    }
    
     // Update Attendance 
    private void updateAttendance(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int presentDays = Integer.parseInt(request.getParameter("daysPresent"));
        int absentDays = Integer.parseInt(request.getParameter("daysAbsent"));     
        
        Attendance attendance = new Attendance(absentDays, presentDays);
        
        HttpSession session = request.getSession(true);
        
        Student student = (Student) session.getAttribute("student");
        
        String studentId = student.getStudentId();
        
        UtilityDao dao = new UtilityDao();
        
        // update attendance
        if (dao.updateAttendance(attendance, studentId)) {
            attendance = dao.getAttendance(studentId);
            session.removeAttribute("attendance");
            session.setAttribute("attendance", attendance);
            session.setAttribute("msg", "Student Data has been updated in the database");
            request.getRequestDispatcher("admin/update-attendance.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Student data is not been updated in the database");
            request.getRequestDispatcher("admin/update-attendance.jsp").forward(request, response);
        }
    }
    
    // Update Performance
    private void updatePerformance(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double science = Double.parseDouble(request.getParameter("science"));
        double math = Double.parseDouble(request.getParameter("math"));    
        double english = Double.parseDouble(request.getParameter("english"));
        double socialStudies = Double.parseDouble(request.getParameter("socialStudies"));
        
       
        HttpSession session = request.getSession(true);
        
        Registration r1 = (Registration) session.getAttribute("r1");
        Registration r2 = (Registration) session.getAttribute("r2");
        Registration r3 = (Registration) session.getAttribute("r3");
        Registration r4 = (Registration) session.getAttribute("r4");
        
        
        UtilityDao dao = new UtilityDao();
        
        // Update Registration
        if(science != r1.getGrade()){   
                if (dao.updateRegistration(r1.getStudentId(), r1.getCourseId(), science)) {
                    r1 = dao.getRegistration(r1.getStudentId(),r1.getCourseId());
                    session.removeAttribute("r1");
                    session.setAttribute("r1", r1);
                    request.setAttribute("msg1", "Science grade has been updated in the database");
//                    request.getRequestDispatcher("admin/update-attendance.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg1", "Science grade has not been updated in the database");
//                    request.getRequestDispatcher("admin/update-attendance.jsp").forward(request, response);
                }
        }
          
        if(math != r2.getGrade()){   
                if (dao.updateRegistration(r2.getStudentId(), r2.getCourseId(), math)) {
                    r2 = dao.getRegistration(r2.getStudentId(),r2.getCourseId());
                    session.removeAttribute("r2");
                    session.setAttribute("r2", r2);
                    request.setAttribute("msg2", "Math grade has been updated in the database");
//                    request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg2", "Math grade has not been updated in the database");
//                    request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
                }
        }
        
          if(english != r3.getGrade()){   
                if (dao.updateRegistration(r3.getStudentId(), r3.getCourseId(), english)) {
                    r3 = dao.getRegistration(r3.getStudentId(),r3.getCourseId());
                    session.removeAttribute("r3");
                    session.setAttribute("r3", r3);
                    request.setAttribute("msg3", "English grade has been updated in the database");
//                    request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg3", "English grade has not been updated in the database");
//                    request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
                }
        }
        
        if(socialStudies != r4.getGrade()){   
                if (dao.updateRegistration(r4.getStudentId(), r4.getCourseId(), socialStudies)) {
                    r4 = dao.getRegistration(r4.getStudentId(),r4.getCourseId());
                    session.removeAttribute("r4");
                    session.setAttribute("r4", r4);
                    request.setAttribute("msg4", "Social Studies grade has been updated in the database");
//                    request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
                } else {
                    request.setAttribute("msg4", "Social Studies grade has not been updated in the database");
//                    request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
                }
        }
        
        request.getRequestDispatcher("admin/update-performance.jsp").forward(request, response);
        
    }
  // Update Fees
    private void updateFees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double tuitionPaid = Double.parseDouble(request.getParameter("tuitionPaid"));   
        
        HttpSession session = request.getSession(true);
        
        Fees fees = new Fees();
        
        Student student = (Student) session.getAttribute("student");
        
        String studentId = student.getStudentId();
        
        UtilityDao dao = new UtilityDao();
        
        // update attendance
        if (dao.updateFee(studentId, tuitionPaid)) {
            fees = dao.getFee(studentId);
            session.removeAttribute("fees");
            session.setAttribute("fees", fees);
            session.setAttribute("msg", "Student Data has been updated in the database");
            request.getRequestDispatcher("admin/update-fees.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Student data is not been updated in the database");
            request.getRequestDispatcher("admin/update-fees.jsp").forward(request, response);
        }
    }
    

    // Save Parent data
    private void saveParent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String homePhone = request.getParameter("homePhone");
        String mobilePhone = request.getParameter("mobilePhone");
        String businessPhone = request.getParameter("businessPhone");
        String fromAddStudent = request.getParameter("fromAddStudent");

        Parent parent = new ParentBuilder().setEmail(email).setFirstName(firstName)
                .setLastName(lastName).setAddress(address).setCity(city)
                .setPostalCode(postalCode).setGender(gender).setMobNumber(homePhone)
                .setHomNumber(mobilePhone).setBusNumber(businessPhone)
                .createPerson();
        StudentDao dao = new StudentDao();

        HttpSession session = request.getSession(true);

        // if email already exit
        if (dao.isExist(email)) {
            session.setAttribute("msg", "Email already in Use");
            if (fromAddStudent.equalsIgnoreCase("true")){
                   request.getRequestDispatcher("admin/add-parent.jsp").forward(request, response);
             }else{
                   request.getRequestDispatcher("admin/add-parent-admin.jsp").forward(request, response);
             }   
        }

        // add parent
        if (dao.addParent(parent) && dao.attachToStudent(Integer.parseInt(studentId), email)) {
            if (fromAddStudent.equalsIgnoreCase("true")){
                   request.getRequestDispatcher("admin/add-parent.jsp").forward(request, response);
             }else{
                   request.getRequestDispatcher("admin/add-parent-admin.jsp").forward(request, response);
             }   
            session.setAttribute("msg1", "Parent Data has been saved to database");          
        } else {
            session.setAttribute("msg1", "Parent data is not saved into database");
            request.getRequestDispatcher("admin/add-parent.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
