package com.mvc.controllers.dao;

import com.mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonWithoutDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(PEOPLE_COUNT++, "Tom", (short) 23, "tom@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Bob", (short) 32, "bob@mail.ru"));
        people.add(new Person(PEOPLE_COUNT++, "Mike", (short) 41, "mike@outlook.com"));
        people.add(new Person(PEOPLE_COUNT++, "Max", (short) 18, "max@yahoo.com"));
        people.add(new Person(PEOPLE_COUNT++, "Kate", (short) 19, "kate@hotmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Eve", (short) 25, "eve@eve.eve"));
    }

    public List<Person> getPeople() {
        return people;
    }


    public Person getPerson(int id) {
        //return people.get(id);
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }


    public void add(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }


    public void update(int id, Person person) {
        Person thePerson = people.get(id);
        thePerson.setName(person.getName());
        thePerson.setAge(person.getAge());
        thePerson.setEmail(person.getEmail());
    }


    public void remove(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
