package com.example.demo.service;

import com.example.demo.model.OrderBook;
import com.example.demo.repostiory.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public void save(OrderBook order) {

    }
}
