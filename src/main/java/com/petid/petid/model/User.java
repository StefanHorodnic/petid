package com.petid.petid.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String stampNumber;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private LocalDateTime createdDateTime;


    public User(String stampNumber, String password, String name) {
        this.stampNumber = stampNumber;
        this.password = password;
        this.name = name;
        this.createdDateTime = LocalDateTime.now();
    }
}
