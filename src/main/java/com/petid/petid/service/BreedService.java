package com.petid.petid.service;

import com.petid.petid.model.Breed;
import com.petid.petid.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreedService {

    //Fields
    @Autowired
    private BreedRepository breedRepository;


    //Public methods
    public Breed addBreed(Breed breed){
        return breedRepository.save(breed);
    }

    public List<Breed> findAllBreeds(){
        return breedRepository.findAll();
    }

    public Breed updateBreed(Breed breed){
        return breedRepository.save(breed);
    }

    public void deleteBreedbyId(int id){
        breedRepository.deleteById(id);
    }

    public Breed findBreedbyId(int id){
        return breedRepository.findById(id).orElseThrow();
    }
}
