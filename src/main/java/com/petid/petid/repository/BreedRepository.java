package com.petid.petid.repository;

import com.petid.petid.model.Breed;
import com.petid.petid.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BreedRepository extends JpaRepository<Breed, UUID> {

    List<Breed> findAllBySpecies(Species species);

    Breed findByName(String name);
}
