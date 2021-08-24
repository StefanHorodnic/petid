package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table
@Entity
public class Owner{
    @Id
    private int id;
    @NotNull
    private int personId;
    @NotNull
    private int userId;
    @Transient
    private List<Animal> animals;
}
