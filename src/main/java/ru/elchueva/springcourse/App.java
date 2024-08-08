package ru.elchueva.springcourse;


import ru.elchueva.springcourse.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            session.createQuery("delete from Person where age<30").executeUpdate();//параметризуем как list person'ов однако у нас возвращается обычный list


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}