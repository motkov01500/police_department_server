package com.selfproject.policedepartment.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateDrivingLicenseRequest {

    private int licenseNumber;
    private String address;
    private LocalDate dateOfCreation;
    private LocalDate expiryDate;
    private String pin;
}
