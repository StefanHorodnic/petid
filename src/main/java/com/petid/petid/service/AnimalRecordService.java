package com.petid.petid.service;

import com.petid.petid.model.Animal;
import com.petid.petid.model.AnimalRecord;
import com.petid.petid.repository.AnimalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalRecordService {

    @Autowired
    AnimalRecordRepository animalRecordRepository;

    public void save(AnimalRecord animalRecord){
        animalRecordRepository.save(animalRecord);
    }

    public List<AnimalRecord> findAllByAnimal(Animal animal){
        return animalRecordRepository.findAllByAnimal(animal);
    }
}
