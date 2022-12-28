package com.example.case_study.service;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public Page<Facility> findByName(Pageable pageable, String name) {
        return facilityRepository.findByNameContaining(pageable, name);
    }
}
