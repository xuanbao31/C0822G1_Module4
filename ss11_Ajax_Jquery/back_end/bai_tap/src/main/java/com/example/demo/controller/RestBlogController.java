package com.example.demo.controller;

import com.example.demo.dto.BlogDto;
import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> showBlogList() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(blogList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> showDetailBlog(
            @PathVariable("id") Integer id
    ) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> seachName(@RequestParam String keyword) {
        return new ResponseEntity<>(blogService.findByName(keyword), HttpStatus.OK);
    }

    @GetMapping("/searchName")
    public ResponseEntity<List<Blog>> getBlogByAuthor(@PageableDefault(value = 2) Pageable pageable,
                                                      @RequestParam(value = "nameSearch") String authorSearch) {
        Page<Blog> blogList;
        if (authorSearch.equals("")) {
            blogList = blogService.findAll(pageable);
        } else {
            blogList = blogService.findByAuthor(authorSearch, pageable);
            if (blogList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>(blogList.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody BlogDto blogDto) {
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
