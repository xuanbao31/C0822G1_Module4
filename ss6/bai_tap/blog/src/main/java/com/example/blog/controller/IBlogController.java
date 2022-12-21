package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class IBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public String showAndSearch(@PageableDefault(value = 2) Pageable pageable,
                                @RequestParam(defaultValue = "") String nameBook,
                                Model model) {
        model.addAttribute("bookName", nameBook);
        model.addAttribute("blogs", blogService.findAll(pageable, nameBook));
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", categoryService.findAll());
        return "/create";
    }

    @PostMapping("/create")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addAttribute("message", "Thêm Mới Thành Công");
        return "redirect:blog/list";
    }

    @GetMapping("{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        return "/delete";
    }

    @PostMapping("/deleteBlog")
    public String delete(@ModelAttribute Blog blog) {
        blog.setStatus(1);
        blogService.save(blog);
        return "redirect:/blog/list";
    }
}
