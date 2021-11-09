function ownerBySocialSecurityNumber(){

    socialSecurityNumber = $("#socialSecurityNumber").val();

    $.get("/ownerBySocialSecurityNumber?socialSecurityNumber=" + socialSecurityNumber, function(data){
        if(data.id==null){
            $("#lastName").prop("readonly", false);
            $("#firstName").prop("readonly", false);
            $("#address").prop("readonly", false);
            $("#phone").prop("readonly", false);
            $("#email").prop("readonly", false);

            document.getElementById("id").value = "";
            document.getElementById("lastName").value = "";
            document.getElementById("firstName").value = "";
            document.getElementById("address").value = "";
            document.getElementById("phone").value = "";
            document.getElementById("email").value = "";
        }
        else{
            $("#lastName").prop("readonly", true);
            $("#firstName").prop("readonly", true);
            $("#address").prop("readonly", true);
            $("#phone").prop("readonly", true);
            $("#email").prop("readonly", true);

            document.getElementById("id").value = data.id;
            document.getElementById("lastName").value = data.lastName;
            document.getElementById("firstName").value = data.firstName;
            document.getElementById("address").value = data.address;
            document.getElementById("phone").value = data.phone;
            document.getElementById("email").value = data.email;
        }
    });
};