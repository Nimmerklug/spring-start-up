package hibernate.example;


import hibernate.example.entity.Contact;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Test2 {
    public static void main(String[] args) throws MalformedURLException {

        Contact contact = new Contact(111, "Bob", "-", "Smith", "", new URL("https://www.db4free.net/"), false);

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the objects
            session.persist(contact);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Contact> contacts = session.createQuery("from Contact", Contact.class).list();
            contacts.forEach(c -> System.out.println("Print contact name : " +
                    c.getFirstName() + ' ' +
                    c.getMiddleName() + ' ' +
                    c.getLastName()));
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
