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
                                    <a href="<c:url value='/admin/student.jsp'/>" class="active">Student</a>
                                </li>
                                <li>
                                    <a href="<c:url value='/admin/admin.jsp'/>">Admin</a>
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
                            <table>
                                <tr>
                                    <td><a href="<c:url value='/admin/personal-info.jsp'/>" class="active">Personal Info</a></td>
                                    <td><a href="<c:url value='/admin/attendance.jsp'/>" >Attendance</a></td>
                                    <td><a href="<c:url value='/admin/performance.jsp'/>">Performance</a></td>
                                    <td><a href="#">Fees</a></td>
                                </tr>
                            </table>
                            <br /><br />
                            
                            <table>
                                <tr>
                                    <th>Student Info</th>
                                    <th>Parent One Info</th>
                                    <th>Parent Two Info</th>
                                </tr>
                                <tr>
                                    <td>Student ID: <%= student.getStudentId() %></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Email: " + parentOne.getEmail());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Email: " + parentTwo.getEmail());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>Name: <%= student.getPerson().getFirstName() %> <%= student.getPerson().getLastName() %></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Name: " + parentOne.getPerson().getFirstName() + " " + 
                                                    parentOne.getPerson().getLastName());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Name: " + parentTwo.getPerson().getFirstName() + " " + 
                                                    parentTwo.getPerson().getLastName());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>Address: <%= student.getPerson().getAddress()%></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Address: " + parentOne.getPerson().getAddress());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Address: " + parentTwo.getPerson().getAddress());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>City: <%= student.getPerson().getCity()%></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("City: " + parentOne.getPerson().getCity());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("City: " + parentTwo.getPerson().getCity());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>Postal Code: <%= student.getPerson().getPostalCode()%></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Postal Code: " + parentOne.getPerson().getPostalCode());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Postal Code: " + parentTwo.getPerson().getPostalCode());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>Gender: <%= student.getGender() %></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Gender: " + parentOne.getGender());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Gender: " + parentTwo.getGender());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>DOB: <%= student.getdOfBirth().toString() %></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Mobile Phone: " + parentOne.getMobNumber());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Mobile: " + parentTwo.getMobNumber());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                     <td>Blood Group: <%= student.getBloodGroup() %></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Home Phone: " + parentOne.getHomNumber());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Home: " + parentTwo.getHomNumber());
                                        %>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <td>Level: <%= student.getLevelId() %></td>
                                    <td>
                                        <%
                                            if(parentOne != null) 
                                                out.println("Business Phone: " + parentOne.getBusNumber());
                                        %>
                                    </td>
                                    <td>
                                        <%
                                            if(parentTwo != null) 
                                                out.println("Business Phone: " + parentTwo.getBusNumber());
                                        %>
                                    </td>
                                </tr>
                                 <tr>
                                    <td>Section: <%= student.getSectionId() %></td>
                                    <td>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Tuition Paid: <%= student.getTuitionPaid() %></td>
                                    <td>
                                    </td>
                                    <td>
                                    </td>
                                </tr>
                                
                            </table>

                        </div>
                    </div>
            </div>
        </div>
    </body>
</html>
