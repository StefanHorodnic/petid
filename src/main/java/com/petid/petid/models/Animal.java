package com.petid.petid.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table
@Entity

public class Animal<AnimalRecord> {
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int dateOfBirth;
    @NotNull
    private String sexId;
    @NotNull
    private String speciesId;
    @NotNull
    private String breedId;
    @NotNull
    private String hormonalState;
    @NotNull
    private String color;
    @NotNull
    private String distinctiveMarks;
    @NotNull
    private String microchip;
//    @NotNull
//    private NotNull.List animalRecordListcors;
    @NotNull
    private LocalDateTime createdDateTime;
    @NotNull
    private String createdByMedicId;
}
