package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);
        UniLibrary library = context.getBean("myUniLibraryBean", UniLibrary.class);
        //library.getBook();
        //library.returnBook();
        library.getBook("Getting Started with Spring Framework");

        Book book = context.getBean("book", Book.class);
        library.getBook(book);

        context.close();
    }
}
