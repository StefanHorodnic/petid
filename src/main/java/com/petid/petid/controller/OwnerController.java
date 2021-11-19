package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

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
    public String addOwnerPost(@Valid Owner owner, BindingResult bindingResult, Model model){

        model.addAttribute("owner", owner);
        model.addAttribute("action", "add");

        if(bindingResult.hasErrors()){
            return "owner-information";
        }

        if(owner.getId()==null) {
            ownerService.save(owner);
        }

        return "redirect:/add-animal/animal-information";
    }

    @RequestMapping("/add-animal/owner-information")
    public String addOwnerGet(Owner owner, Model model) {

        if(model.containsAttribute("owner")){
            owner = (Owner)model.getAttribute("owner");
        }

        model.addAttribute("owner", owner);
        model.addAttribute("action", "add");

        return "owner-information";
    }

    @RequestMapping("/edit-owner/{id}")
    public String editOwnerGet(@PathVariable("id") UUID id, Model model) {

        Owner owner = ownerService.findById(id).get();

        model.addAttribute("owner", owner);
        model.addAttribute("action", "edit");

        return "owner-information";
    }

    @PostMapping("/edit-owner/owner-information")
    public String editOwnerPost(@Valid Owner owner, BindingResult bindingResult, Model model, SessionStatus sessionStatus){

        model.addAttribute("owner", owner);
        model.addAttribute("action", "edit");

        Optional<Owner> oldOwner = ownerService.findBySocialSecurityNumber(owner.getSocialSecurityNumber());

        if(oldOwner.isPresent() && !oldOwner.get().getId().equals(owner.getId())){
            bindingResult.addError(new FieldError("owner", "socialSecurityNumber", "C.N.P. existent în baza de date"));
        }

        if(bindingResult.hasErrors()){
            return "owner-information";
        }

        ownerService.save(owner);

        sessionStatus.setComplete();

        return "redirect:/animals";
    }

}
