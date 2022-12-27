package com.example.case_study.service;

import com.example.case_study.model.customer.Customer;
import com.example.case_study.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name, String email, String customerType) {
        return customerRepository.findByBlogNameEmailAndCustomerTypeContaining(pageable, name, email, customerType);
    }
}
