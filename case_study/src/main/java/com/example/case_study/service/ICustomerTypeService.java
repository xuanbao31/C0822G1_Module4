package com.example.case_study.service;

import com.example.case_study.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(int id);

    void save(CustomerType customerType);
}
