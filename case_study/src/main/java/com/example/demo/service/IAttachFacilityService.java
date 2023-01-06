package com.example.demo.service;

import com.example.demo.model.contract.AttachFacility;
import com.example.demo.model.contract.Contract;
import com.example.demo.model.facility.Facility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

   void save(AttachFacility attachFacility);

    AttachFacility findById(int id);

    void remove(int id);
}
