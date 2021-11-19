package com.petid.petid.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;
    @NotNull
    private String text;
    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;
    @ManyToOne
    @JoinColumn(name="ANIMAL_ID", nullable=false)
    private Animal animal;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime createdDateTime;

    public Record(LocalDate date, String text, User user, Animal animal) {
        this.date = date;
        this.text = text;
        this.user = user;
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
