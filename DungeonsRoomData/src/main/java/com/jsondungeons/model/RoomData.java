package com.jsondungeons.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomData extends AbstractEntity {
    @JsonProperty("item_id")
    public String itemId;
    public Doors[] doors;
    @JsonProperty("content_type")
    public String contentType;
    @JsonProperty("to_open_door")
    public String toOpenDoor;
    @JsonProperty("to_spawn_chest")
    public String toSpawnChest;
    @JsonProperty("puzzle_content")
    public PuzzleContent[] puzzleContent;
}

