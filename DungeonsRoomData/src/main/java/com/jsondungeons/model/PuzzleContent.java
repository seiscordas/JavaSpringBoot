package com.jsondungeons.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "puzzlecontent")
public class PuzzleContent extends AbstractEntity{
    public PuzzleContentType puzzle_content_type;
    public String dialogue;
    public String id;
    public String id_item_chest;
    public Positions[] positions;
}
enum PuzzleContentType {none, target, obstacle, show_target, chest, floor, monster, boss, portal, obj }
