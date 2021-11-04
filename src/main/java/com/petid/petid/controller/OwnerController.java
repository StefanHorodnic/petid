package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.model.Species;
import com.petid.petid.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.UUID;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/getOwnerIdBySocialSecurityNumber")
    @ResponseBody
    public UUID getBreedBySpeciesId(@RequestParam("socialSecurityNumber") String socialSecurityNumber){
        Owner owner = ownerService.findBySocialSecurityNumber(socialSecurityNumber);
        return owner.getId();
    }

}
