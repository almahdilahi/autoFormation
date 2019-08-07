function imageIsLoaded(e) {
    //$("#file").css("color","green");
    //$('#image_preview').css("display", "block");
    $('#image').attr('src', e.target.result);
    $('#image').attr('width', '300px');
    $('#image').attr('height', '300px');
};
$('#photo').change(function () {
    
    var assetsBaseDir = "C://Users/HP/Documents/NetBeansProjects/autoFormation/src/main/webapp/images/";


    $("#message").empty(); // To remove the previous error message
    var file = this.files[0];

    var imagefile = file.type;
    alert(imagefile);
    var match = ["image/jpeg", "image/png", "image/jpg"];
    if (!((imagefile == match[0]) || (imagefile == match[1]) || (imagefile == match[2]))) {
        //alert('no match');
        $('#image').attr('src', assetsBaseDir + 'default.png');
        $("#message").html("Selectionner une image valide, Note : Seules jpeg, jpg and png Images sont autorisé");
        return false;
    } else {
        alert('match');
        var reader = new FileReader();
        reader.onload = imageIsLoaded;
        reader.readAsDataURL(this.files[0]);
    }
});