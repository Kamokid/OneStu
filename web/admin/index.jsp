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
                        <a href="<c:url value='/admin/index.jsp'/>" class="active">Home</a>
                    </li>
                    <li>
                        <a href="<c:url value='/admin/student.jsp'/>">Student</a>
                    </li>
                    <li>
                        <a href="<c:url value='/admin/admin.jsp'/>">Admin</a>
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
                <h1 class="center">OneStudent Management System</h1>
                <br /><br />
                
            </div>
        </div>
    </div>
</div>
</body>
</html>
