package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);
}
