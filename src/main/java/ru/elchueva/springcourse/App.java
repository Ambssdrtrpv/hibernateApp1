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

            Person person = session.get(Person.class, 1);
            System.out.println("Получили человека");
            System.out.println(person);

            Hibernate.initialize(person.getItems()); //подгружаем связанные ленивые сущности

            session.getTransaction().commit();

            System.out.println("Вне сессии");
            System.out.println(person.getItems()); //вне сессии товары можем получать - они уже были подгружены
        } finally {
            sessionFactory.close();
        }
    }
}