$(document).ready(function(){
    $('#dateOfBirth').datepicker({
        format: 'dd.mm.yyyy'
    });

    updateBreedSelect();
})

function updateBreedSelect() {

    $("#breed").empty();

    var speciesId = $("#species").val();

    $.get("/breedBySpeciesId?speciesId=" + speciesId, function(data){
/*      $("#breed").prop("disabled", false);*/
        $.each(data, function(key, value){
            var option = "<option value = " + key + ">" + value +  "</option>";
            $("#breed").append(option);
        });
    });
};