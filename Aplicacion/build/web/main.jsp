<%-- 
    Document   : main
    Created on : 16/05/2017, 09:34:15 AM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Meditec - Start Page</title>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
        <%@page import="package1.DataBase"%>
        <%String name = request.getParameter("name");
        String img = request.getParameter("img");
        String id = request.getParameter("id").substring(0,4);
        DataBase database = new DataBase();
        String[] doctor = database.DoctorList(id,name);%>
        <div id="info">
            <img src="<%=img%>" alt="profilePhoto" height="20%" width="60%">
            <a><p><br>Name:<%=name%></p></a>
            <a><p><br>Doctor ID: <%=id%></p></a>
            <a><p><br>Calificación:<%=doctor[1]%></p></a>
        </div>
        <div ID="agenda">
            <form action = "diary.jsp" method = "GET" ID="agenda">
                <button type="submit" value="Submit">Diary</button>
                <input type = "text" name = "img" value="<%=img%>"><br>
                <input type = "text" name = "id" value="<%=id%>" ><br>
            </form>
        </div>
        <div ID="casos">
            <form action = "cases.jsp" method = "GET" ID="agenda">
                <button type="submit" value="Submit">Clinical Cases</button>
                <input type = "text" name = "name" ID="cita"><br>
                <input type = "text" name = "img" value="<%=img%>"><br>
                <input type = "text" name = "id" value="<%=id%>" ><br>
            </form>
        </div>
        <div ID="citas">
            <form action = "appoinments.jsp" method = "GET" ID="agenda">
                <button type="submit" value="Submit">Appointments</button>
                <input type = "text" name = "name" ID="cita"><br>
                <input type = "text" name = "img" value="<%=img%>"><br>
                <input type = "text" name = "id" value="<%=id%>" ><br>
            </form>
        </div>
        <div ID="chat">
            <form action = "chat.jsp" method = "GET" ID="agenda">
            <button type="submit" value="Submit">Chat (soon)</button>
                <input type = "text" name = "img" value="<%=img%>"><br>
                <input type = "text" name = "id" value="<%=id%>" ><br>
            </form>
        </div>        
    </body>
</html>
