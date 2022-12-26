package com.example.case_study.model;

import javax.persistence.*;

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

}
