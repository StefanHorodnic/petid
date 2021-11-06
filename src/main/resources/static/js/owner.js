function ownerBySocialSecurityNumber(){

    /* get the value from the social security number text input */
    var socialSecurityNumber = $("#socialSecurityNumber").val();

    $.get("/ownerBySocialSecurityNumber?socialSecurityNumber=" + socialSecurityNumber, function(data){
        if(data.id==null){
            $("#lastName").prop("disabled", false);
            $("#firstName").prop("disabled", false);
            $("#address").prop("disabled", false);
            $("#phone").prop("disabled", false);
            $("#email").prop("disabled", false);

            $("#lastName").prop("value", "");
            $("#firstName").prop("value", "");
            $("#address").prop("value", "");
            $("#phone").prop("value", "");
            $("#email").prop("value", "");
        }
        else{
            $("#lastName").prop("disabled", true);
            $("#firstName").prop("disabled", true);
            $("#address").prop("disabled", true);
            $("#phone").prop("disabled", true);
            $("#email").prop("disabled", true);

            $("#lastName").prop("value", data.lastName);
            $("#firstName").prop("value", data.firstName);
            $("#address").prop("value", data.address);
            $("#phone").prop("value", data.phone);
            $("#email").prop("value", data.email);
        }
    });
};