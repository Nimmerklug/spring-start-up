package hibernate.example;

import hibernate.example.entity.Department;
import net.datafaker.Faker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        /*
        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
         */

        Faker faker = new Faker();
        Department dep = new Department(faker.company().name(), null);

        // Create Session Factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        // Initialize Session Object
        try {
            Session session = sessionFactory.openSession();

            session.beginTransaction();
            // Here we have used persist
            // save() method  is deprecated, it was immediately persist the entity and returns the generated ID
            session.persist(dep);

            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            sessionFactory.close();
        }

        System.out.printf("%n%s%n%n", "*".repeat(100));

        try (Session session = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Department.class).buildSessionFactory().openSession()) {
            List<Department> departments = session.createQuery("FROM Department", Department.class).list();
            System.out.println("Department List:");
            departments.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
