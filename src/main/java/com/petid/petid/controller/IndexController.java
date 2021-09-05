package com.petid.petid.controller;

import com.petid.petid.model.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value={"/", "/index"})
    public String showAddForm(Animal animal, Model model) {
        if(true)
        {
            return "login";
        }
        else{
            return "index";
        }
    }

}
