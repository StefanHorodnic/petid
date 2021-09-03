package com.petid.petid.controller;

import com.petid.petid.model.Animal;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.BreedService;
import com.petid.petid.service.SexService;
import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private BreedService breedService;
    @Autowired
    private SexService sexService;

    @GetMapping(value={"/","/animal"})
    public String showAddForm(Animal animal, Model model) {
        model.addAttribute("allSpecies", speciesService.findAllSpecies());
        //model.addAttribute("allBreeds", breedService.findAllBreeds());
        model.addAttribute("allSexes", sexService.findAll());
        return "/animal";
    }

    @GetMapping("/allAnimals")
    public String getAllAnimals(Model model) {
        model.addAttribute("animals", animalService.findAllAnimals());
        return "allAnimals";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@Valid Animal animal, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "/animal";
        }

        animalService.addAnimal(animal);

        return "redirect:/animal";
    }
}
