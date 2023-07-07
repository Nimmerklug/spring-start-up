package spring_container.example.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring_container.example.inversion_of_control.Pet;

@Component("annotationPersonBean")
@Scope("prototype")
public class Person {
    @Autowired(required = false)
    @Qualifier("annotationCatBean")
    private Pet pet;
    @Value("Morlov")
    private String name;
    @Value("${person.age}")
    private int age;

    //@Autowired //automatically will try to find bean component of Pet instance - Cat or Dog
    //it expected single matching bean but on 0 or more will give exception like found 4: annotationCatBean,catBean,dogBean,myCurrentPetBean
    //@Qualifier select specified bean, it's used after Autowired to prevent exception
    public Person(Pet pet) {
        setPet(pet);
    }

    public Person() {
    }

    public void callPet() {
        System.out.println("Came here my Pet");
        getPet().say();
    }

    private Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
