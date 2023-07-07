package org.example.springboot.services;

import jakarta.transaction.Transactional;
import org.example.springboot.dao.StudentRepository;
import org.example.springboot.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsTestList() {
        return List.of(new Student(
                1L,
                "Maria",
                "maria@gmai.com",
                /*21,*/
                LocalDate.of(2000, Month.JANUARY, 5)));
    }

    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        studentRepository.save(student);
        //System.out.println(student);
    }

    public void removeStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException(String.format("Student with id:|%d| doesn't exist", id));
        }
        studentRepository.deleteById(id);
    }

    @Transactional //entity foes to manage statement
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format("Student with id:|%d| doesn't exist", id)));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email is already taken");
            }

            student.setEmail(email);
        }
    }
}
