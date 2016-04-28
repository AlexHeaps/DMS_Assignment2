<%-- 
    Document   : booking
    Created on : 29/04/2016, 6:02:45 AM
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
        <h1>What specifications are you looking for?</h1>
        <form action="Book" method="post">
            Max Number of people: <input type="number" name="maxNumPeople" min="1" max="4"/> <br>
            Penthouse <input type="checkbox" name="roomType" value="penthouse" /> <br>
            Standard Room <input type="checkbox" name="roomType" value="standard" /> <br>
            <input type="submit" />
        </form>
    </body>
</html>
