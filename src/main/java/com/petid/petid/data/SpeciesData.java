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
    private SpeciesRepository speciesRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        speciesRepository.save(new Species("Canină"));
        speciesRepository.save(new Species("Felină"));
    }

}
