<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                    <td><strong>Username:</strong></td>
                    <td><input type="text" class="large" 
                               name="j_username" required /></td>
                </tr>
                
                <tr>
                    <td><strong>Password:</strong></td>
                    <td><input type="password" class="large" 
                                name="j_password" required /></td>
                </tr>
                
                <tr>
                    <td colspan="2" class="center">
                        <input type="submit" class="small" value="Login" />
                    </td>
                </tr>                
            </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>