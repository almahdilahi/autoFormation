<%-- 
    Document   : edit
    Created on : 5 août 2019, 21:57:08
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style type="text/css">
        <%@include file="../css/bootstrap.css" %>
        <%@include file="../css/edit.css" %>
        </style>
        <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="row mb-10">
                
                    <form action="" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="action" value="edit"/>
                        
                    <c:forEach items="${users}" var="u">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <div class="form-group">
                            <label>Nom</label>
                            <input class="form-control" value="${u.nom}" name="nom" required="true">
                        </div>     
                        <div class="form-group">
                            <label>Prenom</label>
                            <input class="form-control" value="${u.prenom}" name="prenom" required="true">
                        </div>   
                        <div class="form-group">
                            <label>Login</label>
                            <input class="form-control" value="${u.login}" name="login" required="true">
                        </div>   
                        <div class="form-group">
                            <label>Password</label>
                            <input class="form-control" value="${u.password}" name="password" required="true">
                        </div> 
                        <div class="form-group">
                
                            <input class="btn btn-primary" type="file" name="photo" id="photo" >
                        </div>   
                        <div class="form-group">
                            <img src='images/user.jpg' width='100px' id="image">
                        </div>
            
                        <div class="form-group">
                            <select class="form-control" name="role" required="true" id="role">
                                <option value="">Selectionez un Role</option>
                                    <c:forEach items="${role}" var="r">
                                       <option value="${r.id}">${r.libelle}</option> 
                                    </c:forEach>
                            </select>
                        </div>   
                        <div class="form-group">
                            <center><button class="btn btn-primary ">Update</button></center>
                        </div>
                    </c:forEach>
                    </form>
                
                               ${message}  

            </div>
        </div>
    
    
    
        <script type="text/javascript">
        function imageIsLoaded(e) {
                        //$("#file").css("color","green");
                        //$('#image_preview').css("display", "block");
                        $('#image').attr('src', e.target.result);
                        $('#image').attr('width', '100px');
                        $('#image').attr('height', '100px');
                    };
                    $('#photo').change(function () {
                        //alert('ok');
                        var assetsBaseDir = "{{ asset('C://Users/HP/Documents/NetBeansProjects/autoFormation/src/main/webapp/images/') }}";

                        $("#message").empty(); // To remove the previous error message
                        var file = this.files[0];

                        var imagefile = file.type;
                        //alert(imagefile);
                        var match = ["image/jpeg", "image/png", "image/jpg"];
                        if (!((imagefile == match[0]) || (imagefile == match[1]) || (imagefile == match[2]))) {
                            //alert('no match');
                            $('#image').attr('src', assetsBaseDir + 'default.jpeg');
                            $("#message").html("Selectionner une image valide, Note : Seules jpeg, jpg and png Images sont autoris�");
                            return false;
                        } else {
                            //alert('match');
                            var reader = new FileReader();
                            reader.onload = imageIsLoaded;
                            reader.readAsDataURL(this.files[0]);
                        }
                    });
        </script>
    
    </body>
    
</html>
