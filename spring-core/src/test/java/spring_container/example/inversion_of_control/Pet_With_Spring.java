package spring_container.example.inversion_of_control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pet_With_Spring {

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

    @ParameterizedTest(name = "{0} says {1}")
    @CsvSource({
            "myCatPet,    Meow",
            "myDogPet,    Woof",
            "myCurrentPet,    Woof",
            "myCurrentPet,    Meow",
            "annotationCatBean,    Meow",
            "annotationCatBean,    Meow",
    })
    public void pet_Says_by_XML(String pet, String expectedResult) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "app-context.xml");
        Pet myPet = applicationContext.getBean(pet, Pet.class);
        myPet.say();
        assertEquals(expectedResult, outputStreamCaptor.toString().trim(),
                () -> pet + " should say " + expectedResult);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

    @ParameterizedTest(name = "{0} says {1}")
    @CsvSource({
            "catBean,    Meow",
            "dogBean,    Woof",
            "myCurrentPetBean,    Woof",
            "myCurrentPetBean,    Meow",
            "annotationCatBean,    Meow",
            "myCatPet,    Meow",
    })
    public void pet_Says_by_Configuration(String pet, String expectedResult) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(
                PetConfig.class);
        Pet myPet = applicationContext.getBean(pet, Pet.class);
        myPet.say();
        assertEquals(expectedResult, outputStreamCaptor.toString().trim(),
                () -> pet + " should say " + expectedResult);
    }

    @ParameterizedTest(name = "{0} says {1}")
    @CsvSource({
            "dogBean,    Meow",
            "annotationCatBean,    Meow",
            "myCatPet,    Meow",
    })
    public void Cat_Says_by_Mix(String pet, String expectedResult) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "context.xml");
        Pet myPet = applicationContext.getBean(pet, Pet.class);
        myPet.say();
        assertEquals(expectedResult, outputStreamCaptor.toString().trim(),
                () -> pet + " should say " + expectedResult);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
