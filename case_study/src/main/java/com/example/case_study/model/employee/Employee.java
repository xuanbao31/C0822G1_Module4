package com.example.case_study.model.employee;

import com.example.case_study.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "position", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division", referencedColumnName = "id")
    private Division division;

    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

}
