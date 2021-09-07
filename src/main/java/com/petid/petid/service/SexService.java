package com.petid.petid.service;

import com.petid.petid.model.Sex;
import com.petid.petid.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexService {

    @Autowired
    private SexRepository sexRepository;

    public List<Sex> findAll() { return sexRepository.findAll(); }

    public Sex findById(int id) {return sexRepository.findById(id).orElseThrow();}

}
