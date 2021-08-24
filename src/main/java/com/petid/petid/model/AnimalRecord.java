package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table
@Entity
public class AnimalRecord {
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int date;
    @NotNull
    private int animalRecordTypeId;
    @NotNull
    private String comment;
    @NotNull
    private LocalDateTime createdDateTime;
}
