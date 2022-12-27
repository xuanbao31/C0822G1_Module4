package com.example.case_study.model.facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facilities;
}
