package com.petid.petid.data;

import com.petid.petid.model.Breed;
import com.petid.petid.repository.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BreedData {

    @Autowired
    private BreedRepository breedRepository;


    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        breedRepository.save(new Breed(1, "Ciobănesc german"));
        breedRepository.save(new Breed(1, "Beagle"));
        breedRepository.save(new Breed(1, "Poodle"));
        breedRepository.save(new Breed(2, "Europeană"));
        breedRepository.save(new Breed(2, "Persană"));
    }
}
