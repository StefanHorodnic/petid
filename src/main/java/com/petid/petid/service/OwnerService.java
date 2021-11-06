package com.petid.petid.service;

import com.petid.petid.model.Owner;
import com.petid.petid.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private static Map<CsrfToken, Owner> ownersBuffer = new HashMap<>();

    @Autowired
    OwnerRepository ownerRepository;

    public Owner save(Owner owner){
        return ownerRepository.save(owner);
    }

    public Optional<Owner> findById(UUID id){
        return ownerRepository.findById(id);
    }

    public Optional<Owner> findBySocialSecurityNumber(String socialSecurityNumber){
        return ownerRepository.findBySocialSecurityNumber(socialSecurityNumber);
    }

    public static Map<CsrfToken, Owner> getOwnersBuffer() {
        return ownersBuffer;
    }
}
