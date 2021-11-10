package com.petid.petid.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
    @ManyToOne
    @JoinColumn(name="SPECIES_ID", nullable=false)
    private Species species;
    @ManyToOne
    @JoinColumn(name="BREED_ID", nullable=false)
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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdDateTime;
    @ManyToOne
    private Owner owner;
    @ManyToOne
    private User user;
    @Transient
    private Set<AnimalRecord> records;

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

    public Animal(String name,
                  LocalDate dateOfBirth,
                  Sex sex,
                  Species species,
                  Breed breed,
                  boolean neutered,
                  String color,
                  String distinctiveMarks,
                  String microchip,
                  Owner owner,
                  User user) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.species = species;
        this.breed = breed;
        this.neutered = neutered;
        this.color = color;
        this.distinctiveMarks = distinctiveMarks;
        this.microchip = microchip;
        this.owner = owner;
        this.user = user;
    }

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
                ", owner=" + owner +
                ", user=" + user +
                '}';
    }
}
