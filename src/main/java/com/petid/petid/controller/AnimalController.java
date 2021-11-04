package com.petid.petid.controller;

import com.petid.petid.model.Animal;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private SpeciesService speciesService;


    @PostMapping("/addAnimal")
    public String addAnimal(@Valid Animal animal) {
        animalService.addAnimal(animal);
        return "redirect:/index";
    }

    @GetMapping(value={"/index"})
    public String addAnimalForm(Animal animal, Model model) {
        model.addAttribute("allSpecies", speciesService.findAll());
        model.addAttribute("animals", animalService.findAllAnimals());
        return "/index";
    }
}
