package com.example.case_study.service;

import com.example.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    void save(Customer customer);

    void remove(int id);

    Customer findById(int id);

    Page<Customer> findByName(Pageable pageable, String name, String email, String customerType);

}
