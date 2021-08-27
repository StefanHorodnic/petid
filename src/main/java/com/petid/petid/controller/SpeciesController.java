package com.petid.petid.controller;

import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    //Fields
    private final SpeciesService speciesService;

    //Constructor
    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    //Public methods
    @GetMapping("/allSpecies")
    public String getAllSpecies(Model model) {
        model.addAttribute("allSpecies", speciesService.findAllSpecies());
        return "allSpecies";
    }


}
