package com.selfproject.policedepartment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "policeman_about")
@Getter
@Setter
public class PolicemanAbout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String department;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;
}
