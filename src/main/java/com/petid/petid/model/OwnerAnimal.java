package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class OwnerAnimal {
    @Id
    private int id;
    @NotNull
    private int ownerId;
    @NotNull
    private int animalId;
}
