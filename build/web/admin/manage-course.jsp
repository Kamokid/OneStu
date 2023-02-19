<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*" %>
<%
    PersonRole role = (PersonRole) session.getAttribute("role");

    if (role == null || (!(role instanceof Administrator))) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
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
                    <div class="content">

                        <!-- Content goes here -->

                        <!-- Menu -->
                        <div class="left">
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
                            <h1>Manage Course</h1>
                            <br /><br /><br /><br />
                            <%
                                Object msg = session.getAttribute("msg");
                                
                                if(msg != null) {
                                    out.println("<h4 class='msg'>" + msg.toString() + "</h4>");
                                }
                            %>    
                            <form action="CourseServlet" method="post">
                                <table>

                                    <tr>
                                        <td class="center" style="border: 0px">Course ID: <input type="text" class="large" required="" 
                                                                                      placeholder="course id" 
                                                                                      name="courseId" id="courseId" /></td>
                                    </tr>
                                    <tr>
                                        <td class="center"  style="border: 0px;">
                                            <input type="hidden" name="type" value="get-course-edit" />
                                            <input style="background-color: #aaa; padding: 10px" type="submit" class="small" value="Enter" />
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
