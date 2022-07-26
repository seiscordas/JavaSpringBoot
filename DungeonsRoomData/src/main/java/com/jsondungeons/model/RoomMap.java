package com.jsondungeons.model;

import java.io.Serializable;
import java.util.List;

public class RoomMap  implements Serializable {
    public List<RoomData> room;

    public void add(RoomData fromJson) {
        room.add(fromJson);
    }
}
