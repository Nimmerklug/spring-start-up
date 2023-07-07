package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {

        System.out.println("START Main");

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);
        SchoolLibrary library = context.getBean("schoolLibrary", SchoolLibrary.class);

        System.out.println("Returned Book: " + library.returnBook());

        System.out.println("Returned Book: " + library.returnBookThrowEception());

        context.close();

        System.out.println("END Main");
    }
}
