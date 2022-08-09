package com.jsondungeons.endpoint;

import com.google.gson.Gson;
import com.jsondungeons.error.ResourceNotFoundException;
import com.jsondungeons.model.JsonEntity;
import com.jsondungeons.controller.RoomData;
import com.jsondungeons.controller.RoomMap;
import com.jsondungeons.repository.RoomMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
@RestController
@RequestMapping("roomdatas")
public class RoomEndpoint {
    private final RoomMapRepository roomMapDAO;
    @Autowired
    public RoomEndpoint(RoomMapRepository roomMapDAO) {
        this.roomMapDAO = roomMapDAO;
    }
    @GetMapping
    public ResponseEntity<?> listAll() {
        Iterable<JsonEntity> roomMap = roomMapDAO.findAll();
        RoomMap rooms = new RoomMap();
        rooms.room = new ArrayList<>();
        roomMap.forEach(jsonEntity -> rooms.room.add(
                new Gson().fromJson(jsonEntity.getRoom(), RoomData.class)
        ) );
        return new ResponseEntity<>(rooms.room, HttpStatus.OK);
    }
    @GetMapping(path = "/{roomId}")
    public ResponseEntity<?> getRoomDataById(@PathVariable String roomId) {
        verityIfRoomExists(roomId);
        RoomData rooms = new Gson().fromJson(roomMapDAO.findById(roomId).orElseThrow().getRoom(), RoomData.class);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody RoomMap roomMap) {
        JsonEntity jsonEntity = new JsonEntity();
        for (int i = 0; i < roomMap.room.size(); i++) {
            jsonEntity.setRoom(new Gson().toJson(roomMap.room.get(i)));
            RoomData roomData = new Gson().fromJson(jsonEntity.getRoom(), RoomData.class);
            jsonEntity.setRoomId(roomMap.room.get(i).itemId);
            roomMapDAO.save(jsonEntity);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{roomId}")
    public ResponseEntity<?> delete(@PathVariable String roomId) {
        verityIfRoomExists(roomId);
        roomMapDAO.deleteById(roomId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RoomData roomData) {
        verityIfRoomExists(roomData.getItemId());
        JsonEntity jsonEntity = new JsonEntity();
        jsonEntity.setRoom(new Gson().toJson(roomData));
        jsonEntity.setRoomId(roomData.itemId);
        roomMapDAO.save(jsonEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private void verityIfRoomExists(String roomId){
        if (roomMapDAO.findById(roomId).isEmpty())
            throw new ResourceNotFoundException("Room not found for ID: " + roomId);
    }
}
