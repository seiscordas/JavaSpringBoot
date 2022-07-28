package com.jsondungeons.model;


import lombok.Data;

import java.io.Serializable;
@Data
public class Doors  implements Serializable {
    public String direction;
    public boolean visible;
    public boolean closed;
    public boolean locked;
}
