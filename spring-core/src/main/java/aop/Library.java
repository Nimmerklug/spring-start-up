package aop;

import org.springframework.stereotype.Component;

@Component("myLibraryBean")
public class Library {
    public void getBook() {
        System.out.println("Book is taken");
    }
}
