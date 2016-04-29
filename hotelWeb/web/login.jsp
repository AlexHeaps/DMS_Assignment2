<%-- 
    Document   : Login
    Created on : 29/04/2016, 4:48:09 AM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Finesse Hotels</title>
    </head>
    <body>
        <div id="container">
        </div>
        <div id="main">
            <form action="Login" method="post">
                Username: <input type="username" name="username" /> <br>
                Password: <input type="password" name="password" /> <br>
                <input type="submit" />
            </form>
            <a href="register.jsp">Click here to register!</a>
        </div>
    </body>
</html>
