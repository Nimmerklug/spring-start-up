package org.example.springboot.services;

import org.example.springboot.entity.Location;
import org.example.springboot.exceptions.LocationNotFoundException;
import org.example.springboot.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getLocationList() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationByID(Long locationID) throws LocationNotFoundException {
        //return departmentRepository.findById(departmentID).get();
        return locationRepository.findById(locationID).orElseThrow(() -> new LocationNotFoundException(("Location Not Available")));
    }

    @Override
    public Location getLocationByName(String locationName) {
        //return locationRepository.findByLocationName(locationName); //we didn't implement this method manually
        return locationRepository.findByLocationNameIgnoreCase(locationName); //we didn't implement this method manually
    }

    @Override
    public Location deleteLocationByID(Long locationID) {
        Location deletedLocation = locationRepository.findById(locationID).orElse(null);

        locationRepository.deleteById(locationID);

        return deletedLocation;
    }

    @Override
    public Location updateLocationByID(Long locationID, Location location) throws LocationNotFoundException {
        Location updatedLocation = getLocationByID(locationID);

        if (Objects.nonNull(location.getLocationName()) &&
                !"".equals(location.getLocationName())) {
            updatedLocation.setLocationName(location.getLocationName());
        }

        if (Objects.nonNull(location.getLocationAddress()) &&
                !"".equals(location.getLocationAddress())) {
            updatedLocation.setLocationAddress(location.getLocationAddress());
        }

        if (Objects.nonNull(location.getLocationCode()) &&
                !"".equals(location.getLocationCode())) {
            updatedLocation.setLocationCode(location.getLocationCode());
        }

        return locationRepository.save(updatedLocation);
    }

}
