package spring_container.example.inversion_of_control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_Without_Spring {

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
    void cat_Says_Meow() {
        Pet myPet = new Cat(); // new Dog() // new ... always need recompile code when we change agent
        myPet.say();
        assertEquals("Meow", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void dog_Says_Meow() {
        Pet myPet = new Dog();
        myPet.say();
        assertEquals("Meow", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void dog_Says_Woof() {
        Pet myPet = new Dog();
        myPet.say();
        assertEquals("Woof", outputStreamCaptor.toString()
                .trim());
    }

}
