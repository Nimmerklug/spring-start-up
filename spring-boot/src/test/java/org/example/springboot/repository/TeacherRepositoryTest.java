package org.example.springboot.repository;

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
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @Order(1)
    public void addTeacher() {
        /*
        Course courseUbuntu=Course.builder()
                .title("Ubuntu")
                .credit(5)
                .build();

        Course courseJava=Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Course courseDBA=Course.builder()
                .title("DBA")
                .credit(4)
                .build();
*/
        Teacher teacher = Teacher.builder()
                .firstName("Bob")
                .lastName("TheBuilder")
                //.courseList(List.of(courseDBA,courseJava,courseUbuntu))
                .build();

        teacherRepository.save(teacher);

    }

    @Test
    @Order(2)
    public void getTeacherList() {
        System.out.println(teacherRepository.findAll());
    }

}