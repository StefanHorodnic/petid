package com.petid.petid.repository;

import com.petid.petid.model.Animal;
import com.petid.petid.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecordRepository extends JpaRepository<Record, UUID> {
    List<Record> findAllByAnimal(Animal animal);
}

