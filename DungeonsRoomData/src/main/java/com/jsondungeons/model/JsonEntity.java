package com.jsondungeons.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "JsonEntity")
@Data
public class JsonEntity implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "roomId",unique=true, nullable = false)
    private String roomId;
    @Column(columnDefinition="TEXT", length = 1000)
    private String room;
}
