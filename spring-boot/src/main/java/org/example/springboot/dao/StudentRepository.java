package org.example.springboot.dao;

import org.example.springboot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("Select s from Student s Where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    //Without @Query => Select * From Student where email = ?
}
