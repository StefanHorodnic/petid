package com.petid.petid;

import com.petid.petid.model.Breed;
import com.petid.petid.model.Species;
import com.petid.petid.model.User;
import com.petid.petid.repository.BreedRepository;
import com.petid.petid.repository.SexRepository;
import com.petid.petid.repository.SpeciesRepository;
import com.petid.petid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InitialData {

    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private SexRepository sexRepository;
    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private UserService userService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        Species canine = new Species("Canină");
        Species feline = new Species("Felină");

        speciesRepository.save(canine);
        speciesRepository.save(feline);

        breedRepository.save(new Breed(canine, "Ciobănesc german"));
        breedRepository.save(new Breed(canine, "Beagle"));
        breedRepository.save(new Breed(canine, "Poodle"));
        breedRepository.save(new Breed(feline, "Europeană"));
        breedRepository.save(new Breed(feline, "Persană"));

        userService.save(new User("123", "stefan", "Ștefan Horodnic"));
        userService.save(new User("456","andrei", "Andrei Porgras"));
    }
}
