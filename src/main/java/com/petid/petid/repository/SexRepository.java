package com.petid.petid.repository;

import com.petid.petid.model.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository extends JpaRepository<Sex, Integer> {
}
