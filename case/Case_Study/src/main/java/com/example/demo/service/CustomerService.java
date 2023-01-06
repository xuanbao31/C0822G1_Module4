package com.example.demo.service;

import com.example.demo.model.customer.Customer;
import com.example.demo.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

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

    @Override
    public List<Customer> showList() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllCustomerService(Pageable pageable) {
        return customerRepository.findAllCustomerService(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
