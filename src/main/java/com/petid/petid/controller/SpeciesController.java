package com.petid.petid.controller;

import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

}
