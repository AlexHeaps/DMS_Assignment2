<%-- 
    Document   : Register
    Created on : 29/04/2016, 4:59:00 AM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finesse Hotels</title>
    </head>
    <body>
        <header> Finesse Hotels</header>
        <div id="main">
            <form action="register" method="post">
                Email: <input type="email" name="email"/> <br>
                Password: <input type="password" name="password"/> <br>
                First Name: <input type="text" name="firstName"/> <br>
                Last Name: <input type="text" name="lastName"/> <br>
                <input type="submit" value="register"/>
            </form>
        </div>
    </body>
</html>
