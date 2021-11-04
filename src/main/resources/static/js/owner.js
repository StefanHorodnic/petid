function ownerBySocialSecurityNumber(){

    /* get the value from the social security number text input */
    var socialSecurityNumber = $("#socialSecurityNumber").val();

    $.get("/ownerBySocialSecurityNumber?socialSecurityNumber=" + socialSecurityNumber,
        function(data){
             console.log(data);
        });
};