package com.example.case_study.service;

import com.example.case_study.model.customer.CustomerType;
import com.example.case_study.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(int id) {
        return customerTypeRepository.findById(id).get();
    }

    @Override
    public void save(CustomerType customerType) {
        customerTypeRepository.save(customerType);
    }
}
