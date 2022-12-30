package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);

    void save(Category category);

    void remove(int id);
}
