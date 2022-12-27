package com.example.demo.repostiory;

import com.example.demo.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderBook,Integer> {
}
