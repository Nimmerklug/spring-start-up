package spring_container.example.inversion_of_control;

import org.springframework.stereotype.Component;

@Component("annotationCatBean") // by default id will be lowercase(classname) except SQL if __ 2*upper no change
public class Cat implements Pet {
    @Override
    public void say() {
        System.out.println("Meow");
    }
}
