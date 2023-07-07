package org.example.springboot.services;

import org.example.springboot.entity.Location;
import org.example.springboot.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //Service Layer
class LocationServiceTest {

    @Autowired
    private LocationService locationService;

    @MockBean
    private LocationRepository locationRepository;

    @BeforeEach
    void setUp() {
        //Location location = new Location();

        //with @Builder pattern we can do following
        Location location = Location.builder()
                .locationName("Bulgaria")
                .locationAddress("Lovech")
                .locationCode("BGN")
                .locationID(1L)
                .build();
        Mockito.when(locationRepository.findByLocationNameIgnoreCase("Bulgaria"))
                .thenReturn(location);
    }

    @Test
    @DisplayName("Get Data By Valid Location Name")
    //@Disabled
    public void getLocationByName_Happy_Path() {
        //Location getLocationByName(String locationName);
        String locationName = "Bulgaria";
        Location foundLocationByName = locationService.getLocationByName(locationName);
        assertEquals(locationName, foundLocationByName.getLocationName());
    }

}