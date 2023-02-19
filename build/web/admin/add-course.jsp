<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*, one.dao.*, java.util.*" %>
<%
    
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

                            <h1 class="center">Add Course</h1>
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
                            %>
                            <br />
                            
                            <form action="CourseServlet" method="post">
                                <table class="frmTable" style="width: 650px">
                                    
                                    <tr>
                                        <td><strong>Email:</strong></td>
                                        <td><input type="text" class="large" readOnly='' required="" value="<%= cDao.getCourseId() %>" 
                                                   name="courseId" id="courseId" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Course Name</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="Course Name" 
                                                   name="courseName" id="courseName" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Select Teacher</strong></td>
                                        <td>
                                            <select name='email' id='email' class='large'>
                                                <%
                                                    for(Teacher teacher: teachers) {
                                                        out.println("<option value='"+ teacher.getPerson().getEmail() + "'>" +
                                                            teacher.getPerson().getFirstName() + ", " + teacher.getPerson().getLastName()
                                                        +"</option>");
                                                    }
                                                %>
                                            </select>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td colspan="2" class="center">
                                            <input type="hidden" name="type" value="add-course" />
                                            <input type="submit" class="small" value="Save Course" />
                                        </td>
                                    </tr>                
                                </table>
                            </form>
                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
