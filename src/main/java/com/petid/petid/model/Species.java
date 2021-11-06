package com.petid.petid.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Species {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "species")
    private Set<Breed> breeds;
    @OneToMany(mappedBy = "species")
    private Set<Animal> animals;

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Set<Breed> getBreeds(){
        Set<Breed> buffer = new HashSet<>();
        buffer.addAll(breeds);
        return buffer;
    }
    public Set<Animal> getAnimals(){
        Set<Animal> buffer = new HashSet<>();
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
