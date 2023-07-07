package org.example.springboot.repository;

import org.example.springboot.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    // create our own query statement with implementation findBY<filenames in camel style> -> findByLocationName
    //the list of keywords can be find docs
    public Location findByLocationName(String name);

    // the same deal but with IgnoreCase sensitive
    public Location findByLocationNameIgnoreCase(String name);

}
