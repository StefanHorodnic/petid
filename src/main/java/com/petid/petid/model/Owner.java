package com.petid.petid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Owner{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotEmpty(message = "Adaugă prenumele")
    private String firstName;
    @NotEmpty(message = "Adaugă numele")
    private String lastName;
    @Size(min = 13, max = 13, message = "C.N.P.-ul trebuie să fie un număr de 13 cifre")
    private String socialSecurityNumber;
    @NotEmpty(message = "Adaugă adresa")
    private String address;
    @NotEmpty(message = "Adaugă numărul de telefon")
    @Pattern(regexp = "07[2-8]\\d{7}", message = "Numar de telefon invalid")
    private String phone;
    @NotEmpty(message = "Adaugă email-ul")
    @Email(message = "Trebuie să fie un mail valid")
    private String email;
    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Set<Animal> animals = new HashSet<>();

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
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
