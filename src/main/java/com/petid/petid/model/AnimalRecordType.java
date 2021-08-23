package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity

public class AnimalRecordType {
    @Id
    private int id;
    @NotNull
    private String name; /*Vaccinare Deparazitare Interventie chirurgicala Comentariu*/
}
