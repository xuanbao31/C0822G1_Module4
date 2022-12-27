package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);
}
