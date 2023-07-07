package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(
                MyConfig.class);
        University university = context.getBean("university", University.class);

        university.addStudents();
        List<Student> studentsList = university.getStudentsList();
        System.out.println(studentsList);

        try {
            studentsList = university.getStudentsListThrowException();
            System.out.println(studentsList);
        } catch (Exception e) {
            System.err.println("Exception was caugh:  " + e);
        }

        context.close();
    }
}
