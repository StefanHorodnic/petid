package com.petid.petid.data;

import com.petid.petid.model.Species;
import com.petid.petid.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SpeciesData {

    @Autowired
    private final SpeciesRepository speciesRepository;

    public SpeciesData(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        speciesRepository.save(new Species("Canină"));
        speciesRepository.save(new Species("Felină"));
    }

}
