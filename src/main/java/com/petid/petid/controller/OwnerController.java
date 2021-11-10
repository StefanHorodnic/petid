package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@SessionAttributes("owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/ownerBySocialSecurityNumber")
    @ResponseBody
    public Owner getOwnerBySocialSecurityNumber(@RequestParam("socialSecurityNumber") String socialSecurityNumber){

        Optional<Owner> owner = ownerService.findBySocialSecurityNumber(socialSecurityNumber);

        return owner.orElse(new Owner());
    }

    @PostMapping("/add-animal/owner-information")
    public String selectOwner(@Valid Owner owner, BindingResult bindingResult, Model model){

        model.addAttribute("owner", owner);

        if(bindingResult.hasErrors()){
            return "animals/add-animal/owner-information";
        }

        if(!ownerService.findById(owner.getId()).isPresent()){
            ownerService.save(owner);
        }

        return "redirect:/add-animal/animal-information";
    }

    @RequestMapping("/add-animal/owner-information")
    public String ownerInformation(Owner owner, Model model) {

        if(model.containsAttribute("owner")){
            owner = (Owner)model.getAttribute("owner");
        }

        model.addAttribute("owner", owner);

        return "animals/add-animal/owner-information";
    }

}
