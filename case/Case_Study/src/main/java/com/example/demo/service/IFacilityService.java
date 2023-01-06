package com.example.demo.service;

import com.example.demo.model.customer.Customer;
import com.example.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAll(Pageable pageable);

    void save(Facility facility);

    void remove(int id);

    Facility findById(int id);

    Page<Facility> findByName(Pageable pageable, String name);

    List<Facility> showList();

    List<Facility> findAll();
}
