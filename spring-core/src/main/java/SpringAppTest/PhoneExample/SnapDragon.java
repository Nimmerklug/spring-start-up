package SpringAppTest.PhoneExample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SnapDragon implements MobileProcessor {
    @Value("Octa Core")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void description() {
        System.out.println("One of the best cpu");
    }

    @Override
    public String toString() {
        return "SnapDragon{'" + name + '\'' + '}';
    }
}
