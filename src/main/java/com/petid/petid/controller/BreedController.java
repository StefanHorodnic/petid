package com.petid.petid.controller;

import com.petid.petid.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class BreedController {

    @Autowired
    BreedService breedService;

    @GetMapping("/breedBySpeciesId")
    @ResponseBody
    public HashMap<Integer, String> getBreedBySpeciesId(@RequestParam("speciesId") int speciesId){
        return breedService.findAllBySpeciesId(speciesId);
    }

}
