package com.petid.petid.repository;

import com.petid.petid.model.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

    List<Breed> findAllBySpeciesId(int speciesId);
}
