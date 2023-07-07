package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);
        UniLibrary library = context.getBean("myUniLibraryBean", UniLibrary.class);
        library.getBook(); // GET LOG + GET || Return
        library.returnMagazine(); // RETURN LOG + GET || Return
        library.addBook(); // NO LOG

        context.close();
    }
}
