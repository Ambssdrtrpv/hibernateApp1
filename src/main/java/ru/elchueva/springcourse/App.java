package ru.elchueva.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.elchueva.springcourse.model.Passport;
import ru.elchueva.springcourse.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test person", 50);
            Passport passport = new Passport(12345);

            person.setPassport(passport);
            session.save(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}