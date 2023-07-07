package aop.aspect_oriented_programing.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);

        shoppingCart.checkout();
        System.out.println("\n" + "*".repeat(50) + "\n");
        shoppingCart.checkout("CLOSED");

        System.out.println("\n" + "*".repeat(50) + "\n");
        System.out.println(shoppingCart.quantity());
    }
}
