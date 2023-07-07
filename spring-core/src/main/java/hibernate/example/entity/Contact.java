package hibernate.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.net.URL;

@Entity(name = "Contact")
public class Contact {

    @Id //primary key
    private Integer id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String notes;

    private URL website;

    private boolean starred;

    public Contact() {
    }

    public Contact(Integer id, String firstName, String middleName, String lastName, String notes, URL website, boolean starred) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.notes = notes;
        this.website = website;
        this.starred = starred;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL website) {
        this.website = website;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }
}


