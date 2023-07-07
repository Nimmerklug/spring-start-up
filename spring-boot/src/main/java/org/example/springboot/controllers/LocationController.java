package org.example.springboot.controllers;

import jakarta.validation.Valid;
import org.example.springboot.entity.Location;
import org.example.springboot.exceptions.LocationNotFoundException;
import org.example.springboot.services.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3/location")
public class LocationController {
    private final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);
    @Autowired
    private LocationService locationService;

    @PostMapping
    public Location addLocation(@Valid @RequestBody /*json to obj*/ Location location) {
        LOGGER.info("Started Adding new Location by addLocation(" + location + ") method");
        return locationService.addLocation(location);
    }

    @GetMapping
    public List<Location> getLocationList() {
        LOGGER.info("Started Getting all Locations by getLocationList() method ");
        return locationService.getLocationList();
    }

    @GetMapping("{id}")
    public Location getLocationByID(@PathVariable("id") Long locationID) throws LocationNotFoundException {
        return locationService.getLocationByID(locationID);
    }

    @GetMapping("name/{name}")
    public Location getLocationByName(@PathVariable("name") String locationName) {
        return locationService.getLocationByName(locationName);
    }

    @DeleteMapping("{id}")
    public Location deleteLocationByID(@PathVariable("id") Long locationID) {
        return locationService.deleteLocationByID(locationID);
    }

    @PutMapping("{id}")
    public Location updateLocationByID(@PathVariable("id") Long locationID, @RequestBody Location location) throws LocationNotFoundException {
        return locationService.updateLocationByID(locationID, location);
    }
}
