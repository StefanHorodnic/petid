package com.petid.petid.controller;

import com.petid.petid.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

}
