package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstactLibrary {
    @Value("ABCD")
    String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getBook() {
        System.out.println("Book is taken from School Library");
    }


    public void getBook(String name) {
        System.out.println('\'' + name + "' Book is taken from School Library");
        setName(name);
    }

    public void getBook(Book book) {
        System.out.println('"' + book.getName() + "\" Book is taken from School Library");
        setName(name);
    }

    public String returnBook() {
        System.out.println("'" + name + "' Book is returned to School Library");
        return name;
    }

    public String returnBookThrowEception() {
        System.out.println(10 / 0);
        System.out.println("'" + name + "' Book is returned to School Library");
        return name;
    }

}
