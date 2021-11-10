package com.petid.petid.controller;

import com.petid.petid.model.*;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.SpeciesService;
import com.petid.petid.userdetails.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import javax.validation.Valid;

@Controller
@SessionAttributes("animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private SpeciesService speciesService;

    @PostMapping("/add-animal/animal-information")
    public String addAnimal(@Valid Animal animal, BindingResult bindingResult,
                            Model model, @AuthenticationPrincipal UserDetailsCustom user, SessionStatus sessionStatus) {

        model.addAttribute("animal", animal);

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "animals/add-animal/animal-information";
        }

        animal.setUser(user.getUser());

        animalService.save(animal);

        sessionStatus.setComplete();

        return "redirect:/animals";
    }

    @GetMapping("/add-animal/animal-information")
    public String animalInformation(Animal animal, @SessionAttribute("owner")Owner owner, Model model) {

        if(owner == null){
            return "redirect:/add-animal/owner-information";
        }

        if(model.containsAttribute("animal")) {
            animal = (Animal) model.getAttribute("animal");
        }

        animal.setOwner(owner);

        model.addAttribute("allSpecies", speciesService.findAll());
        model.addAttribute("animal", animal);

        return "animals/add-animal/animal-information";
    }

    @RequestMapping("/animals")
    public String index(Model model) {

        model.addAttribute("animals", animalService.findAllAnimals());

        return "animals/animals";
    }
}
