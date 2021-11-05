package com.petid.petid.service;

import com.petid.petid.model.Animal;
import com.petid.petid.model.Owner;
import com.petid.petid.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public Owner addOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner findById(UUID id){
        return ownerRepository.findById(id).orElseThrow();
    }

    public Owner findBySocialSecurityNumber(String socialSecurityNumber){
        return ownerRepository.findBySocialSecurityNumber(socialSecurityNumber).orElseThrow();
    }

}
