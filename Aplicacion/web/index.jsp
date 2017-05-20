<%@page import="linkedin.commonthings"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta charset="UTF-8">
        <title>MediTEC - Login</title>
        <link rel='stylesheet' type='text/css' href='sheet.css'>
    </head>
    <body background="http://sf.co.ua/13/01/wallpaper-2547293.jpg">
        <div ID="central">
            <img  src="http://img11.deviantart.net/752b/i/2014/010/4/f/welcome_banner_png_by_yuiinao-d71p972.png">
            <br>
            <br>
            <br>
            <a href="https://www.linkedin.com/oauth/v2/authorization?response_type=code&client_id=<%=commonthings.client_id%>&redirect_uri=<%=commonthings.redirect_url%>&state=fdfdfdfd&scope=r_basicprofile%20r_emailaddress">
                <img ID="welcome" src="Linkedin-customized-button.png">
            </a>
        </div>
    </body>
</html>