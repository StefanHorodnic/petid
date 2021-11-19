package com.petid.petid.service;

import com.petid.petid.model.Animal;
import com.petid.petid.model.Record;
import com.petid.petid.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecordService {

    @Autowired
    RecordRepository recordRepository;

    public void save(Record record){
        recordRepository.save(record);
    }

    public List<Record> findAllByAnimal(Animal animal){
        return recordRepository.findAllByAnimal(animal);
    }

    public Optional<Record> findById(UUID id){
        return recordRepository.findById(id);
    }

    public void delete(Record record){
        recordRepository.delete(record);
    }
}
