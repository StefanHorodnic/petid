package com.petid.petid.service;

import com.petid.petid.model.Breed;
import com.petid.petid.model.Species;
import com.petid.petid.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BreedService {

    @Autowired
    private BreedRepository breedRepository;

    public List<Breed> findAllBreeds(){
        return breedRepository.findAll();
    }

    public Breed findBreedbyId(UUID id){
        return breedRepository.findById(id).orElseThrow();
    }

    public HashMap<UUID, String> findAllBySpecies(Species species){
        List<Breed> breeds = breedRepository.findAllBySpecies(species);
        HashMap<UUID, String> breedsHashMap = new HashMap<>();
        for (Breed breed:breeds) {
            breedsHashMap.put(breed.getId(), breed.getName());
        }
        return breedsHashMap;
    }
}
