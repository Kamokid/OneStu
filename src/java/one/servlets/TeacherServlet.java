/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package one.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import one.business.Parent;
import one.business.Student;
import one.business.Teacher;
import one.business.TeacherBuilder;
import one.dao.StudentDao;
import one.dao.TeacherDao;

/**
 *
 * @author Programmer
 */
public class TeacherServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String type = request.getParameter("type");

        if (type.equalsIgnoreCase("add-teacher")) {
            saveTeacher(request, response);
        } else if(type.equalsIgnoreCase("update-teacher")) {
            updateTeacher(request, response);
        } else if(type.equalsIgnoreCase("get-teacher-edit")) {
            loadTeacher(request, response, "get-teacher-edit");
        }
        
    }
    
    // Load Teacher data for a given Email
    public void loadTeacher(HttpServletRequest request, HttpServletResponse response, String type)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        // Get Teacher Data
        TeacherDao dao = new TeacherDao();

        HttpSession session = request.getSession(true);

        Teacher teacher = dao.getTeacher(email);
        
        
        if (teacher == null) {
            session.setAttribute("msg", "Teacher with Email: " + email + " doesn't exist");
            
            if (type.equalsIgnoreCase("get-teacher-edit")) {
                request.getRequestDispatcher("update-teacher.jsp").forward(request, response);
            }
        }

        session.setAttribute("teacher", teacher);
 
        if (type.equalsIgnoreCase("get-teacher-edit")) {
            session.removeAttribute("msg");
            request.getRequestDispatcher("update-teacher.jsp").forward(request, response);
        }
    }
    
    // Add teacher into database
    public void saveTeacher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        String email = request.getParameter("email");
        String startDate = request.getParameter("startDate");
        System.out.println("Start Date: " + startDate);
        
        Teacher teacher = new TeacherBuilder().setEmail(email).setFirstName(firstName)
                .setLastName(lastName).setAddress(address).setCity(city).setPostalCode(postalCode)
                .setStartDate(startDate).createPerson();
        TeacherDao dao = new TeacherDao();

        HttpSession session = request.getSession(true);

        // if email already exit
        if (dao.isExist(email)) {
            session.setAttribute("msg", "Email already in Use");
            request.getRequestDispatcher("add-teacher.jsp").forward(request, response);
        }

        // add student
        if (dao.addTeacher(teacher)) {
            session.setAttribute("msg", "Teacher Data has been saved to database");
        } else {
            session.setAttribute("msg", "Teacher data is not saved into database");
        }
        
        request.getRequestDispatcher("add-teacher.jsp").forward(request, response);
        
    }
    
    /**
     * Update Teacher
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    public void updateTeacher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        String email = request.getParameter("email");
        String startDate = request.getParameter("startDate");
        
        Teacher teacher = new Teacher();

        teacher.getPerson().setFirstName(firstName);
        teacher.getPerson().setLastName(lastName);
        teacher.getPerson().setAddress(address);
        teacher.getPerson().setCity(city);
        teacher.getPerson().setPostalCode(postalCode);
        teacher.setEmail(email);
        teacher.setStartDate(startDate);
       
        
        TeacherDao dao = new TeacherDao();
        HttpSession session = request.getSession(true);
        
        System.out.println("HERE");
        
        // Update Teacher
        if (dao.updateTeacher(teacher)) {
            teacher = dao.getTeacher(email);
            session.removeAttribute("teacher");
            session.setAttribute("teacher", teacher);
            session.setAttribute("msg", "Teacher Data has been updated in the database");
            request.getRequestDispatcher("update-teacher.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Teacher data is not been updated in the database");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
