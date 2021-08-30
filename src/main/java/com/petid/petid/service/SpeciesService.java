package com.petid.petid.service;

import com.petid.petid.model.Species;
import com.petid.petid.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    //Fields
    private final SpeciesRepository speciesRepository;

    //Constructor
    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    //Public methods

    public List<Species> findAllSpecies(){
        return speciesRepository.findAll();
    }

    public Species findSpeciesById(int id){
        return speciesRepository.findById(id).orElseThrow();
    }
}
