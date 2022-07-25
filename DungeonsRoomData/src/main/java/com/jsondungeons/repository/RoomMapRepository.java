package com.jsondungeons.repository;

import com.jsondungeons.model.RoomData;
import com.jsondungeons.model.RoomMap;
import org.springframework.data.repository.CrudRepository;

public interface RoomMapRepository extends CrudRepository<RoomData, String>{
}
