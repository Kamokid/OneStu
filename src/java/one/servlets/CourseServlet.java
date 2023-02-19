/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package one.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import one.business.Course;
import one.business.Student;
import one.business.Teacher;
import one.dao.CourseDao;
import one.dao.StudentDao;
import one.dao.TeacherDao;

/**
 *
 * @author Programmer
 */
public class CourseServlet extends HttpServlet {

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

        if (type.equalsIgnoreCase("add-course")) {
            saveCourse(request, response);
        } else if(type.equalsIgnoreCase("update-course")) {
            updateCourse(request, response);
        } else if(type.equalsIgnoreCase("get-course-edit")) {
            loadCourse(request, response, type);
        }
    }
    
    private void saveCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        
        Course course = new Course(courseId, courseName, email);
        
        HttpSession session = request.getSession(true);
        
        CourseDao dao = new CourseDao();
        
        // add Course
        if (dao.addCourse(course)) {
            session.setAttribute("msg", "Course Data has been saved to database");
            request.getRequestDispatcher("add-course.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Course data is not saved into database");
            request.getRequestDispatcher("add-course.jsp").forward(request, response);
        }
    }
    
    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        
        Course course = new Course(courseId, courseName, email);
        
        HttpSession session = request.getSession(true);
        
        CourseDao dao = new CourseDao();
        
        // add Course
        if (dao.updateCourse(course)) {
            course = dao.getCourse(courseId);
            session.removeAttribute("course");
            session.setAttribute("course", course);
            
            session.setAttribute("msg", "Course Data has been saved to database");
            request.getRequestDispatcher("update-course.jsp").forward(request, response);
        } else {
            session.setAttribute("msg", "Course data is not saved into database");
            request.getRequestDispatcher("update-course.jsp").forward(request, response);
        }
        
    }
    
    // Load Course data
    private void loadCourse(HttpServletRequest request, HttpServletResponse response, String type)
            throws ServletException, IOException {
        String courseId = request.getParameter("courseId");

        // Get Teacher Data
        CourseDao dao = new CourseDao();

        HttpSession session = request.getSession(true);

        Course course = dao.getCourse(courseId);
        
        
        if (course == null) {
            session.setAttribute("msg", "Course with CourseID: " + courseId + " doesn't exist");
            
            if (type.equalsIgnoreCase("get-course-edit")) {
                request.getRequestDispatcher("update-course.jsp").forward(request, response);
            }
        }

        session.setAttribute("course", course);
 
        if (type.equalsIgnoreCase("get-course-edit")) {
            session.removeAttribute("msg");
            request.getRequestDispatcher("update-course.jsp").forward(request, response);
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
