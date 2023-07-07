package org.example.springboot.repository;

import org.example.springboot.entity.Apprentice;
import org.example.springboot.entity.Course;
import org.example.springboot.entity.Teacher;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // save db operations
//@DataJpaTest //not save db operations (might need mock)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //otherwise give error
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Order(1)
    public void addCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Eve")
                .lastName("Adam")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    @Test
    @Order(2)
    public void addCourse() {

        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        courseRepository.save(course);

    }

    @Test
    @Order(3)
    public void addCourseWithTeacherAndStudent() {

        Teacher teacher = Teacher.builder()
                .firstName("Morgan")
                .lastName("Freeman")
                .build();

        Apprentice apprentice = Apprentice.builder()
                .emailId("Abigale@gmail.com")
                .firstName("Abigale")
                .lastName("Gold")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addApprentice(apprentice);

        courseRepository.save(course);

    }

    @Test
    @Order(4)
    public void getCourseList() {
        System.out.println(courseRepository.findAll());
    }


}