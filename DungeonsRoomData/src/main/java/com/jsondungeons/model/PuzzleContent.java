package com.jsondungeons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class PuzzleContent {
    @JsonProperty("puzzle_content_type")
    public PuzzleContentType puzzleContentType;
    public String dialogue;
    public String id;
    @JsonProperty("id_item_chest")
    public String idItemChest;
    public Positions[] positions;
}