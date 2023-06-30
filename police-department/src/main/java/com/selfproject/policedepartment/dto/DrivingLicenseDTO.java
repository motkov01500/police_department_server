package com.selfproject.policedepartment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrivingLicenseDTO {

    private int id;
    private int licenseNumber;
    private int points;
    private String pin;
}
