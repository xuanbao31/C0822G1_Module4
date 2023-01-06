package com.example.demo.service;

import com.example.demo.model.facility.FacilityType;

import java.util.List;
import java.util.Optional;

public interface IFacilityTypeService {
    List<FacilityType> findAll();

    Optional<FacilityType> findById(Integer id);
}
