package com.petid.petid;

import com.petid.petid.model.*;
import com.petid.petid.repository.AnimalRepository;
import com.petid.petid.repository.BreedRepository;
import com.petid.petid.repository.OwnerRepository;
import com.petid.petid.repository.SpeciesRepository;
import com.petid.petid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitialData {

    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private SpeciesRepository speciesRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        Species canine = new Species("Canină");
        Species feline = new Species("Felină");

        speciesRepository.save(canine);
        speciesRepository.save(feline);

        Breed ciobanescGerman = new Breed(canine, "Ciobănesc german");
        Breed europeana = new Breed(feline, "Europeană");

        breedRepository.save(ciobanescGerman);
        breedRepository.save(new Breed(canine, "Beagle"));
        breedRepository.save(new Breed(canine, "Poodle"));
        breedRepository.save(europeana);
        breedRepository.save(new Breed(feline, "Persană"));

        Owner owner = new Owner("1234567891234", "Stefan", "Horodnic", "Cluj-Napoca", "0743510638", "stefanhorodnic@yahoo.com");
        Owner owner2 = new Owner("1234567891235", "Andrei", "Porgras", "Iași", "0732564376", "andreiporgras@yahoo.com");

        ownerRepository.save(owner);
        ownerRepository.save(owner2);

        User user = new User("123", "stefan", "Ștefan Horodnic");

        userService.save(user);
        userService.save(new User("456","andrei", "Andrei Porgras"));

        animalRepository.save(new Animal("Maya", LocalDate.of(2014,04,15), Sex.Femelă, canine,
                ciobanescGerman, true, "", "", "", owner, user));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,04,15), Sex.Mascul, canine,
                ciobanescGerman, true, "", "", "", owner2,user));
        animalRepository.save(new Animal("Luna", LocalDate.of(2014,04,15), Sex.Femelă, feline,
                europeana, true, "", "", "", owner,user));
        animalRepository.save(new Animal("Tom", LocalDate.of(2014,04,15), Sex.Mascul, feline,
                europeana, true, "", "", "", owner2,user));
    }
}