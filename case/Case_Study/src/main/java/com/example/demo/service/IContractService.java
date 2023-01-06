package com.example.demo.service;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.contract.ContractDto;
import com.example.demo.model.contract.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> showList(Pageable pageable);
    Page<IContractDto> showListContractDto(Pageable pageable);

    void save(Contract contract);

    Contract findById(int id);

    void remove(int id);

    List<Contract>listContract();
}
