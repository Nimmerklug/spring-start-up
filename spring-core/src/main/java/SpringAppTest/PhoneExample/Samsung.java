package SpringAppTest.PhoneExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mySamsung")
public class Samsung {
    @Autowired
    @Qualifier("mediaTek") //mediaTek,snapDragon,getProcessor or @Primary
    private MobileProcessor cpu;

    public MobileProcessor getCpu() {
        return cpu;
    }

    public void setCpu(MobileProcessor cpu) {
        this.cpu = cpu;
    }

    @Override
    public String toString() {
        cpu.description();
        return "Samsung{" +
                "cpu='" + cpu + '\'' +
                '}';
    }
}
