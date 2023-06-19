package com.selfproject.policedepartment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "driving_category")
@Getter
@Setter
public class DrivingCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;

    private String name;
}
