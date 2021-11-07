package com.petid.petid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Breed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private Species species;
    @NotNull
    private String name;
    @OneToMany(mappedBy="breed")
    @JsonIgnore
    private Set<Animal> animals;

    public Breed(Species species, String name) {
        this.species = species;
        this.name = name;
    }
}
