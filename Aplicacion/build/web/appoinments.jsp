<%-- 
    Document   : appoinments
    Created on : 18/05/2017, 05:27:48 PM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='appointment.css'>
        <title>MediTEC - Appointments</title>

    </head>
    <body>
        <%@page import="package1.DataBase"%>
        <%
        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String id = request.getParameter("id").substring(0,4);
        DataBase database = new DataBase();
        String[] doctor = database.DoctorList(id,"d");
        String[] citas = database.AppointmentsList(name);
        
        %>
        <div id="info">
            <img src="<%=img%>" alt="profilePhoto" height="20%" width="60%">
            <a><p><br>Name:<%=doctor[2]%></p></a>
            <a><p><br>Doctor ID: <%=id%></p></a>
            <a><p><br>Calificación:<%=doctor[1]%></p></a>
        </div>
        <% 
            for (int i = 0; i < citas.length; i++) {
                if(i%2==0){%>
                    <div id="citas1">
                <%}else{%>
                    <div id="citas2">
                <%}%>
                <%for (int j = 0; j < 7; j++) {%>
                    <p ID="<%=(i*7)+j%>"></p>
                <%}%>
                    </div>
            <%}
        %>
        <script><% 
            for (int i = 0; i < citas.length; i++) {
                String x = "'{"+citas[i]+"}'";%>
                var obj = JSON.parse(<%=x%>);
                document.getElementById(""+<%=(i*7)+0%>).innerHTML = "Fecha: "+obj.date;
                document.getElementById(""+<%=(i*7)+1%>).innerHTML = "Doctor ID: "+obj.doctorId;
                document.getElementById(""+<%=(i*7)+2%>).innerHTML = "ID: "+obj.id;
                document.getElementById(""+<%=(i*7)+3%>).innerHTML = "Location: "+obj.location;
                document.getElementById(""+<%=(i*7)+4%>).innerHTML = "Patient Name: "+obj.patientName;
                document.getElementById(""+<%=(i*7)+5%>).innerHTML = "Pay: "+obj.pay;
                document.getElementById(""+<%=(i*7)+6%>).innerHTML = "Symtomps: "+obj.symptomps;
                <%}
            %>
        </script>
    </body>
</html>
