package com.jsondungeons;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jsondungeons.model.JsonEntity;
import org.junit.jupiter.api.Test;

import java.io.FileReader;

public class RoomDataEndPointTest {
    @Test
    public void saveRoomWithoutRoomIdShouldReturnError() throws Exception {
        JsonEntity jsonEntity = new JsonEntity();
        JsonElement roomMap = new JsonParser().parse(new FileReader("JSONFile.json"));
    }
}
