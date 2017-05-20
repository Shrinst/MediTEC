<%@page import="linkedin.LinkedInProfile"%>
<%@page import="linkedin.Post_Test"%>
<%@page import="package1.DataBase" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href='sheet.css'>
        <title>Login Success!</title>
    </head>
    <body background="http://sf.co.ua/13/01/wallpaper-2547293.jpg">
        <div ID="central">
            <img alt="" src="http://img11.deviantart.net/752b/i/2014/010/4/f/welcome_banner_png_by_yuiinao-d71p972.png">
            <br>
            <br>
            <br>
        </div>
        <div ID="acceso">
        

            <%
                String code = (String) request.getParameter("code");
                Post_Test obj_Post = new Post_Test();
                LinkedInProfile OBJ_LinkedInProfile = obj_Post.sendPost(code);
                String img = OBJ_LinkedInProfile.getPictureUrl();
                String name = OBJ_LinkedInProfile.getFormattedName();
                String id = OBJ_LinkedInProfile.getId();
                DataBase database = new DataBase();
            %>
<h1><%=name%></h1>
            <img src="<%=img%>" alt="profilePhoto" height="42" width="42"><br>
            <br>
            <form action = "main.jsp" method = "GET">
                <input type = "text" name = "name" value="<%=name%>" style="visibility: hidden"><br>
                <input type = "text" name = "img" value="<%=img%>" style="visibility: hidden"><br>
                <input type = "text" name = "id" value="<%=id%>" style="visibility: hidden"><br>
                <input type = "submit" value = "Ingresar al Sistema" />
            </form>
        </div>
    </body>
</html>