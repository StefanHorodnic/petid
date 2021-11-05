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
        //animalService.addAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/animals/add-animal/animal-information")
    public String animalInformation(Animal animal, Model model) {
        model.addAttribute("allSpecies", speciesService.findAll());
        return "animals/add-animal/animal-information";
    }

    @RequestMapping("/animals")
    public String index(Animal animal, Model model) {
        model.addAttribute("animals", animalService.findAllAnimals());
        return "animals/animals";
    }
}
