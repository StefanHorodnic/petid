package com.petid.petid.controller;

import com.petid.petid.model.*;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.OwnerService;
import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("owner")
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private OwnerService ownerService;

    @ModelAttribute("owner")
    public Owner owner(){
        return new Owner();
    }

    @PostMapping("/add-animal/animal-information")
    public String addAnimal(
            @Param("name") String name,
            @Param("microchip") String microchip,
            @Param("species") Species species,
            @Param("breed") Breed breed,
            @Param("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
            @Param("sex") Sex sex,
            @Param("neutered") boolean neutered,
            @Param("color") String color,
            @Param("distinctiveMarks") String distinctiveMarks,
            Model model) {

        Owner bufferedOwner = (Owner) model.getAttribute("owner");

        if(bufferedOwner.getId()==null){
            ownerService.save(bufferedOwner);
        }

        Animal animal = new Animal(name, dateOfBirth, sex, species, breed, neutered, color, distinctiveMarks, microchip, bufferedOwner);

        animalService.save(animal);



        return "redirect:/animals";
    }

    @GetMapping("/add-animal/animal-information")
    public String animalInformation(Animal animal, Model model) {

        Owner owner = (Owner) model.getAttribute("owner");

        if(owner==null){
            return "redirect:/add-animal/owner-information";
        }

        model.addAttribute("allSpecies", speciesService.findAll());
        model.addAttribute("ownerFullName", owner.getLastName()+" "+owner.getFirstName());

        return "animals/add-animal/animal-information";
    }

    @RequestMapping("/animals")
    public String index(Animal animal, Model model) {
        model.addAttribute("animals", animalService.findAllAnimals());
        return "animals/animals";
    }
}
