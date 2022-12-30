package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(int id);

    void save(Blog blog);

    void remove(int id);


    Page<Blog> findByAuthor(String nameSearch, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByName(String name);
}
