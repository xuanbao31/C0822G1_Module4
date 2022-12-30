package com.example.bai_tap.service;

import com.example.bai_tap.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(int id);

    void save(Blog blog);

    void remove(int id);
}
