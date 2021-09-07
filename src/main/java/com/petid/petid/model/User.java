package com.petid.petid.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    @NotNull
    private String stampNumber;
    @NotNull
    private String password;
    @NotNull
    private LocalDateTime createdDateTime;

    public String getStampNumber() {
        return stampNumber;
    }

    public void setStampNumber(String stampNumber) {
        this.stampNumber = stampNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String stampNumber, String password) {
        this.stampNumber = stampNumber;
        this.password = password;
        this.createdDateTime = LocalDateTime.now();
    }
}
