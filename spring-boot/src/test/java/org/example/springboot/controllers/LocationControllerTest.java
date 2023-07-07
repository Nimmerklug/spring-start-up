package org.example.springboot.controllers;

import org.example.springboot.configs.WebSecurityConfig;
import org.example.springboot.entity.Location;
import org.example.springboot.services.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(LocationController.class) //controller layer (test endpoint)
@Import(WebSecurityConfig.class)
class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    private Location location;

    @BeforeEach
    void setUp() {
        location = Location.builder()
                .locationName("Romania")
                .locationAddress("Bucharest")
                .locationCode("RON")
                .locationID(1L)
                .build();
    }

    @Test
    void addLocation() throws Exception {
        // given - setup or precondition
        Location savedLocation = Location.builder()
                .locationName("Romania")
                .locationAddress("Bucharest")
                .locationCode("RON")
                .build();

        Mockito.when(locationService.addLocation(savedLocation)).thenReturn(location);

        // when - action or the testing
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v3/location")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"locationName\":\"Romania\",\n" +
                                "    \"locationAddress\":\"Bucharest\",\n" +
                                "    \"locationCode\":\"RON\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        // then - very output

    }

    @Test
    void getLocationByID() throws Exception {
        // given - setup or precondition
        Mockito.when(locationService.getLocationByID(1L)).thenReturn(location);

        // when - action or the testing
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v3/location/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.locationName").value(location.getLocationName()));
        // then - very output
    }
}