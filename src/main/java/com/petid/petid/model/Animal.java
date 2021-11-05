package com.petid.petid.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Entity
public class Animal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
    @ManyToOne
    private Species species;
    @ManyToOne
    private Breed breed;
    @NotNull
    private boolean neutered;
    @NotNull
    private String color;
    @NotNull
    private String distinctiveMarks;
    @NotNull
    private String microchip;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdDateTime;
    @ManyToOne
    private Owner owner;

    private int createdByMedicId;
    @Transient
    private List<AnimalRecord> records;
    @Transient
    private String age;


    //Getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public boolean isNeutered() {
        return neutered;
    }

    public void setNeutered(boolean neutered) {
        this.neutered = neutered;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAge() {

        Period period = Period.between(dateOfBirth, LocalDate.now());

        if (period.getDays() < 7)
        {
            return period.getDays() + " zile";
        }
        else if(period.getMonths() < 3){
            return period.getDays() / 7 + " săptămâni";
        }
        else if(period.getYears() < 1){
            return period.getMonths() + " luni";
        }
        else{
            return period.getYears() + " ani";
        }
    }

    //Constructors

    public Animal() {

    }

    public Animal(String name,
                  LocalDate dateOfBirth,
                  Sex sex,
                  Species species,
                  Breed breed,
                  boolean neutered,
                  String color,
                  String distinctiveMarks,
                  String microchip) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.species = species;
        this.breed = breed;
        this.neutered = neutered;
        this.color = color;
        this.distinctiveMarks = distinctiveMarks;
        this.microchip = microchip;
    }


    //Public methods

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex=" + sex +
                ", species=" + species +
                ", breed=" + breed +
                ", neutered=" + neutered +
                ", color='" + color + '\'' +
                ", distinctiveMarks='" + distinctiveMarks + '\'' +
                ", microchip='" + microchip + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", createdByMedicId=" + createdByMedicId +
                ", records=" + records +
                '}';
    }
}
