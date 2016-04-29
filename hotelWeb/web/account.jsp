<%-- 
    Document   : account
    Created on : 29/04/2016, 9:22:31 PM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Finesse Motels</title>
    </head>
    <body>
        <div id="container">
        <h1>Welcome to Finesse Motels</h1>
        </div>
        <jsp:include page="makeBooking.jsp"/>
        <jsp:include page="viewBooking.jsp"/>
    </body>
</html>
