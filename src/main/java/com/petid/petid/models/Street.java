package com.petid.petid.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Street {

    @Id
    private int id;
    private String name;
    private int cityId;

}
