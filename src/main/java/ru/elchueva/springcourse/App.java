package ru.elchueva.springcourse;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.elchueva.springcourse.model.Item;
import ru.elchueva.springcourse.model.Person;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Item item = session.get(Item.class, 1);
            System.out.println("Получили товар");

            System.out.println(item.getOwner());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}