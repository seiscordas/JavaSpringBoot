package com.jsondungeons.endpoint;

import com.google.gson.Gson;
import com.jsondungeons.error.CustomErrorType;
import com.jsondungeons.model.JsonEntity;
import com.jsondungeons.model.RoomData;
import com.jsondungeons.model.RoomMap;
import com.jsondungeons.repository.RoomMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        roomMap.forEach(jsonEntity -> rooms.room.add(
                new Gson().fromJson(jsonEntity.getRoom(), RoomData.class)
        ) );
        return new ResponseEntity<>(rooms.room, HttpStatus.OK);//aqui está retornando nulo
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getRoomDataById(@PathVariable("item_id") String item_id) {
        Optional<JsonEntity> roomData = roomMapDAO.findById(item_id);
        if (roomData == null)
            return new ResponseEntity<>(new CustomErrorType("Room not found"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(roomData, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody RoomMap roomMap) {
        JsonEntity jsonEntity = new JsonEntity();
        for (int i = 0; i < roomMap.room.size(); i++) {
            jsonEntity.setRoom(new Gson().toJson(roomMap.room.get(i)));
            RoomData roomData = new Gson().fromJson(jsonEntity.getRoom(), RoomData.class);
            jsonEntity.setRoomId(roomMap.room.get(i).itemId);
            roomMapDAO.save(jsonEntity);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String item_id) {
        roomMapDAO.deleteById(item_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody RoomMap roomMap) {
        //roomMapDAO.saveAll(Arrays.stream(roomMap.room).toList());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
