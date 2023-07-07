package spring_container.example.dependency_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import spring_container.example.inversion_of_control.PetConfig;

// Annotation
@Configuration
//@ComponentScan("spring_container.example") //look for @Component
@PropertySource("classpath:app.properties")
public class PersonConfig {
    @Value("${person.name}")
    private String personName;

    @Bean(name = "myCurrentPersonBean")
    public Person personbBean() {

        Person person = new Person();
        person.setPet(PetConfig.petBean());
        person.setName("Bob");
        person.setAge(33);
        person.setName(personName);

        return person;
    }

    @Bean
    @Scope("prototype")
    public Person personCatBean() {
        return new Person(PetConfig.catBean());
    }

    @Bean
    @Scope("singleton")
    public Person personDogBean() {
        return new Person(PetConfig.dogBean());
    }

}
