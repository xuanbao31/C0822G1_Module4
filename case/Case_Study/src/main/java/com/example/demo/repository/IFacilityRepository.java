package com.example.demo.repository;

import com.example.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = ft.id " +
            "where f.name like %:name% and ft.name like %:facilityType%", nativeQuery = true)
    Page<Facility> findByNameContaining(Pageable pageable, @Param("name") String name,@Param("facilityType") String facilityType);

}
