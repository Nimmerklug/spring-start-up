package org.example.springboot.configs;

import org.example.springboot.dao.StudentRepository;
import org.example.springboot.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student vladimir = new Student(
                    "Vladimir",
                    "vladimir@gmai.com",
                    /*31,*/
                    LocalDate.of(2010, Month.FEBRUARY, 23)
            );

            Student alex = new Student(
                    "Alex",
                    "alex@outlook.com",
                    /*32,*/
                    LocalDate.of(2010, Month.FEBRUARY, 13)
            );

            Student dima = new Student(
                    1L,
                    "Dima",
                    "dima@outlook.com",
                    /*23,*/
                    LocalDate.of(1999, Month.MARCH, 13)
            );

            studentRepository.saveAll(List.of(vladimir, alex, dima));

        };
    }
}
