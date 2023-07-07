package com.mvc.controllers.dao;

import com.mvc.models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAOHibernate {

    public List<Student> getStudents() {

        List<Student> studentList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            studentList = session.createQuery("from Student", Student.class).list();
            studentList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }


    public Student getStudent(int id) {

        Student student = new Student("TEST", (short) 0, "TEST@TEST");
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
            //student= (Student) session.createQuery("from Student s Where s.id = :sid", Student.class).setParameter("sid", id);
            System.out.println(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return student;
    }


    public void add(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void update(int id, Student person) {
        Student theStudent = getStudent(id);
        theStudent.setName(person.getName());
        theStudent.setAge(person.getAge());
        theStudent.setEmail(person.getEmail());

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(theStudent);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void remove(int id) {
        Student thePerson = getStudent(id);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(thePerson);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}