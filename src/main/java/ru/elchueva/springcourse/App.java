package ru.elchueva.springcourse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.elchueva.springcourse.model.Actor;
import ru.elchueva.springcourse.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try(sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Actor actor = session.get(Actor.class, 2);

            Movie movieToRemove = actor.getMovies().get(0);

            actor.getMovies().remove(0);

            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();
        }
    }
}