package com.petid.petid.controller;

import com.petid.petid.model.*;
import com.petid.petid.service.AnimalRecordService;
import com.petid.petid.service.AnimalService;
import com.petid.petid.service.SmsService;
import com.petid.petid.service.SpeciesService;
import com.petid.petid.userdetails.UserDetailsCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"animal","owner"})
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    @Autowired
    private SpeciesService speciesService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private AnimalRecordService animalRecordService;

    @PostMapping("/add-animal/animal-information")
    public String addAnimal(@Valid Animal animal, BindingResult bindingResult,
                            Model model, @RequestParam(name="photo", required = false) MultipartFile photo,
                            @AuthenticationPrincipal UserDetailsCustom user, SessionStatus sessionStatus) {

        System.out.println("This is in add");

        model.addAttribute("animal", animal);
        model.addAttribute("allSpecies", speciesService.findAll());

        if(bindingResult.hasErrors()){
            return "animals/add-animal/animal-information";
        }

        System.out.println(photo);

        if(photo != null) {
            animal.setPhoto(photo);
        }

        animal.setUser(user.getUser());

        animalService.save(animal);

        //smsService.sendAnimalSavedSms(animal);

        sessionStatus.setComplete();

        return "redirect:/animals";
    }

    @GetMapping("/add-animal/animal-information")
    public String addAnimalInformation(Animal animal, @SessionAttribute(name = "owner", required = false)Owner owner, Model model, HttpSession session) {

        if(owner == null || owner.getId() == null){
            return "redirect:/add-animal/owner-information";
        }

        if(model.containsAttribute("animal")) {
            animal = (Animal) model.getAttribute("animal");
        }

        animal.setOwner(owner);

        model.addAttribute("allSpecies", speciesService.findAll());
        model.addAttribute("animal", animal);
        model.addAttribute("action", "add");

        return "animals/add-animal/animal-information";
    }

    @RequestMapping("/animals")
    public String animals(Model model) {

        model.addAttribute("animals", animalService.findAll());

        return "animals/animals";
    }

    @RequestMapping("animal/{microchip}")
    public String animal(@PathVariable("microchip") String microchip, Model model, SessionStatus sessionStatus) {

        Optional<Animal> animal = animalService.findByMicrochip(microchip);

        if(animal.isPresent()){

            model.addAttribute("animal", animal.get());

            List<AnimalRecord> animalRecords = animalRecordService.findAllByAnimal(animal.get());

            model.addAttribute("animalRecords", animalRecords);

            sessionStatus.setComplete();

            return "animals/animal";
        }
        else{
            return "redirect:/animals";
        }
    }

    @RequestMapping("/edit-animal/{microchip}")
    public String editAnimalInformation(@PathVariable("microchip") String microchip, Model model, SessionStatus sessionStatus){

        Optional<Animal> animal = animalService.findByMicrochip(microchip);

        if(animal.isPresent()){

            model.addAttribute("allSpecies", speciesService.findAll());
            model.addAttribute("animal", animal.get());
            model.addAttribute("action", "edit");

            sessionStatus.setComplete();

            return "animals/add-animal/animal-information";
        }
        else{
            return "redirect:/animals";
        }
    }

    @PostMapping("/edit-animal/animal-information")
    public String editAnimalPost(@Valid Animal animal, BindingResult bindingResult, Model model, @RequestParam(name="photo", required = false) MultipartFile photo,
                                 SessionStatus sessionStatus) {

        model.addAttribute("animal", animal);
        model.addAttribute("allSpecies", speciesService.findAll());

        if(bindingResult.hasErrors()){
            return "animals/add-animal/animal-information";
        }

        Animal editedAnimal = animalService.findById(animal.getId()).get();

        editedAnimal.setName(animal.getName());
        editedAnimal.setBreed(animal.getBreed());
        editedAnimal.setSpecies(animal.getSpecies());
        editedAnimal.setColor(animal.getColor());
        editedAnimal.setDistinctiveMarks(animal.getDistinctiveMarks());
        editedAnimal.setDateOfBirth(animal.getDateOfBirth());
        editedAnimal.setNeutered(animal.isNeutered());
        editedAnimal.setSex(animal.getSex());
        editedAnimal.setPhoto(photo);

        animalService.save(editedAnimal);

        sessionStatus.setComplete();

        return "redirect:/animals";
    }
}
