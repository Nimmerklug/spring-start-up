package org.example.springboot.repository;

import org.example.springboot.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //Repository layer
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //otherwise give error
class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Location location = Location.builder()
                .locationName("Australia")
                .locationAddress("Canberra")
                .locationCode("AUD")
                .build();
        testEntityManager.persist(location);
    }

    @Test
    @DisplayName("Get Data By Valid Location Id")
    //@Disabled
    public void getLocationById_Happy_Path() {

        // given - setup or precondition do not need to do manually thanks to TestEntityManager persist
        /*Location location = Location.builder()
                .locationName("Australia")
                .locationAddress("Canberra")
                .locationCode("AUD")
                .build();

        locationRepository.save(location);
        */

        Long locationId = 1L;

        // when - action or the testing
        Location foundLocationById = locationRepository.findById(locationId).orElse(new Location());

        // then - very output
        assertEquals("Australia", foundLocationById.getLocationName());
    }
}