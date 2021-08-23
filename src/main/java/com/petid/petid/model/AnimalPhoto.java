package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class AnimalPhoto {
    @Id
    private int id;
    @NotNull
    private int animalId;
    @NotNull
    private String path;
}
