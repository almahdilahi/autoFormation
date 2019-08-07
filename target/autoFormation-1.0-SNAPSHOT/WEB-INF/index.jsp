<%-- 
    Document   : index.jsp
    Created on : 29 juil. 2019, 05:12:02
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style type="text/css">
        <%@include file="../css/bootstrap.css" %>
        <%@include file="../css/login.css" %>
 
    </style>
    </head>
    <body>
        <div class="container">
        <div class="row mb-10">
             <form method="POST" action="">
                 <h1 class="col text-center">Login To Your Account </h1>
                <input type="hidden" name="action" value="logon"/>
                <div class="form-group">
                        <input class="form-control" type="text" name="username" placeholder="Login">
                    </div>
                <div class="form-group">
                        <input class="form-control" type="password" name="password" placeholder="Password">
                    </div>
                <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="submit">
                    </div>
            </form>
            
            ${message}     
            
        </div>
        
    </div>
        </body>
</html>
