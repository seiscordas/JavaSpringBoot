package com.jsondungeons.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Positions extends AbstractEntity {
    private String x;
    private String y;
    private String z;
}
