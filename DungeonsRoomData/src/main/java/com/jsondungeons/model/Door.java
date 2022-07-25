package com.jsondungeons.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "door")
public class Door {
    @Id
    @Column(name = "id")
    private long id;
    public String direction;
    public boolean visible;
    public boolean closed;
    public boolean locked;
}
