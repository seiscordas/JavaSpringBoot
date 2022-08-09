package com.jsondungeons.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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