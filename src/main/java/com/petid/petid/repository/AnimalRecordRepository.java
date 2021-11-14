package com.petid.petid.repository;

import com.petid.petid.model.Animal;
import com.petid.petid.model.AnimalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalRecordRepository extends JpaRepository<AnimalRecord, UUID> {
    List<AnimalRecord> findAllByAnimal(Animal animal);
}

