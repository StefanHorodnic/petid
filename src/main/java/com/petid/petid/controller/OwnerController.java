package com.petid.petid.controller;

import com.petid.petid.model.Owner;
import com.petid.petid.service.OwnerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.Random;
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

    @GetMapping("/bufferedOwner")
    @ResponseBody
    public Owner getBufferedOwner(HttpServletRequest request){

        CsrfToken csrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);

        return OwnerService.getOwnersBuffer().get(csrfToken);
    }

    @PostMapping("/add-animal/owner-information")
    public String selectOwner(
            @Param("socialSecurityNumber") String socialSecurityNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("address") String address,
            @Param("phone") String phone,
            @Param("email") String email,
            Model model, HttpServletRequest request){

        CsrfToken csrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);

        Owner owner = ownerService.findBySocialSecurityNumber(socialSecurityNumber).orElse(new Owner(socialSecurityNumber, firstName, lastName, address, phone, email));

        OwnerService.getOwnersBuffer().put(csrfToken, owner);

        return "redirect:/add-animal/animal-information";
    }

    @GetMapping("/add-animal/owner-information")
    public ModelAndView ownerInformation(Owner owner, Model model, HttpServletRequest request) {

        CsrfToken csrfToken = new HttpSessionCsrfTokenRepository().loadToken(request);

        owner = OwnerService.getOwnersBuffer().get(csrfToken);

        model.addAttribute("owner", owner);

        return new ModelAndView("animals/add-animal/owner-information");
    }

}
