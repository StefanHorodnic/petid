package com.petid.petid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class County {

    @Id
    private int id;
    private String name;

}
