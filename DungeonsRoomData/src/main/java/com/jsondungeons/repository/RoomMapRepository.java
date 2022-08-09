package com.jsondungeons.repository;

import com.jsondungeons.model.JsonEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomMapRepository extends CrudRepository<JsonEntity, String>{
}
