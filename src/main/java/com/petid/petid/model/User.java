package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;

@Table
@Entity
public class User {
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private HashSet Hash;
    @NotNull
    private LocalDateTime createdDateTime;
}
