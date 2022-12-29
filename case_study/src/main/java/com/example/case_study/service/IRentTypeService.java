package com.example.case_study.service;

import com.example.case_study.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    void remove(int id);

    RentType findById(int id);

    void save(RentType rentType);
}
