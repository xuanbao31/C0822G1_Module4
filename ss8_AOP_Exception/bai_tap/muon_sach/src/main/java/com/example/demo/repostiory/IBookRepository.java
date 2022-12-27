package com.example.demo.repostiory;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
