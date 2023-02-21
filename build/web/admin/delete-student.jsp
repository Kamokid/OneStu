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
                    <div class="content" style="min-height: 1000px"> 

                        <!-- Content goes here -->

                        <!-- Menu -->
                        <div class="left" style="min-height: 950px">
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
                            <h1 class="center">Delete Student</h1>
                            <table style="width: 200px; margin: 0 auto">
                                <tr>
                                    <td><a href="<c:url value='/admin/admin.jsp'/>">Back to Admin</a> </td>
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
                            
                            <form action="<c:url value='/studentServlet'/>" method="post">
                                <table class="frmTable" style="width: 650px">
                                   
                                    <tr>
                                        <td><strong>Student Id</strong></td>
                                        <td class="large" name="studentId" id="studentId">${student.getStudentId()}</td>
                                    </tr>

                                    <tr>
                                        <td><strong>First Name</strong></td>
                                        <td class="large" name="firstName" id="firstName"> 
                                                ${student.getPerson().getFirstName()}</td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Last Name</strong></td>
                                        <td class="large" name="lastName" id="lastName">
                                                ${student.getPerson().getLastName()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Address</strong></td>
                                        <td class="large" name="address" id="address">
                                                ${student.getPerson().getAddress()}
                                        </td>
                                    </tr>
                                    
                                     <tr>
                                        <td><strong>City</strong></td>
                                        <td class="large" name="city" id="city">
                                            ${student.getPerson().getCity()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Postal Code</strong></td>
                                        <td class="large" name="postalCode" id="postalCode">
                                                ${student.getPerson().getPostalCode()}
                                        </td>
                                    </tr>
                                  
                                    <tr>
                                        <td><strong>DOB</strong></td>
                                        <td class="large" name="dob" id="dob">
                                                ${student.getdOfBirth()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Gender</strong></td>
                                        <td class="large" name="gender" id="gender">
                                                ${student.getGender()}
                                        </td>
                                        </td>
                                    </tr>
                                  
                                    <tr>
                                        <td><strong>Blood Group</strong></td>
                                        <td class="large" name="bloodGroup" id="bloodGroup">
                                                ${student.getBloodGroup()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Tuition Paid</strong></td>
                                        <td class="large" name="tuitionPaid" id="tuitionPaid">
                                                ${student.getTuitionPaid()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Level</strong></td>
                                        <td class="large" name="levelId"  id="levelId">
                                                ${student.getLevelId()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td><strong>Section</strong></td>
                                        <td class="large" name="sectionId" id="sectionId">
                                                ${student.getSectionId()}
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td colspan="2" class="center">
                                            <input type="hidden" name="type" value="delete-student" />
                                            <input type="submit" class="small" value="Delete Student" />
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
