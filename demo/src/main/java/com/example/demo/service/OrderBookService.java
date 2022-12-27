package com.example.demo.service;

import com.example.demo.model.OrderBook;
import com.example.demo.repository.IOderBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookService implements IOderBookService {
    @Autowired
    private IOderBookRepository bookRepository;

    @Override
    public void save(OrderBook orderBook) {
        bookRepository.save(orderBook);
    }
}
