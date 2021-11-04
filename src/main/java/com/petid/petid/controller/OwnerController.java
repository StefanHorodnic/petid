package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/ownerBySocialSecurityNumber")
    @ResponseBody
    public Owner getOwnerBySocialSecurityNumber(@RequestParam("socialSecurityNumber") String socialSecurityNumber){
        Owner owner = new Owner();
        owner = ownerService.findBySocialSecurityNumber(socialSecurityNumber);
        return owner;
    }

    @PostMapping("/add-animal/owner-information")
    public String selectOwner(@Valid Owner owner, Model model){
        return "redirect:/animals/add-animal/animal-information";
    }

    @GetMapping("/add-animal/owner-information")
    public String ownerInformation(Owner owner, Model model) {
        return "animals/add-animal/owner-information";
    }

}
