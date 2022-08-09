package com.jsondungeons.controller;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class RoomMap  implements Serializable {
    public List<RoomData> room;
}
