package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("Java Masterclass")
    private String name;

    @Value("Tim Buchalka")
    private String author;

    @Value("2012")
    private int publicationYear;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
