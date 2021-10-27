package com.petid.petid.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Sex {
    //Field
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @NotNull
    private String name;

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // constructor
    public Sex() {
    }

    public Sex(String name) {
        this.name = name;
    }

}
