package aop;

import org.springframework.stereotype.Component;

@Component("myUniLibraryBean")
public class UniLibrary extends AbstactLibrary {
    @Override
    public void getBook() {
        System.out.println("Book is taken from University Library");
    }

    public void getBook(String name) {
        System.out.println('\'' + name + "' Book is taken from University Library");
    }

    public void getBook(Book book) {
        System.out.println('"' + book.getName() + "\" Book is taken from University Library");
    }

    public void getMagazine() {
        System.out.println("Magazine is taken from University Library");
    }

    public void returnBook() {
        System.out.println("Book is returned to University Library");
    }

    public void returnMagazine() {
        System.out.println("Magazine is returned to University Library");
    }

    public void addBook() {
        System.out.println("Book is added to University Library");
    }

    public void addMagazine() {
        System.out.println("Magazine is added to University Library");
    }
}
