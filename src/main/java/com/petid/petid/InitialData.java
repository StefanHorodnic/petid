package com.petid.petid;

import com.petid.petid.model.*;
import com.petid.petid.repository.AnimalRepository;
import com.petid.petid.repository.BreedRepository;
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

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        Species canine = new Species("Canină");
        Species feline = new Species("Felină");

        speciesRepository.save(canine);
        speciesRepository.save(feline);

        Breed ciobanescGerman = new Breed(canine, "Ciobănesc german");

        breedRepository.save(ciobanescGerman);
        breedRepository.save(new Breed(canine, "Beagle"));
        breedRepository.save(new Breed(canine, "Poodle"));
        breedRepository.save(new Breed(feline, "Europeană"));
        breedRepository.save(new Breed(feline, "Persană"));

        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));
        animalRepository.save(new Animal("Bubico", LocalDate.of(2014,3,16), Sex.Mascul, canine, ciobanescGerman,true, "alb", "", "6420934125678"));


        userService.save(new User("123", "stefan", "Ștefan Horodnic"));
        userService.save(new User("456","andrei", "Andrei Porgras"));
    }
}
