package com.selfproject.policedepartment.entity;

import com.selfproject.policedepartment.enumeration.VignetteTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vignette")
@Getter
@Setter
public class Vignette {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    private VignetteTypeEnum vignetteType;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_id")
    private Car car;
}
