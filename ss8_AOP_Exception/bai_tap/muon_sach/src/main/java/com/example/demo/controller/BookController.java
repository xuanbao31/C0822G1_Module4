package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.OrderBook;
import com.example.demo.service.IBookService;
import com.example.demo.service.IOrderService;
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
    private IOrderService orderService;

    @GetMapping("/list")
    private String showAll(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("book", bookList);
        return "/index";
    }

    @GetMapping("{id}/borrow")
    private String borrowedBooks(@PathVariable int id, Model model) throws Exception {

        Book book = bookService.findById(id);
        if (book.getCount() == 0) {
            throw new Exception();
        }
        model.addAttribute("book", book);
        return "/view";
    }

    @PostMapping("/save")
    private String saveBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        book.setCount(book.getCount() - 1);
        bookService.save(book);
        int borrowCode = ((int) (Math.random() * 1000));
        OrderBook orderBook = new OrderBook(borrowCode, book);
        orderService.save(orderBook);
        redirectAttributes.addFlashAttribute("success", orderBook.getBorrowCode());
        return "redirect:/list";
    }

    @GetMapping("{id}/return")
    private String returnBook(@PathVariable int id, Model model) {
        model.addAttribute("idBook", id);
        return "/viewBack";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer borrowCode, @RequestParam Integer idBook, RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(idBook);
        Set<OrderBook> orderBooks = book.getOrders();
        List<OrderBook> orderBookList = new ArrayList<>();
        for (OrderBook x : orderBooks) {
            orderBookList.add(x);
        }
        Integer borrowCode2 = orderBookList.get(0).getBorrowCode();
        if (borrowCode2.equals(borrowCode)) {
            OrderBook orderBook = orderBookList.get(0);
            orderBook.setBorrowCode(0);
           orderService.save(orderBook);
         book.setCount(book.getCount()+1);
         bookService.save(book);
            redirectAttributes.addFlashAttribute("mess", "Ban Da Tra Sach Thanh Cong");
            return "redirect:/list";
        }
        return "error";
    }
}
