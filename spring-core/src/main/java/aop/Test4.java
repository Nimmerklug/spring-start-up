package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);
        SchoolLibrary library = context.getBean("schoolLibrary", SchoolLibrary.class);
        Book book = context.getBean("book", Book.class);

        library.getBook(book);
        library.getBook();
        library.getBook("Java Spring Tutorial Masterclass");

        context.close();
    }
}
