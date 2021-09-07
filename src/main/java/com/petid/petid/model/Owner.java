package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Owner{
    @Id
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int personalNumericNumber;
    @NotNull
    private String idCardSeries;
    @NotNull
    private String idCardNumber;
    @NotNull
    private String address;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
    @Transient
    private List<Animal> animals;
}
