package com.example.case_study.repository;

import com.example.case_study.model.facility.Facility;
import com.example.case_study.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
