package SpringAppTest.VehicleExample;

import org.springframework.stereotype.Component;

@Component
public class Bike extends VehicleAbstract {
    @Override
    public void drive() {
        System.out.println("Bike is moving...\n" + getTyre());
    }
}
