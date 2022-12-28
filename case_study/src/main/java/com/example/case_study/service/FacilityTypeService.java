package com.example.case_study.service;

import com.example.case_study.model.facility.FacilityType;
import com.example.case_study.repository.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }

    @Override
    public FacilityType findById(int id) {
        return facilityTypeRepository.findById(id).get();
    }

    @Override
    public void save(FacilityType facilityType) {
        facilityTypeRepository.save(facilityType);
    }
}
