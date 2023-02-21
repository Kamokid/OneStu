<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    
    Object from = session.getAttribute("servlet");
    
    if(from == null || !from.equals("servlet")) {
        session.removeAttribute("msg");
    }
%>

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
                                    <a href="<c:url value='/admin/index.jsp'/>">Home</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/admin/student.jsp'/>">Student</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/admin/admin.jsp'/>" class="active">Admin</a>
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
                            <h1 class="center">Manage Student</h1>
                            <br /><br /><br /><br />
                            <%
                                Object msg = session.getAttribute("msg");

                                if (msg != null) {
                                    out.println("<h4 class='msg'>" + msg.toString() + "</h4>");
                                }

                            %>
                            <table>
                                <tr>
                                    <td><a href="<c:url value='/admin/add-student.jsp'/>">Add Student</a></td>
                                    <td><a href="<c:url value='/admin/manage-student.jsp'/>">Modify Student</a></td>
                                </tr>
                                <tr>
                                    <td><a href="<c:url value='/admin/add-parent-admin.jsp'/>">Add Parent</a></td>
                                    <td><a href="#">Delete Student</a></td>
                                </tr>
                            </table>

                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
