package com.petid.petid.repository;

import com.petid.petid.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {

    Optional<Animal> findByMicrochip(String microchip);
}
