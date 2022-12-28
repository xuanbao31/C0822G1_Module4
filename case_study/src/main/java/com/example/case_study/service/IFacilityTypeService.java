package com.example.case_study.service;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();

    FacilityType findById(int id);

    void save(FacilityType facilityType);
}
