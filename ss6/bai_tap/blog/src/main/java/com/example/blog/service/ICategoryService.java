package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);

}
