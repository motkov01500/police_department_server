package com.selfproject.policedepartment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(name = "car_number", unique = true, nullable = false)
    private String carNumber;

    @Column(name = "insurance_end_date")
    private LocalDate insuranceEndDate;

    @Column(nullable = false)
    private String model;

    @Column(name = "year_of_manufacture", nullable = false)
    private LocalDate yearManufacture;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}
