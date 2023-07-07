package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> studentsList = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Bob", 4, 7.5);
        Student st2 = new Student("Steve", 2, 8.3);
        Student st3 = new Student("Mark", 1, 9.1);

        studentsList.add(st1);
        studentsList.add(st2);
        studentsList.add(st3);
    }

    public List<Student> getStudentsList() {
        System.out.println("Information from getStudentsList():\n" + studentsList);
        return studentsList;
    }

    public List<Student> getStudentsListThrowException() {
        System.out.println("Information from getStudentsList():\n" + studentsList);
        System.out.println(studentsList.get(3));
        return studentsList;
    }
}
