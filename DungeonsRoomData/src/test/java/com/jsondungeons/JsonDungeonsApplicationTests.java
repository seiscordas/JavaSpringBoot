package com.jsondungeons;

import com.jsondungeons.repository.RoomMapRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class JsonDungeonsApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @MockBean
    private RoomMapRepository roomMapRepository;
    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class Config {
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder().basicAuthentication("root", "1234");
        }
    }

    @Test
    public void saveRoomDataWhenItemIdIsNullShouldReturnStatusCode401() {
        //Object ob = new JSONParser().parse(new FileReader("JSONFile.json"));
        //ResponseEntity<RoomMap> response = restTemplate.postForEntity("/roomdatas", );
    }

}
