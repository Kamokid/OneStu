<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*, one.dao.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>One Student Management System</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css'/>" />
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
                                    <a href="<c:url value='/admin/index.jsp'/>">Home</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/admin/student.jsp'/>">Student</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/admin/admin.jsp'/>"  class="active">Admin</a>
                                </li>
                                <li>
                                    <a href="#">Report</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/index.jsp'/>">Logout</a>
                                </li>
                            </ul>

                        </div>

                        <!-- main content --> 
                        <div class="right">
                            <h1 class="center">Add Parent</h1>
                            <table style="width: 400px; margin: 0 auto">
                                <tr>
<!--                                    <td><a href="">Add Student</a> </td>-->
                                    <td><a href="<c:url value='/admin/admin.jsp'/>">Back to Admin</a> </td>
                                </tr>
                            </table>
                            <br />
                            <%
                                Object msg1 = session.getAttribute("msg");
                                
                                if(msg1 != null) {
                                    out.println("<h4 class='msg'>" + msg1.toString() + "</h4>");
                                }
                            %>
                            <br />
                            <form action="<c:url value='/studentServlet'/>"  method="post">
                                <table class="frmTable" style="width: 650px">
                                    
                                    <tr>
                                        <td><strong>Student Id</strong></td>
                                        <td><input type="text" class="large" required=""
                                                   name="studentId" id="studentId" /></td>
                                    </tr>
                                    
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
                                        <td><strong>City</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="city" 
                                                   name="city" id="city" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Postal Code</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="postalCode" 
                                                   name="postalCode" id="postalCode" /></td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Email:</strong></td>
                                        <td><input type="email" class="large" required="" placeholder="email address" 
                                                   name="email" id="email" /></td>
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
                                            <input type="hidden" name="fromAddStudent" value="false" />
                                            <input type="submit" class="small" value="Save Parent" />
                                            <input type="button" class="small" value="Cancel" 
                                                   onclick="window.location.href='<c:url value='/admin/admin.jsp'/>'" />
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
