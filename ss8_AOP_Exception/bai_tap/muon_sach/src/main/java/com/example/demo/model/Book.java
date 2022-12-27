package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private int count;
    @OneToMany(mappedBy = "book")
    Set<OrderBook> orders;

    public Book() {
    }

    public Book(int id, String name, String author, int count, Set<OrderBook> orders) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.count = count;
        this.orders = orders;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<OrderBook> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderBook> orders) {
        this.orders = orders;
    }
}
