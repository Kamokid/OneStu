<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*" %>
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
                    <div class="content">

                        <!-- Content goes here -->

                        <!-- Menu -->
                        <div class="left">
                            <br /> <br /> 

                            <ul>
                                <li>
                                    <a href="<c:url value='/teacher/index.jsp'/>">Home</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/teacher/student.jsp'/>"  class="active">Student</a>
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
                            <table>
                                <tr>
                                    <td><a href="<c:url value='/teacher/student.jsp'/>">Personal Info</a></td>
                                    <td><a href="<c:url value='/teacher/student.jsp'/>">Attendance</a></td>
                                    <td><a href="<c:url value='/teacher/student.jsp'/>">Performance</a></td>
                                    <td><a href="<c:url value='/teacher/student.jsp'/>">Fees</a></td>
                                </tr>
                            </table>
                            <br /><br /><br /><br /> 

                            <%
                                Object msg = session.getAttribute("msg");
                                
                                if(msg != null) {
                                    out.println("<h4 class='msg'>" + msg.toString() + "</h4>");
                                }
                            %>

                            <form action="<c:url value='/studentServlet'/>" method="post">
                                <table>

                                    <tr>
                                        <td class="center" style="border: 0px"><input type="text" class="large" required="" placeholder="Student Id" 
                                                                                      name="studentId" id="studentId" /></td>
                                    </tr>
                                    <tr>
                                        <td class="center"  style="border: 0px;">
                                            <input type="hidden" name="type" value="get-student" />
                                            <input type="hidden" name="role" value="teacher" />
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
