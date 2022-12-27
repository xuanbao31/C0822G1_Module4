package com.example.case_study.model.facility;

import com.example.case_study.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int floor;
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "facility_type", referencedColumnName = "id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type", referencedColumnName = "id")
    private RentType rentType;

    @JsonBackReference
    @OneToMany(mappedBy = "facility")
    private Set<Contract> contracts;

}
