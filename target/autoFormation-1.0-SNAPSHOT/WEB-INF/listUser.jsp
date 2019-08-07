<%-- 
    Document   : listUser
    Created on : 2 août 2019, 05:55:54
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css">
        <%@include file="../css/bootstrap.css" %>
        </style>
        <script src="../js/jquery-3.3.1.js" type="text/javascript"></script>
        <title>JSP Page</title>
        
    </head>
    <body>
        
        <div>
        <table class="table table-striped table-bordered">
            <form method="POST" action="">
            <input type="hidden" name="action" value="listuser"/>
                    <thead>
                        <tr>
                            <th>Prenom</th>
                            <th>Nom</th>
                            <th>Login</th>
                            <th>Role</th>
                            <th>Photo</th>
                            <th>Action</th>
                            <th>Action</th>
                        </tr>
                    <tbody>
                        <c:forEach items="${users}" var="u">
                            <tr>
                                <td> ${u.prenom}</td>
                                <td> ${u.nom}</td>
                                <td> ${u.login}</td>
                                <td> ${u.role.libelle}</td>
                                <td><img src='images/${u.photo}'/></td>
                                <td><a class="btn btn-danger" href="http://localhost:31374/autoFormation/user?action=delete&id=${u.id}" onclick='javascript:return confirmation();'>delete</a></td>
                                <td><a class="btn btn-info" href="http://localhost:31374/autoFormation/user?action=edit&id=${u.id}">update</a></td>
                            </tr>

                        </c:forEach>
                    </tbody>
                    </thead>
            </form>
            
        </table>
            ${message}
            ${messagedel}
            <a href="?action=inscription"><button class="btn btn-success">Ajouter</button></a>
       </div>
       
       
       <script src="text/javascript">
                 function confirmation()
                    {
                        return confirm("voulez vous supprimez ?");
                    }
        </script>
    </body>
</html>
