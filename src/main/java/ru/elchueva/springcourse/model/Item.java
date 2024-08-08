package ru.elchueva.springcourse.model;


import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person owner;

    public Item(){}

    public Item(String itemName, Person owner) {
        this.itemName = itemName;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getItem_name() {
        return itemName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItem_name(String item_name) {
        this.itemName = item_name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", item_name='" + itemName + '\'' +
                '}';
    }
}
