<%-- 
    Document   : index
    Created on : 11/05/2017, 12:29:31 PM
    Author     : Vinicio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>function mostrar(id) {obj = document.getElementById(id);obj.style.visibility = (obj.style.visibility =='hidden') ? 'visible' : 'hidden';}</script>
        <%@page import="package1.DataBase" %>
            <% String x="Nombre: Gabriel"; %>
            <% DataBase database = new DataBase(); %>
            <div id='texto0'>
                <p class='cliente'><br><%=x%></p>
                <p class='cliente'>ID: 42024</p>
                <p class='cliente'>Provincia: Cartago</p>
                <hr>
                <p class='agenda'><br>Fecha de la cita: 21/3/2018</p>
                <p class='agenda'> ID del doctor a Cargo: 1313</p>
                <p class='agenda'>Lugar de la cita: Cartago</p>
                <p class='agenda'>Sintomas: Adios, Adios</p><hr>
            </div>
            <div id='texto1'>
                <p class='cliente'><br>Nombre: Daniela</p>
                <p class='cliente'>ID: 24542</p>
                <p class='cliente'>Provincia: Cartago</p><hr>
                <p class='agenda'><br>Fecha de la cita: 21/4/2018</p>
                <p class='agenda'> ID del doctor a Cargo: 1212</p>
                <p class='agenda'>Lugar de la cita: Cartago</p>
                <p class='agenda'>Sintomas: Hola, Hola</p><hr>
            </div>
            <div id='pacientes'>
                <a href='#' onclick='mostrar("texto0"); return false'><p><br>Gabriel</p></a>
                <a href='#' onclick='mostrar("texto1"); return false'><p><br>Daniela</p></a>
            </div>
    </head>
    <body>
    
</html>
