package com.example.demo.service;

import com.example.demo.model.contract.AttachFacility;
import com.example.demo.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    ContractDetail findById(int id);

    void remove(int id);
}
