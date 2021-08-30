package com.petid.petid.controller;

import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpeciesController {

    //Fields
    @Autowired
    private final SpeciesService speciesService;

    //Constructor
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

}
