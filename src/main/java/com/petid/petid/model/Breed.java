package com.petid.petid.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private Species species;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "breed")
    private List<Animal> animals;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        List<Animal> buffer = new ArrayList<>();
        buffer.addAll(animals);
        return buffer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed(Species species, String name) {
        this.species = species;
        this.name = name;
    }

    public Breed() {
    }
}
