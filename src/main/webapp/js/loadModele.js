$(document).ready(function () {
    var libelle = $('#marque').val();
    $('#modele').change(function(){
        $.ajax({
        url: 'http://localhost:12295/projet1/user?action=loadModels',
        method: 'GET',
        dataType: 'json',
        data : {
           libelle : libelle
        },
        success: function(json){
          $('#modele').html('');
          $('#modele').append("<option value='0'>selectionnez un modele</option>");
            for (var variable in json) {
                $('#modele').append("<option value='"+json[variable].libelle+"'>"+json[variable].libelle+"</option>");
            }
        }
    });
    });
});

