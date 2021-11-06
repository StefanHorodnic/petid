package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;
import java.util.UUID;

@Controller
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
    public RedirectView selectOwner(
            @Param("id") String id,
            @Param("socialSecurityNumber") String socialSecurityNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("address") String address,
            @Param("phone") String phone,
            @Param("email") String email,
            RedirectAttributes attributes){

        Owner owner = new Owner();

        try{
            UUID uUID = UUID.fromString(id);
            owner = ownerService.findById(uUID).orElseThrow();
        }
        catch (Exception e){
            owner = new Owner(socialSecurityNumber, firstName, lastName, address, phone, email);
        }
        finally {
            attributes.addFlashAttribute("owner", owner);

            return new RedirectView("/add-animal/animal-information");
        }
    }

    @GetMapping("/add-animal/owner-information")
    public String ownerInformation(Owner owner, Model model) {
        return "animals/add-animal/owner-information";
    }

}
