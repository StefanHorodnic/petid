package com.petid.petid.service;

import com.petid.petid.model.Breed;
import com.petid.petid.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BreedService {

    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> findAllBreeds(){
        return breedRepository.findAll();
    }

    public Breed findBreedbyId(int id){
        return breedRepository.findById(id).orElseThrow();
    }

    public HashMap<Integer, String> findAllBySpeciesId(int speciesId){
        List<Breed> breeds = breedRepository.findAllBySpeciesId(speciesId);
        HashMap<Integer, String> breedsHashMap = new HashMap<>();
        for (Breed breed:breeds) {
            breedsHashMap.put(breed.getId(), breed.getName());
        }
        return breedsHashMap;
    }
}
