package ru.elchueva.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.elchueva.springcourse.model.Item;
import ru.elchueva.springcourse.model.Person;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 2);

            Item newItem = new Item("Item from hibernate", person);
            person.getItems().add(newItem);

            session.save(newItem); // не порождает никакх sql запросов
            session.getTransaction().commit(); //делает все необходимые sql запросы
        } finally {
            sessionFactory.close();
        }
    }
}