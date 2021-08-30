package com.petid.petid.controller;

import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class SpeciesController {

    //Fields
    @Autowired
    private final SpeciesService speciesService;

    //Constructor
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    //Public methods
//    @ModelAttribute("allSpecies")
//    public List<Species> getAllSpecies(Model model) {
//        return speciesService.findAllSpecies();
//    }
//
//    @RequestMapping(value = "/species/all", method = RequestMethod.GET)
//    public ResponseEntity<List<Species>> getAllSpecies() {
//        List<Species> animals = speciesService.findAllSpecies();
//        return new ResponseEntity<>(animals, HttpStatus.OK);
//    }


}
