package com.jsondungeons.controller;

import lombok.Data;

import java.io.Serializable;
@Data
public class Positions implements Serializable {
    private float x;
    private float y;
    private float z;
}
