package com.example.demo.service;

import com.example.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> showList(Pageable pageable);

    void save(Contract contract);

    Contract findById(int id);

    void remove(int id);

    List<Contract>listContract();
}
