package com.petid.petid.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table
@Entity
public class Sex {
    @Id
    private int id;
    @NotNull
    private String name; /* Femela Mascul*/
}
