<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*, one.dao.*, java.util.*" %>
<%
    PersonRole role = (PersonRole) session.getAttribute("role");

    if (role == null || (!(role instanceof Administrator))) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    TeacherDao dao = new TeacherDao();
    List<Teacher> teachers = dao.getAllTeachers();
    CourseDao cDao = new CourseDao();
    
    
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>One Student Management System</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <div class="container">
            <div class="main">
                <header>
                    <div class="content" style="min-height: 1000px"> 

                        <!-- Content goes here -->

                        <!-- Menu -->
                        <div class="left" style="min-height: 950px">
                            <br /> <br /> 

                            <ul>
                                <li>
                                    <a href="#">Home</a>
                                </li>
                                <li>
                                    <a href="student.jsp">Student</a>
                                </li>
                                <li>
                                    <a href="admin.jsp"  class="active">Admin</a>
                                </li>
                                <li>
                                    <a href="#">Report</a>
                                </li>
                                <li>
                                    <a href="logout.jsp">Logout</a>
                                </li>
                            </ul>

                        </div>

                        <!-- main content --> 
                        <div class="right">

                            <h1 class="center">Update Course</h1>
                            <table style="width: 400px; margin: 0 auto">
                                <tr>
                                    <td><a href="admin.jsp">Back to Admin</a> </td>
                                </tr>
                            </table>
                            
                            <br />
                            <%
                                Object msg = session.getAttribute("msg");
                                
                                if(msg != null) {
                                    out.println("<h4 class='msg'>" + msg.toString() + "</h4>");
                                }
                                
                                Object obj = session.getAttribute("course");
                                
                                if(obj == null) {
                                    out.println("<h4 class='msg'>Course doesn't exist</h4>");
                                } else {
                                
                                Course crs = (Course) obj;
                            %>
                            <br />
                            
                            <form action="CourseServlet" method="post">
                                <table class="frmTable" style="width: 650px">
                                    
                                    <tr>
                                        <td><strong>Email:</strong></td>
                                        <td><input type="text" class="large" readOnly='' required="" 
                                                   value="<%= crs.getCourseId() %>" 
                                                   name="courseId" id="courseId" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Course Name</strong></td>
                                        <td><input type="text" class="large" required="" value="<%= crs.getCourseName()  %>" 
                                                   name="courseName" id="courseName" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Teacher's Email</strong></td>
                                        <td><input type="email" class="large" required="" value="<%= crs.getTeacherEmail()%>" 
                                                   name="email" id="email" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td colspan="2" class="center">
                                            <input type="hidden" name="type" value="update-course" />
                                            <input type="submit" class="small" value="Save Course" />
                                        </td>
                                    </tr>                
                                </table>
                            </form>
                                                   <% } %>
                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
