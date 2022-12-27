package com.example.demo.model;

import javax.persistence.*;

@Entity
public class OrderBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int borrowCode;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public OrderBook(int borrowCode, Book book) {
    }

    public OrderBook() {
    }

    public OrderBook(int id, int borrowCode, Book book) {
        this.id = id;
        this.borrowCode = borrowCode;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
