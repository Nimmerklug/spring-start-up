package SpringAppTest.PhoneExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("SpringAppTest.PhoneExample")
public class PhoneConfig {
    @Bean
    public Samsung getPhone() {
        return new Samsung(); //Octa Core ,4 GB , 12 MP
    }

    @Bean
    public MobileProcessor getProcessor() {
        return new SnapDragon(); //Octa Core
    }
}
