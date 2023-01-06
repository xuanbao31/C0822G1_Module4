package com.example.demo.repository;

import com.example.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like %:name%", nativeQuery = true)
    Page<Facility> findByNameContaining(Pageable pageable, String name);

}
