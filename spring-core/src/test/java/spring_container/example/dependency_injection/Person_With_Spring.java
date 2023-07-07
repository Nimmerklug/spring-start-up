package spring_container.example.dependency_injection;

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

public class Person_With_Spring {

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

    @ParameterizedTest(name = "{0} says {1}")
    @CsvSource({
            "personPetCat,    Meow",
            "personPetDog,    Woof",
            "myCurrentPerson,    Woof",
            "myCurrentPerson,    Meow",
            "annotationPersonBean,    Meow",
            "myCurrentPersonBean,    Meow",
    })
    public void person_Pet_Says_by_XML(String presonPet, String expectedResult) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "app-context.xml");
        Person myPerson = applicationContext.getBean(presonPet, Person.class);
        myPerson.callPet();
        assertEquals(personString + expectedResult, outputStreamCaptor.toString().trim(),
                () -> presonPet + " should say " + expectedResult);
    }


    @ParameterizedTest(name = "Person is a {1} years old {0}")
    @CsvSource({
            "Bob,    33",
            "Bob,    77"
    })
    public void person_Validation_by_XML(String name, int age) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app-context.xml");
        //ApplicationContext context = new FileSystemXmlApplicationContext(path);
        Person myPerson = applicationContext.getBean("myCurrentPerson", Person.class);
        myPerson.callPet();
        assertEquals(age + name, myPerson.getAge() + myPerson.getName(), "Person should be a " + age + " years " + name);
    }

    @ParameterizedTest(name = "{0} says {1}")
    @CsvSource({
            "personCatBean,    Meow",
            "personDogBean,    Woof",
            "myCurrentPersonBean,    Woof",
            "myCurrentPersonBean,    Meow",
            "annotationPersonBean,    Meow",
            "myCurrentPerson,    Meow",
    })
    public void pet_Says_by_Configuration(String presonPet, String expectedResult) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(
                PersonConfig.class);
        Person myPerson = applicationContext.getBean(presonPet, Person.class);
        myPerson.callPet();
        assertEquals(personString + expectedResult, outputStreamCaptor.toString().trim(),
                () -> presonPet + " should say " + expectedResult);
    }

    @ParameterizedTest(name = "Person is a {1} years old {0}")
    @CsvSource({
            "Steve,    33",
            "Steve,    77"
    })
    public void person_Validation_by_Configuration(String name, int age) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(
                PersonConfig.class);
        Person myPerson = applicationContext.getBean("myCurrentPersonBean", Person.class);
        myPerson.callPet();
        assertEquals(age + name, myPerson.getAge() + myPerson.getName(), "Person should be a " + age + " years " + name);
    }

    @ParameterizedTest(name = "{0} says {1}")
    @CsvSource({
            "annotationPersonBean,    Meow",
            "personCatBeanz,    Meow",
            "myCurrentPersonBean,    Meow",
            "myCurrentPerson,    Meow",
    })
    public void pet_Says_by_Mix(String presonPet, String expectedResult) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "context.xml");
        Person myPerson = applicationContext.getBean(presonPet, Person.class);
        myPerson.callPet();
        assertEquals(personString + expectedResult, outputStreamCaptor.toString().trim(),
                () -> presonPet + " should say " + expectedResult);
    }

    @ParameterizedTest(name = "{0} - Person is a {2} years old {1}")
    @CsvSource({
            "annotationPersonBean, Steve,    33",
            "annotationPersonBean, Bob,    33",
            "annotationPersonBean, Morlov,    77",
            "personCatBean, Steve,    33",
            "personDogBean, Bob,    33",
            "myCurrentPersonBean, Morlov,    77",
            "myCurrentPerson, Morlov,    77",
    })
    public void person_Validation_by_Mix(String preson, String presonName, int presonAge) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "context.xml");
        Person myPerson = applicationContext.getBean(preson, Person.class);
        myPerson.callPet();
        assertEquals(presonAge + presonName, myPerson.getAge() + myPerson.getName(), preson + " - Person should be a " + presonAge + " years " + presonName);
    }
}
