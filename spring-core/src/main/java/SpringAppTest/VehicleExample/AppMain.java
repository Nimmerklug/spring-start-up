package SpringAppTest.VehicleExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfig.class);

        Vehicle obj = null;
        for (String i : Arrays.asList("myVehicle", "bike", "myCar", "myNewBike")) {
            System.out.println("\n" + i);
            obj = context.getBean(i, Vehicle.class);
            obj.drive();
        }
        ((AnnotationConfigApplicationContext) context).close();

        /*
        System.out.println("\nmyVehicle");
        Vehicle obj = (Vehicle) context.getBean("myVehicle");
        obj.drive();
        System.out.println("\nbike");
        obj = context.getBean("bike",Vehicle.class);
        obj.drive();
        System.out.println("\nmyCar");
        obj = context.getBean("myCar",Vehicle.class);
        obj.drive();
        System.out.println("\nmyNewBike");
        obj = context.getBean("myNewBike",Vehicle.class);
        obj.drive();
         */
        context = new ClassPathXmlApplicationContext(
                "vehicle-context.xml");

        for (String i : Arrays.asList("myOldBike", "myCar")) {
            System.out.println("\n" + i);
            obj = context.getBean(i, Vehicle.class);
            obj.drive();
        }


        ((ClassPathXmlApplicationContext) context).close();

    }
}
