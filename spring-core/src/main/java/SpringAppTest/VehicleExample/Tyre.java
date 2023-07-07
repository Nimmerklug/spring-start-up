package SpringAppTest.VehicleExample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dTyre")
public class Tyre {
    @Value("myTiresBrand")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
