package ru.elchueva.springcourse.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "person")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Passport passport;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {return id;}

    public int getAge() {return age;}

    public String getName() {return name;}

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setAge(int age) {this.age = age;}

    public Passport getPassport() {return passport;}

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPerson(this) ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
