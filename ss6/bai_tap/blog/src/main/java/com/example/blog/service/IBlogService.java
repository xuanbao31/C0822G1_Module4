package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog>findAll(Pageable pageable,String nameBook);
}
