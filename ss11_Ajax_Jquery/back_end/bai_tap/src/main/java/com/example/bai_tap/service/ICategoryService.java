package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;
import com.example.bai_tap.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);
    void save(Category category);

    void remove(int id);
}
