package com.example.demo.service;

import com.example.demo.model.facility.FacilityType;
import com.example.demo.model.facility.RentType;

import java.util.List;
import java.util.Optional;

public interface IRentTypeService {
    List<RentType> findAll();

    Optional<RentType> findById(Integer id);
}
