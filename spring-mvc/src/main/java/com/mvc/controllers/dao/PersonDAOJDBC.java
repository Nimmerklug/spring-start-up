package com.mvc.controllers.dao;

import com.mvc.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAOJDBC {


    private static final String URL = "jdbc:postgresql://my-postgres-db-service:5432/dockerdb";
    private static final String USERNAME = "dockeruser";
    private static final String PASSWORD = "dockerpassword";
    public static Connection connection;

    static {
        //load jdbc driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAOJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getPeople() {
        //return jdbcTemplate.query("Select * From Person",new BeanPropertyRowMapper<>(Person.class));
        //return jdbcTemplate.query("Select * From Person",new PersonMapper());

        List<Person> peopleList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * From Person");

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setAge(resultSet.getShort("age"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));

                peopleList.add(person);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return peopleList;
    }

    public Person getPerson(int id) {

        //return jdbcTemplate.query("select * from person where id = ?",new Object[]{id},new PersonMapper()).stream().findAny().orElse(null);

        Person person = null;

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from person where id = ?");

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setAge(resultSet.getShort("age"));
            person.setName(resultSet.getString("name"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public void add(Person person) {

        //jdbcTemplate.update("insert into person (name,age,email) values (?,?,?)",new Object[]{person.getName(),person.getAge(),person.getEmail()},new PersonMapper());

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into person (name,age,email) values (?,?,?)");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setShort(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(int id, Person person) {

        //jdbcTemplate.update("update person set name=?, age=?, email=? where id=?",new Object[]{person.getName(),person.getAge(),person.getEmail(),id},new PersonMapper());


        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update person set name=?, age=?, email=? where id=?");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setShort(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int id) {

        //jdbcTemplate.update("delete from person where id=?",new Object[]{id},new PersonMapper());

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from person where id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

