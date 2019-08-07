<%-- 
    Document   : accueil
    Created on : 29 juil. 2019, 05:23:29
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
        <%@include file="../css/accueil.css" %>
        
        </style>
    </head>
    <body>
        
        <div class="nav navbar navbar-fixed-top" style="background-color:#1b6d85;">
         <ul class="nav navbar-nav" style="margin-left: 400px;">
            <!-- l'appel de {$url_base} vous permet de recupérer le chemin de votre site web  -->
            <li class="nav-item active"> <a href="?action=accueil">ACCUEIL</a></li>
            <li class="nav-item"><a href="?action=inscription">INSCRIPTION</a></li>
            <li class="nav-item"><a href="?action=listeuser" >LISTE</a></li>
            <li  class="nav-item"><a href="?action=ajaxtraining">AJAX</a></li>
            <li class="nav-item"><a href="">[CLASS]</a></li>
            <li class="nav-item"><a href="">[CLASS]</a></li>

        </ul>
    </div>
        
        <div class="container"> 
        <button class="alert alert-success">Welcome! ${user.prenom} ${user.nom}</button>
        </div>
        
        
        </body>
</html>
