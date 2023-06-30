package com.selfproject.policedepartment.entity;

import com.selfproject.policedepartment.enumeration.ViolationTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "violation")
@Getter
@Setter
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ViolationTypeEnum violationType;

    @Column(nullable = false)
    private String cause;

    @Column(name = "is_handed_to_driver")
    private boolean isHandedToDriver;

    @ManyToOne(targetEntity = PolicemanAbout.class)
    @JoinColumn(name = "policeman_about_id")
    private PolicemanAbout policemanAbout;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;
}
