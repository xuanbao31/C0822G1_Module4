package com.example.demo.service;

import com.example.demo.model.contract.AttachFacility;
import com.example.demo.model.facility.Facility;
import com.example.demo.repository.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public void save(AttachFacility attachFacility) {
        attachFacilityRepository.save(attachFacility);
    }

    @Override
    public AttachFacility findById(int id) {
        return attachFacilityRepository.findById(id).get();
    }


    @Override
    public void remove(int id) {
        attachFacilityRepository.deleteById(id);
    }
}
