package com.selfproject.policedepartment.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "driving_license")
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;

    @Column(name = "license_number", nullable = false, unique = true)
    private int licenseNumber;

    @Column(nullable = false)
    private int points;

    private String address;

    @Column(name = "date_of_creation")
    private LocalDateTime dateOfCreation;

    @Column(name = "expiry_date")
    private LocalDateTime expiryDate;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(nullable = false, unique = true)
    private String pin;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToMany
    @JoinTable(name = "category_license",
            joinColumns = {@JoinColumn(name = "driving_license_id")},
            inverseJoinColumns = {@JoinColumn(name = "driving_category_id")})
    private Set<DrivingCategory> categories;
}
