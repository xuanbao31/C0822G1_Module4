package com.example.case_study.model.facility;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FacilityDto implements Validator {
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
    private RentType rentType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
