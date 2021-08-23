package com.petid.petid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table
@Entity
public class Person {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private int personalNumber;
    private String idCardSeries;
    private int idCardNumber;
    private int countyId;
    private int cityId;
    private int streetId;
    private String streetNumber;
    private int phoneNumber;
    private String email;
    @Column(nullable = false)
    private LocalDateTime createdDateTime;
}
