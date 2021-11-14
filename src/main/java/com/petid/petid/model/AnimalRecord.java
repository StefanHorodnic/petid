package com.petid.petid.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class AnimalRecord {

    @Id
    private UUID id;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
    @NotNull
    private String text;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime createdDateTime;
    @ManyToOne
    private User createdBy;
    @ManyToOne
    private Animal animal;

    public AnimalRecord(UUID id, LocalDate date, String text, LocalDateTime createdDateTime, User createdBy, Animal animal) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.createdDateTime = createdDateTime;
        this.createdBy = createdBy;
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "AnimalRecord{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", createdBy=" + createdBy +
                ", animal=" + animal +
                '}';
    }
}
