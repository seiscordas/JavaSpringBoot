package com.jsondungeons.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
@Table(name = "roomdatas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomData extends AbstractEntity {

    @OneToMany()
    public Door[] doors;
    @JsonProperty("content_type")
    public String contentType;
    @JsonProperty("to_open_door")
    public String toOpenDoor;
    public String to_spawn_chest;
    public PuzzleContent[] puzzle_content;
}

