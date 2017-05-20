<%-- 
    Document   : diary
    Created on : 18/05/2017, 05:28:04 PM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='diary.css'>
        <title>MediTEC - Diary</title>
    </head>
    <body>
        <%@page import="package1.DataBase"%>
        <%
        String img = request.getParameter("img");
        String id = request.getParameter("id").substring(0,4);
        DataBase database = new DataBase();
        String[] doctor = database.DoctorList(id,"d");
        %>
        <div id="info">
            <img src="<%=img%>" alt="profilePhoto" height="20%" width="60%">
            <a><p><br>Name:<%=doctor[2]%></p></a>
            <a><p><br>Doctor ID: <%=id%></p></a>
            <a><p><br>Calificación:<%=doctor[1]%></p></a>
        </div>
    </body>
</html>
