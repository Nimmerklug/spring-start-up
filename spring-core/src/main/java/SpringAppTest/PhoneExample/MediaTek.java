package SpringAppTest.PhoneExample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MediaTek implements MobileProcessor {
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
        System.out.println("Not one of the best cpu");
    }

    @Override
    public String toString() {
        return "MediaTek{'" + name + '\'' + '}';
    }
}
