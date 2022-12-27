package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String actor;
    private int status;

    @OneToMany(mappedBy = "book")
    private Set<OrderBook> orderBooks;

    public Book(int id, String name, String actor, int status, Set<OrderBook> orderBooks) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.status = status;
        this.orderBooks = orderBooks;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public Set<OrderBook> getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
