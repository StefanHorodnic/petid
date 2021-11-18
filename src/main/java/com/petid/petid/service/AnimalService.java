package com.petid.petid.service;

import com.petid.petid.model.Animal;
import com.petid.petid.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {

    //Fields
    @Autowired
    private AnimalRepository animalRepository;


    //Public methods
    public Animal save(Animal animal){
        return animalRepository.save(animal);
    }

    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    public void deleteById(UUID id){
        animalRepository.deleteById(id);
    }

    public Optional<Animal> findById(UUID id){
        return animalRepository.findById(id);
    }

    public Optional<Animal> findByMicrochip(String microchip) {
        return animalRepository.findByMicrochip(microchip);
    }
}
