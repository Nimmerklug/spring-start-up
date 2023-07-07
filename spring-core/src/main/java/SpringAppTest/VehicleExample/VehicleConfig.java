package SpringAppTest.VehicleExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("SpringAppTest.VehicleExample")
//@PropertySource("classpath:vechile.properties")
public class VehicleConfig {
    @Bean
    public Vehicle myVehicle() {
        return new Car();
    }

    @Bean
    public Vehicle myNewBike() {
        System.out.println("myNewBike Bean Creation");
        Tyre tyre = new Tyre();
        tyre.setBrand("Halfords - best bike tires");
        System.out.println(tyre);
        Bike bike = new Bike();
        bike.setTyre(tyre);
        return bike;
    }
}
