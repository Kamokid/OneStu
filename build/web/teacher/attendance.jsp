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
                                    <a href="<c:url value='/teacher/index.jsp'/>">Home</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/teacher/student.jsp'/>" class="active">Student</a>
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
                                    <td><a href="<c:url value='/teacher/personal-info.jsp'/>">Personal Info</a></td>
                                    <td><a href="<c:url value='/teacher/attendance.jsp'/>" class="active">Attendance</a></td>
                                    <td><a href="<c:url value='/teacher/performance.jsp'/>">Performance</a></td>
                                    <td><a href="#">Fees</a></td>
                                </tr>
                            </table>
                            <br /><br />
                            
                            <table>
                                <tr>
                                    <th>Attendance Info</th>
                                </tr>
                                <tr>
                                    <td>Student ID: <%= student.getStudentId() %></td>
                                </tr>
                                
                                <tr>
                                    <td>Name: <%= student.getPerson().getFirstName() %> <%= student.getPerson().getLastName() %></td>
                                </tr>
                                
                                <tr>
                                    <td>Days Present: <%= attendance.getPresentDays()%></td>
                                </tr>
                                
                                <tr>
                                    <td>Days Absent: <%= attendance.getAbsentDays()%></td>
                                </tr>                  
                            </table>

                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>

