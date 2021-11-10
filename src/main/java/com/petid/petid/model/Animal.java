package com.petid.petid.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
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
    @NotEmpty(message = "Adaugă numele animalului")
    private String name;
    @NotNull(message = "Selectează data nașterii")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    @NotNull(message = "Selectează sexul animalului")
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
    @ManyToOne
    @JoinColumn(name="SPECIES_ID", nullable=false)
    private Species species;
    @ManyToOne
    @JoinColumn(name="BREED_ID", nullable=false)
    private Breed breed;
    private boolean neutered;
    private String color;
    private String distinctiveMarks;
    @Size(min = 15, max = 15, message = "Microcipul trebuie să conțină exact 15 caractere")
    @Digits(integer = 15, fraction = 0, message = "Microcipul trebuie să conțină doar cifre")
    private String microchip;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime createdDateTime;
    @ManyToOne
    private Owner owner;
    @ManyToOne
    private User user;
    @Transient
    private Set<AnimalRecord> records;

    public String getAge() {

        System.out.println(dateOfBirth);
        System.out.println(LocalDate.now());

        Period period = Period.between(dateOfBirth, LocalDate.now());

        System.out.println(period);

        if (period.getYears()==0 && period.getMonths() < 3)
        {
            if(period.getDays() < 7){
                return period.getDays() + " zile";
            }
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
