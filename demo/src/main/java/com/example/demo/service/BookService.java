package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }
}
