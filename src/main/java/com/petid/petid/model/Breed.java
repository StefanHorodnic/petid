package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Breed {
    @Id
    private int id;
    @NotNull
    private String speciesId;
    @NotNull
    private String name;
}
