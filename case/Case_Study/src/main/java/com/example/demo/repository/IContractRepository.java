package com.example.demo.repository;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.contract.ContractDto;
import com.example.demo.model.contract.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from `contract`   ", nativeQuery = true)
    Page<Contract> findAllContract(Pageable pageable);

    @Query(value = "SELECT c.id, c.start_date as startDate,c.end_date as endDate,c.deposit as deposit,cu.name" +
            " as customerName,f.name as facilityName,(sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) " +
            "AS total" +
            " from `contract` c left join contract_detail cd on c.id = cd.contract_id " +
            "left join attach_facility af on cd.attach_facility_id = af.id " +
            "left join facility f on c.facility_id = f.id join customer cu on c.customer_id = cu.id " +
            "group by c.id" +
            " order by c.id"
            , nativeQuery = true)
    Page<IContractDto> findAllByContract(Pageable pageable);
}
