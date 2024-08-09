package ru.elchueva.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.elchueva.springcourse.model.Item;
import ru.elchueva.springcourse.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test cascading", 30);

            person.addItem(new Item("Test cascading item1"));
            person.addItem (new Item("Test cascading item2"));
            person.addItem(new Item("Test cascading item3"));

            session.save(person);

            session.getTransaction().commit(); //делает все необходимые sql запросы
        } finally {
            sessionFactory.close();
        }
    }
}