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

        userService.save(new User("123", "stefan", "Ștefan Horodnic"));
        userService.save(new User("456","andrei", "Andrei Porgras"));
    }
}