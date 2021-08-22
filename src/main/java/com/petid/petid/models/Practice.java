package com.petid.petid.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Practice {
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int countyId;
    @NotNull
    private int cityId;
    @NotNull
    private int streetId;
    @NotNull
    private String streetNumber;
    @NotNull
    private int registrationNumber;
}
