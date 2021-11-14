package com.petid.petid.service;

import com.petid.petid.model.Breed;
import com.petid.petid.model.Species;
import com.petid.petid.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public Breed findByName(String name){
        return breedRepository.findByName(name);
    }

    public Map<UUID, String> findAllBySpecies(Species species){

        List<Breed> breeds = breedRepository.findAllBySpecies(species).stream().sorted(Comparator.comparing(Breed::getName)).collect(Collectors.toList());

        Map<UUID, String> breedsHashMap = new LinkedHashMap<>();

        for (Breed breed:breeds) {
            breedsHashMap.put(breed.getId(), breed.getName());
        }

        return breedsHashMap;
    }
}
