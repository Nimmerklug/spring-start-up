package spring_container.example.dependency_injection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring_container.example.inversion_of_control.Cat;
import spring_container.example.inversion_of_control.Dog;
import spring_container.example.inversion_of_control.Pet;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_Without_Spring {

    private final String personString = "Came here my Pet\n";

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void person_Cat_Says_Meow() {
        Pet myPet = new Cat(); // new Dog() // new ... always need recompile code when we change agent
        Person myPerson = new Person(myPet);
        myPerson.callPet();
        assertEquals(personString + "Meow", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void person_Dog_Says_Meow() {
        Pet myPet = new Dog(); // new Dog() // new ... always need recompile code when we change agent
        Person myPerson = new Person(myPet);
        myPerson.callPet();
        assertEquals(personString + "Woof", outputStreamCaptor.toString()
                .trim());
    }

}
