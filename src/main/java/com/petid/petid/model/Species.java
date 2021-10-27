package com.petid.petid.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Species {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "species")
    private List<Breed> breeds;
    @OneToMany(mappedBy = "species")
    private List<Animal> animals;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Breed> getBreeds(){
        List<Breed> buffer = new ArrayList<>();
        buffer.addAll(breeds);
        return buffer;
    }
    public List<Animal> getAnimals(){
        List<Animal> buffer = new ArrayList<>();
        buffer.addAll(animals);
        return buffer;
    }

    public Species(String name) {
        this.name = name;
    }

    public Species() {

    }

    public void addBreed(Breed breed){
        this.breeds.add(breed);
    }
}
