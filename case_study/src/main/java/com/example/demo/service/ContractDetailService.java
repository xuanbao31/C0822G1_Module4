package com.example.demo.service;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(int id) {
        return contractDetailRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        contractDetailRepository.deleteById(id);
    }
}
