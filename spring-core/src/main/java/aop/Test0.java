package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test0 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);
        UniLibrary library = context.getBean("myUniLibraryBean", UniLibrary.class);
        library.getBook();
        context.close();
    }
}
