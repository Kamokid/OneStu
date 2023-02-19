<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*, one.dao.*" %>
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

                            <h1 class="center">Update Teacher</h1>
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
                                
                                Object obj = session.getAttribute("teacher");
                                
                                if(obj == null) {
                                    out.println("<h4 class='msg'>Teacher doesn't exist</h4>");
                                } else {
                                
                                Teacher teacher = (Teacher) obj;
                            %>
                                
                            
                            <br />
                            
                            <form action="TeacherServlet" method="post">
                                <table class="frmTable" style="width: 650px">
                                    
                                    <tr>
                                        <td><strong>Email:</strong></td>
                                        <td><input type="email" class="large" required="" placeholder="email address" 
                                                   name="email" id="email" readonly="" value="<%= teacher.getPerson().getEmail()  %>" /></td>
                                    </tr>
                                    <tr>
                                        <td><strong>First Name</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="First Name" 
                                                   name="firstName" id="firstName" value="<%= teacher.getPerson().getFirstName()  %>"  /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Last Name</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="Last Name" 
                                                   name="lastName" id="lastName" value="<%= teacher.getPerson().getLastName()  %>"  /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Address</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="address" 
                                                   name="address" id="address" value="<%= teacher.getPerson().getAddress()  %>"  /></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="center">
                                            <input type="hidden" name="type" value="update-teacher" />
                                            <input type="submit" class="small" value="Update Teacher" />
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
