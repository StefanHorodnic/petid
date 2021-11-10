package com.petid.petid.controller;

import com.petid.petid.model.Species;
import com.petid.petid.service.BreedService;
import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class BreedController {

    @Autowired
    BreedService breedService;
    @Autowired
    SpeciesService speciesService;

    @GetMapping("/breedBySpeciesId")
    @ResponseBody
    public Map<UUID, String> getBreedBySpeciesId(@RequestParam("speciesId") UUID speciesId){
        Species species = speciesService.findById(speciesId);
        return breedService.findAllBySpecies(species);
    }

}
