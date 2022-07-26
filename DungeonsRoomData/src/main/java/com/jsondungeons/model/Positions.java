package com.jsondungeons.model;

import java.io.Serializable;

public class Positions implements Serializable {
    private float x;
    private float y;
    private float z;


    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
