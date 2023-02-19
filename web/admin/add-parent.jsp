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
                    <div class="content" style="min-height: 950px">

                        <!-- Content goes here -->

                        <!-- Menu -->
                        <div class="left" style="min-height: 900px">
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
                            <h1 class="center">Add Parent</h1>
                            <table style="width: 400px; margin: 0 auto">
                                <tr>
                                    <td><a href="add-student.jsp">Add Student</a> </td>
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
                            <form action="StudentServlet" method="post">
                                <table class="frmTable" style="width: 650px">
                                    
                                    <tr>
                                        <td><strong>Email:</strong></td>
                                        <td><input type="email" class="large" required="" placeholder="email address" 
                                                   name="email" id="email" /></td>
                                    </tr>
                                    
<!--                                    <tr>
                                        <td><strong>Password:</strong></td>
                                        <td><input type="password" class="large" placeholder="Password" 
                                                   required="" name="password" id="password" /></td>
                                    </tr>-->

                                    <input type="hidden" name="password" id="password" value="null" />

                                    <tr>
                                        <td><strong>First Name</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="First Name" 
                                                   name="firstName" id="firstName" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Last Name</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="Last Name" 
                                                   name="lastName" id="lastName" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Address</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="address" 
                                                   name="address" id="address" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td colspan="2" class="center">
                                            <input type="radio" name="gender" checked="" value="Male"> Male
                                            <input type="radio" name="gender" value="Female"> Female
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Mobile Phone</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="Mobile Phone" 
                                                   name="mobilePhone" id="mobilePhone" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Home Phone</strong></td>
                                        <td><input type="text" class="large" placeholder="Home Phone" 
                                                   name="homePhone" id="homePhone" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Business Phone</strong></td>
                                        <td><input type="text" class="large" placeholder="Business Phone" 
                                                   name="businessPhone" id="businessPhone" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td colspan="2" class="center">
                                            <input type="hidden" name="type" value="add-parent" />
                                            <input type="submit" class="small" value="Save Parent" />
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
