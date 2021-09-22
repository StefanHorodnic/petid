package com.petid.petid.repository;

import com.petid.petid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //ToDo intreaba la curs!
    User getUserByStampNumber(String stampNumber);
}
