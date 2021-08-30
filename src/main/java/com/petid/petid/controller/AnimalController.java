package com.petid.petid.controller;

import com.petid.petid.model.Animal;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private SpeciesService speciesService;

    @GetMapping("/addAnimalForm")
    public String showAddForm(Animal animal, Model model) {

        model.addAttribute("allSpecies", speciesService.findAllSpecies());

        return "animal/add";
    }

    //    @GetMapping("/all")
//    public ResponseEntity<List<Animal>> getAllAnimals() {
//        List<Animal> animals = animalService.findAllAnimals();
//        return new ResponseEntity<>(animals, HttpStatus.OK);
//    }
    @GetMapping("/allAnimals")
    public String getAllAnimals(Model model) {
        model.addAttribute("animals", animalService.findAllAnimals());
        return "allAnimals";
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Animal> getAnimalById(@PathVariable("id") int id) {
//        Animal animal = animalService.findAnimalbyId(id);
//        return new ResponseEntity<>(animal, HttpStatus.OK);
//    }

    //    @PostMapping("/add")
//    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
//        Animal newAnimal = animalService.addAnimal(animal);
//        return new ResponseEntity<>(newAnimal, HttpStatus.CREATED);
//    }

    @PostMapping("/addAnimal")
    public String addAnimal(@Valid Animal animal, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "animal/add";
        }

        animalService.addAnimal(animal);

        return "redirect:/index";
    }
}
