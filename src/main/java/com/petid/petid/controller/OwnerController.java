package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/ownerBySocialSecurityNumber")
    @ResponseBody
    public Owner getOwnerBySocialSecurityNumber(@RequestParam("socialSecurityNumber") String socialSecurityNumber){
        Owner owner = new Owner();
        try{
            owner = ownerService.findBySocialSecurityNumber(socialSecurityNumber);
        }
        catch (Exception e){

        }
        return owner;
    }

    @PostMapping("/add-animal/owner-information")
    public String selectOwner(
            @Param("socialSecurityNumber") String socialSecurityNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("address") String address,
            @Param("phone") String phone,
            @Param("email") String email,
            Model model){

        Owner owner = new Owner(socialSecurityNumber, firstName, lastName, address, phone, email);

        model.addAttribute("owner",owner);

        return "animals/add-animal/animal-information";
    }

    @GetMapping("/add-animal/owner-information")
    public String ownerInformation(Owner owner, Model model) {
        return "animals/add-animal/owner-information";
    }

}
