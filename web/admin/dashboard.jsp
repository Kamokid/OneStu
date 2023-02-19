<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="one.business.*" %>
<%
    PersonRole role = (PersonRole) session.getAttribute("role");
    
    if(role == null || (!(role instanceof Administrator) && !(role instanceof Teacher))) {
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
                        <a href="#" class="active">Home</a>
                    </li>
                    <li>
                        <a href="student.jsp">Student</a>
                    </li>
                    <li>
                        <a href="admin.jsp">Admin</a>
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
                <h1 class="center">OneStudent Management System</h1>
                <br /><br />
                
                <%
                    String text = "Administrator";
                    String text2 = ""; 
                    if(role instanceof Teacher){
                        text = "Teacher";
                        text2 = "<h5>Start Date: " + ((Teacher)role).getStartDate() + "</h5>";
                    } else {
                        text2 = "<h5>Job Function: " + ((Administrator)role).getJobFunction() + "</h5>"; 
                    }
                    
                    out.println("<h3>Welcome: " + text + "</h3>");
                    out.println("<h5>Name: " + role.getPerson().getFirstName() + ", " + 
                        role.getPerson().getLastName() + "</h5>");
                    out.println("<h5>Email: " + role.getPerson().getEmail() + "</h5>");
                    out.println("<h5>Address: " + role.getPerson().getAddress() + "</h5>");
                    out.println(text2);

                %>
                
            </div>
        </div>
    </div>
</div>
</body>
</html>
