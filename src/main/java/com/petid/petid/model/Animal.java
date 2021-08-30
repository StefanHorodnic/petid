package com.petid.petid.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Animal{

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String name;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotNull
    private int sexId;
    @NotNull
    private int speciesId;
    @NotNull
    private int breedId;
    @NotNull
    private int hormonalStateId;
    @NotNull
    private String color;
    @NotNull
    private String distinctiveMarks;
    @NotNull
    private String microchip;
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDateTime;
    @NotNull
    private int createdByMedicId;
    @Transient
    private List<AnimalRecord> records;


    //Getters and setters

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public int getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(int speciesId) {
        this.speciesId = speciesId;
    }

    public int getBreedId() {
        return breedId;
    }

    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }

    public int getHormonalStateId() {
        return hormonalStateId;
    }

    public void setHormonalStateId(int hormonalStateId) {
        this.hormonalStateId = hormonalStateId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDistinctiveMarks() {
        return distinctiveMarks;
    }

    public void setDistinctiveMarks(String distinctiveMarks) {
        this.distinctiveMarks = distinctiveMarks;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public int getCreatedByMedicId() {
        return createdByMedicId;
    }

    public void setCreatedByMedicId(int createdByMedicId) {
        this.createdByMedicId = createdByMedicId;
    }

    //Constructors

    public Animal() {

    }

    public Animal(int id, String name, LocalDate dateOfBirth, int sexId, int speciesId, int breedId, int hormonalState, String color, String distinctiveMarks, String microchip, LocalDateTime createdDateTime, int createdByMedicId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sexId = sexId;
        this.speciesId = speciesId;
        this.breedId = breedId;
        this.hormonalStateId = hormonalState;
        this.color = color;
        this.distinctiveMarks = distinctiveMarks;
        this.microchip = microchip;
        this.createdDateTime = createdDateTime;
        this.createdByMedicId = createdByMedicId;
    }


    //Public methods

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sexId=" + sexId +
                ", speciesId=" + speciesId +
                ", breedId=" + breedId +
                ", hormonalState='" + hormonalStateId + '\'' +
                ", color='" + color + '\'' +
                ", distinctiveMarks='" + distinctiveMarks + '\'' +
                ", microchip='" + microchip + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", createdByMedicId=" + createdByMedicId +
                '}';
    }
}
