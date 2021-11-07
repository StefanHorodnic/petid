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

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/add-animal/animal-information")
    public String addAnimal(
            @Param("name") String name,
            @Param("microchip") String microchip,
            @Param("species") Species species,
            @RequestParam("breed") Breed breed,
            @Param("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
            @Param("sex") Sex sex,
            @Param("neutered") boolean neutered,
            @Param("color") String color,
            @Param("distinctiveMarks") String distinctiveMarks,
            Model model, HttpServletRequest request) {

        CsrfToken csrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);

        Owner bufferedOwner = OwnerService.getOwnersBuffer().get(csrfToken);

        if(bufferedOwner.getId()==null){
            ownerService.save(bufferedOwner);
        }

        Animal animal = new Animal(name, dateOfBirth, sex, species, breed, neutered, color, distinctiveMarks, microchip, bufferedOwner);

        animalService.save(animal);

        OwnerService.getOwnersBuffer().remove(csrfToken);

        return "redirect:/animals";
    }

    @GetMapping("/add-animal/animal-information")
    public String animalInformation(Animal animal, Model model, HttpServletRequest request) {

        CsrfToken csrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);

        if(OwnerService.getOwnersBuffer().get(csrfToken)==null){
            return "redirect:/add-animal/owner-information";
        }

        Owner owner = OwnerService.getOwnersBuffer().get(csrfToken);

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
