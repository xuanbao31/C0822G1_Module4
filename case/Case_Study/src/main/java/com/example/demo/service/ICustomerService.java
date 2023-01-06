package com.example.demo.service;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void remove(int id);

    Customer findById(int id);

    Page<Customer> findByName(Pageable pageable, String name, String email, String customerType);

    List<Customer> showList();

    Page<Customer> findAllCustomerService(Pageable pageable);
    List<Customer>findAll();
}
