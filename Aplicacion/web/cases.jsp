<%-- 
    Document   : cases
    Created on : 18/05/2017, 05:27:33 PM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='cases.css'>
        <title>MediTEC - Appointments</title>

    </head>
    <body>
        <%@page import="package1.DataBase"%>
        <%
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String id = request.getParameter("id").substring(0,4);
        DataBase database = new DataBase();
        String[] doctor = database.DoctorList(id,"");
        String[] cases = database.CasesList(name);
        String[] medecine = database.MedecineList(cases[2]);
        String[] test = database.TestList(cases[2]);
        %>
        <div id="info">
            <img src="<%=img%>" alt="profilePhoto" height="20%" width="60%">
            <a><p><br>Name:<%=doctor[2]%></p></a>
            <a><p><br>Doctor ID: <%=id%></p></a>
            <a><p><br>Calificación:<%=doctor[1]%></p></a>
        </div>
        <div ID="cases">
            <form action = "cases_1.jsp" method = "GET" ID="medicina">
                <input type = "text" name = "name1" ID="visible"><br>
                <input type = "text" name = "effect" ID="visible"><br>
                <input type = "text" name = "cost" ID="visible"><br>
                <input type = "text" name = "name" value="<%=name%>"><br>
                <input type = "text" name = "img" value="<%=img%>"><br>
                <input type = "text" name = "id" value="<%=id%>" ><br>
                <button type="submit" value="Submit">New Medecine</button>
            </form>
            
            <form action = "cases_2.jsp" method = "GET" ID="examen">
                <input type = "text" name = "type" ID="visible"><br>
                <input type = "text" name = "result" ID="visible"><br>
                <input type = "text" name = "cost1" ID="visible"><br>
                <input type = "text" name = "name" value="<%=name%>"><br>
                <input type = "text" name = "img" value="<%=img%>"><br>
                <input type = "text" name = "id" value="<%=id%>" ><br>
                <button type="submit" value="Submit">New Medical Test</button>
            </form>
            <p>Clinical Case of <%=name%></p>
        </div>
        <% 
            for (int i = 0; i < medecine.length; i++) {%>
                <div id="citas1"> 
                <%for (int j = 0; j < 3; j++) {%>
                    <p ID="<%=(i*6)+j%>"></p>
                <%}%>
                    </div>
            <%}
        %>
        <% 
            for (int i = 0; i < test.length; i++) {%>
                <div id="citas2"> 
                <%for (int j = 0; j < 3; j++) {%>
                    <p ID="<%=(i*6)+j+3%>"></p>
                <%}%>
                    </div>
            <%}
        %>
        <script>
        <%
        for (int i = 0; i < medecine.length; i++) {   
            String x = "'{"+medecine[i]+"}'";
        %>
                var obj = JSON.parse(<%=x%>);
                document.getElementById(""+<%=(i*6)+0%>).innerHTML = "Name: "+obj.name;
                document.getElementById(""+<%=(i*6)+1%>).innerHTML = "Effect: "+obj.effect;
                document.getElementById(""+<%=(i*6)+2%>).innerHTML = "Cost: "+obj.cost;
        <%}%>
        <%
        for (int i = 0; i < test.length; i++) {  
            String y = "'{"+test[i]+"}'";
        %>
                var obj = JSON.parse(<%=y%>);
                document.getElementById(""+<%=(i*6)+3%>).innerHTML = "Type: "+obj.type;
                document.getElementById(""+<%=(i*6)+4%>).innerHTML = "Result: "+obj.result;
                document.getElementById(""+<%=(i*6)+5%>).innerHTML = "Cost: "+obj.cost;
        <%}%>
        </script>
</html>
