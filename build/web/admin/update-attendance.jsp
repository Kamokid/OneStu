<%-- 
    Document   : attendance
    Created on : Feb 17, 2023, 10:36:14 PM
    Author     : Khalil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Object obj = session.getAttribute("student");
    
    if(obj == null) {
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
    
    Student student = (Student) obj;
    Object obj1 = session.getAttribute("parentOne");
    Object obj2 = session.getAttribute("parentTwo");
    Parent parentOne = null;
    Parent parentTwo = null; 

    if(obj1 != null) {
        parentOne = (Parent) obj1;
    }

    if(obj2 != null) {
        parentTwo = (Parent) obj2;
    }
    
    Object obj4 = session.getAttribute("attendance");
    Attendance attendance = (Attendance) obj4;
    
    Object obj5 = session.getAttribute("r1");
    one.business.Registration reg = (one.business.Registration) obj5;
    
    Object obj6 = session.getAttribute("r2");
    one.business.Registration reg1 = (one.business.Registration) obj6;
    
    Object obj7 = session.getAttribute("r3");
    one.business.Registration reg2 = (one.business.Registration) obj7;

    Object obj8 = session.getAttribute("r4");
    one.business.Registration reg3 = (one.business.Registration) obj8;

%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>One Student Management System</title>
        <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
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
                            <table>
                                <tr>
                                    <td><a href="<c:url value='/admin/update-student.jsp'/>">Personal Info</a></td>
                                    <td><a href="<c:url value='/admin/update-attendance.jsp'/>" class="active">Attendance</a></td>
                                    <td><a href="<c:url value='/admin/update-performance.jsp'/>">Performance</a></td>
                                    <td><a href="#">Fees</a></td>
                                </tr>
                            </table>
                         
                            <table style="width: 200px; margin: 0 auto">
                                <tr>
                                    <td><a href="<c:url value='/admin/admin.jsp'/>">Back to Admin</a> </td>
                                </tr>
                            </table>
                                    <br/>
                                    <%
                                        Object msg = session.getAttribute("msg");

                                        if(msg != null) {
                                            out.println("<h4 class='msg'>" + msg.toString() + "</h4>");
                                        }
                                    %>
                                    <br />
                            
                            <form action="<c:url value='/studentServlet'/>" method="post">
                            <table class="frmTable" style="width: 650px">
                                <tr>
                                    <td>Student ID  </td>
                                    <td>${student.getStudentId()}</td>
                                </tr>
                                
                                <tr>
                                    <td>Name </td>
                                    <td>${student.getPerson().getFirstName()} ${student.getPerson().getLastName()}</td>
                                </tr>
                                
                                <tr>
                                        <td><strong>Days Present</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="Days Present" 
                                                   name="daysPresent"  id="daysPresent"  value="${attendance.getPresentDays()}"  /></td>
                                </tr>
                                    
                                <tr>
                                        <td><strong>Days Absent</strong></td>
                                        <td><input type="text" class="large" required="" placeholder="Days Absent" 
                                                   name="daysAbsent" id="daysAbsent"  value="${attendance.getAbsentDays()}" /></td>
                                </tr>
                                
                                <tr>
                                        <td colspan="2" class="center">
                                            <input type="hidden" name="type" value="update-attendance" />
                                            <input type="submit" class="small" value="Update Attendance" />
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
