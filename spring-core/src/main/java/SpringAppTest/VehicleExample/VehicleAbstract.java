package SpringAppTest.VehicleExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public abstract class VehicleAbstract implements Vehicle {
    @Autowired(required = false)
    @Qualifier("dTyre")
    public Tyre tyre;

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}
