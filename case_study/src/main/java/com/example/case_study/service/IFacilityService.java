package com.example.case_study.service;

import com.example.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    void save(Facility facility);

    void remove(int id);

    Facility findById(int id);

    Page<Facility> findByName(Pageable pageable, String name);
}
