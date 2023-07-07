package spring_container.example.inversion_of_control;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Annotation
@Configuration
public class PetConfig {
    // Creating Pet class Bean
    // using Bean annotation
    @Bean

    // Here the method name is the
    // bean id/bean name
    public static Pet catBean() {

        // Returns the Pet class object
        return new Cat();
    }

    @Bean
    public static Pet dogBean() {
        return new Dog();
    }

    @Bean(name = "myCurrentPetBean")
    public static Pet petBean() {
        return new Dog();
    }
}
