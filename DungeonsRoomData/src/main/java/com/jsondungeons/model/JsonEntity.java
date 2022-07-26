package com.jsondungeons.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "JsonEntity")
public class JsonEntity implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "roomId",unique=true, nullable = false)
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Column(columnDefinition="TEXT", length = 1000)
    private String room;


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
