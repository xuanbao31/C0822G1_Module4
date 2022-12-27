package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.OrderBook;
import com.example.demo.service.IBookService;
import com.example.demo.service.IOderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOderBookService oderBookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/list";
    }

    @GetMapping("{id}/borrow")
    private String borrowedBooks(@PathVariable int id, Model model) throws Exception {
        Book book = bookService.findById(id);
        if (book.getStatus() == 0) {
            throw new Exception();
        }
        model.addAttribute("books", book);
        return "/view";
    }

    @PostMapping("/saveBorrow")
    private String saveBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        book.setStatus(book.getStatus() - 1);
        bookService.save(book);
        int borrowCode = ((int) (Math.random() * 100));
        OrderBook orderBook = new OrderBook(borrowCode, book);
        oderBookService.save(orderBook);
        redirectAttributes.addAttribute("success", orderBook.getBorrowCode());
        return "redirect:/";
    }

    @GetMapping("{id}/return")
    private String returnBook(@PathVariable int id, Model model) {
        model.addAttribute("idBook", id);
        return "/viewBack";
    }
//
//    @PostMapping("/return")
//    public String returnBook(@RequestParam Integer borrowCode,
//                             @RequestParam Integer idBook, RedirectAttributes redirectAttributes) {
//        Book book = bookService.findById(idBook);
//        Set<OrderBook> orderBooks = book.getStatus();
//        List<OrderBook> orderBookList = new ArrayList<>();
//        for (OrderBook x : orderBooks) {
//            orderBookList.add(x);
//        }
//        Integer borrowCode2 = orderBookList.get(0).getBorrowCode();
//        if (borrowCode2.equals(borrowCode)) {
//            OrderBook orderBook = orderBookList.get(0);
//            orderBook.setBorrowCode(0);
//            oderBookService.save(orderBook);
//            book.setStatus(book.getStatus()+1);
//            oderBookService.save(book);
//        }
    }

