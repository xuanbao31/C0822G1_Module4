package com.example.case_study.service;

import com.example.case_study.model.facility.RentType;
import com.example.case_study.repository.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public void remove(int id) {
        rentTypeRepository.deleteById(id);
    }

    @Override
    public RentType findById(int id) {
        return rentTypeRepository.findById(id).get();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }
}
