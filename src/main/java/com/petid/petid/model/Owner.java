package com.petid.petid.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Owner{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String socialSecurityNumber;
    @NotNull
    private String address;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @OneToMany(mappedBy = "owner")
    private List<Animal> animals;
    @Transient
    private String fullName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Animal> getAnimals() {
        List<Animal> bufferList = new ArrayList<>();
        bufferList.addAll(animals);
        return bufferList;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public Owner() {
    }

    public Owner(String socialSecurityNumber,String firstName, String lastName, String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
