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

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("breeds-canine.csv"), StandardCharsets.UTF_8)){

            String line = bufferedReader.readLine();

            while(line != null){
                breedRepository.save(new Breed(canine, line));
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("breeds-feline.csv"), StandardCharsets.UTF_8)){

            String line = bufferedReader.readLine();

            while(line != null){
                breedRepository.save(new Breed(feline, line));
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User("123", "stefan", "Ștefan Horodnic");

        userService.save(user);

        Owner owner = new Owner("1234567891234", "Stefan", "Horodnic", "Mihai romanul", "0743510638", "stefanhorodnic@yahoo.com");

        ownerRepository.save(owner);

        Animal animal = new Animal("Strumfu", LocalDate.of(2015, 8, 1), Sex.Mascul, feline,
                breedRepository.findByName("Europeană"), true, "Gri", "", "123456789123456", owner, user);

        animalRepository.save(animal);
    }
}