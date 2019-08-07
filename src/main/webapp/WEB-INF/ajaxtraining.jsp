<%-- 
    Document   : ajaxtraining
    Created on : 6 août 2019, 04:04:36
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
        <%@include file="../css/inscription.css" %>
     </style>
     <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
        
    <script type="text/javascript">
            $(document).ready(function () {
                //alert("ok");
                $client = $("#cin");
                $client.on("change", function () {
                    $v_cin = $client.val();
                    //alert($v_cin);
                    $.ajax({
                        url: "http://localhost:31374/autoFormation/user?action=ajaxtraining&id=" + $v_cin,
                        dataType: "json",
                        success: function (json) {
                            $.each(json, function (index, value) {
                                //alert(value);
                                if (index == 1)
                                    $("#nom").val(value);
								if(value != null){
								$("#nom").attr('readonly','readonly');
								//$("#nom").attr('disabled','disabled');
								}
                                if (index == 2)
                                    $("#prenom").val(value);
								if(value != null){
								$("#prenom").attr('readonly','readonly');
								//$("#prenom").attr('disabled','disabled');
								}
                                if (index == 3)
                                    $("#photo").val(value);
								if(value != null){
								$("#photo").attr('readonly','readonly');
								//$("#nomCV").attr('disabled','disabled');
								}
                                if (index == 4)
                                    $("#image").val(value);
								if(value != null){
								$("#image").attr('readonly','readonly');
								//$("#village").attr('disabled','disabled');
								}
                                if (index == 5)
                                    $("#role").val(value);
								if(value != null){
								$("#role").attr('readonly','readonly');
								//$("#adresse").attr('disabled','disabled');
								}
                                
                            });
                        }
                    });
                });
            });
            //alert("ok")
        </script>
    
    </head>
    <body>
         <div class="container">
            <div class="row mb-10">
            <form action="" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="action" value="ajaxtraining"/>
           
            <div class="form-group">
            
                <input class="form-control" type="text" name="cin" placeholder="CIN" required="true">
            </div>
            
             <div class="form-group">
                
                <input class="form-control" type="text" name="nom" placeholder="Nom" required="true">
            </div>
            
            <div class="form-group">
                
                <input class="form-control" type="text" name="prenom" placeholder="Prenom" required="true">
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
                <input class="btn btn-primary" type="submit" name="valider" value="valider">
            </div>
        </form>
               ${message}  
        
            </div>
        </div>
    </body>
</html>
