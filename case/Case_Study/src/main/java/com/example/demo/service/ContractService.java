package com.example.demo.service;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.contract.ContractDto;
import com.example.demo.model.contract.IContractDto;
import com.example.demo.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public Page<Contract> showList(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }

    @Override
    public Page<IContractDto> showListContractDto(Pageable pageable) {
        return contractRepository.findAllByContract(pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);

    }

    @Override
    public Contract findById(int id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void remove(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> listContract() {
        return contractRepository.findAll();
    }
}
