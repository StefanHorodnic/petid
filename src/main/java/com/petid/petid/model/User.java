package com.petid.petid.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class User{

    @Id
    private String stampNumber;
    @NotNull
    private String password;
    @NotNull
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String stampNumber, String password, String name) {
        this.stampNumber = stampNumber;
        this.password = password;
        this.name = name;
        this.createdDateTime = LocalDateTime.now();
    }
}
