package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);

        SchoolLibrary sLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        sLibrary.getBook();

        UniLibrary uLibrary = context.getBean("myUniLibraryBean", UniLibrary.class);
        uLibrary.getBook();
        uLibrary.returnBook();
        uLibrary.getMagazine();

        context.close();
    }
}
