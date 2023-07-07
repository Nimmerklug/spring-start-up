package SpringAppTest.VehicleExample;

import org.springframework.stereotype.Component;

@Component("myCar")
public class Car extends VehicleAbstract {
    @Override
    public void drive() {
        System.out.println("Car is moving...\n" + getTyre());
    }
}
