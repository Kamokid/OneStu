<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    session.invalidate();
    
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>One Student Management System</title>
    <link rel="stylesheet" href="css/indexstyle.css" type="text/css" />
</head>
<body>
<div class="container">
    <div class="main">
        <header>
        <div class="content">
            <!-- Content goes here -->
            
            <h1 class="center">OneStudent Management System</h1>
            <br>
            
            

            
            <form action="j_security_check" method="post">
            <table class="frmTable">
                <tr>
                    <td><a href="<c:url value='/admin'/>">Login As Administrator</td>
                </tr>
                
                <tr>
                    <td><a href="<c:url value='/teacher'/>">Login As Teacher</td>
                </tr>               
            </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>