package org.example.springboot.services;

import org.example.springboot.entity.Location;
import org.example.springboot.exceptions.LocationNotFoundException;

import java.util.List;

public interface LocationService {
    public Location addLocation(Location location);

    List<Location> getLocationList();

    Location getLocationByID(Long locationID) throws LocationNotFoundException;

    Location deleteLocationByID(Long locationID);

    Location updateLocationByID(Long locationID, Location location) throws LocationNotFoundException;

    Location getLocationByName(String locationName);
}
