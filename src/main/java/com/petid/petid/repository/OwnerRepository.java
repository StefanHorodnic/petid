package com.petid.petid.repository;

import com.petid.petid.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner, UUID> {

    Optional<Owner> findBySocialSecurityNumber(String socialSecurityNumber);

}
