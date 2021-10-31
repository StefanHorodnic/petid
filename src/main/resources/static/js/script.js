function updateBreedSelect() {

    $("#breedSelect").empty();

    var speciesId = $("#speciesSelect").val();

    $.get("/breedBySpeciesId?speciesId=" + speciesId, function(data){
        $("#breedSelect").prop("disabled", false);
        $.each(data, function(key, value){
            var option = "<option value = " + key + ">" + value +  "</option>";
            $("#breedSelect").append(option);
        });
    });

};