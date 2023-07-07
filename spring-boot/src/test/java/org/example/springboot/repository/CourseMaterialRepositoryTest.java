package org.example.springboot.repository;

import org.example.springboot.entity.Course;
import org.example.springboot.entity.CourseMaterial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest // save db operations
//@DataJpaTest //not save db operations (might need mock)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //otherwise give error
@TestMethodOrder(OrderAnnotation.class)
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    @Order(1)
    public void addCourseMaterial() {
        Course course = Course.builder()
                .title("JPA")
                .credit(6)
                .build();

        CourseMaterial apprentice = CourseMaterial.builder()
                .url("www.udemy.com")
                .course(course) //for it to work properly require cascade
                .build();

        courseMaterialRepository.save(apprentice);

    }

    @Test
    public void addCourseMaterialFails() {
        Course course = Course.builder()
                .title("JPA")
                .credit(6)
                .build();

        CourseMaterial apprentice = CourseMaterial.builder()
                .url("www.udemy.com")
                //.course(course) //for it to work properly require cascade
                .build();

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> courseMaterialRepository.save(apprentice));

    }

    @Test
    @Order(2)
    public void getCourseMaterialList() {
        System.out.println(courseMaterialRepository.findAll());
    }
}