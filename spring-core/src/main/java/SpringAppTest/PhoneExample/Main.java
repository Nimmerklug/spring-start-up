package SpringAppTest.PhoneExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(PhoneConfig.class);

        Samsung myphone = null;
        for (String i : Arrays.asList("mySamsung", "getPhone")) {
            System.out.println("\n" + i);
            myphone = factory.getBean(i, Samsung.class);
            System.out.println(myphone);
        }

        factory.close();
    }
}
