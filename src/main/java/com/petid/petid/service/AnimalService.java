package com.petid.petid.service;

import com.petid.petid.model.Animal;
import com.petid.petid.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    //Fields
    @Autowired
    private AnimalRepository animalRepository;


    //Public methods
    public Animal addAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public List<Animal> findAllAnimals(){
        return animalRepository.findAll();
    }

    public Animal updateAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    public void deleteAnimalbyId(UUID id){
        animalRepository.deleteById(id);
    }

    public Animal findAnimalbyId(UUID id){
        return animalRepository.findById(id).orElseThrow();
    }

}
