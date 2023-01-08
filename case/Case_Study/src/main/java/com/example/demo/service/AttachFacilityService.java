package com.example.demo.service;

import com.example.demo.model.contract.AttachFacility;
import com.example.demo.model.contract.AttachFacilityDto;
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
    public List<AttachFacilityDto> findAllAttach(int id) {
        return attachFacilityRepository.findAllAttach(id);
    }
}
