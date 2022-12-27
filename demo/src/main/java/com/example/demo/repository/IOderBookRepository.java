package com.example.demo.repository;

import com.example.demo.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOderBookRepository extends JpaRepository<OrderBook, Integer> {

}
