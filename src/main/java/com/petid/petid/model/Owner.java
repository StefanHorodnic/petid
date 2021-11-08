package com.petid.petid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
public class Owner{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @NotEmpty(message = "Adaugă prenumele")
    private String firstName;
    @NotNull
    @NotEmpty(message = "Adaugă numele")
    private String lastName;
    @NotNull
    @Size(min = 13, max = 13, message = "C.N.P.-ul trebuie să fie un număr de 13 cifre")
    private String socialSecurityNumber;
    @NotNull
    private String address;
    @NotNull
    @NotEmpty(message = "Adaugă numărul de telefon")
    private String phone;
    @NotNull
    @NotEmpty(message = "Adaugă email-ul")
    @Email(message = "Trebuie să fie un mail valid")
    private String email;
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<Animal> animals = new HashSet<>();

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

    public Set<Animal> getAnimals() {
        Set<Animal> bufferList = new HashSet<>();
        bufferList.addAll(animals);
        return bufferList;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
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

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email +
                '}';
    }
}
