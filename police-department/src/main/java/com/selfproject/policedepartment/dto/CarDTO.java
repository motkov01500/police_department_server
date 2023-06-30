package com.selfproject.policedepartment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarDTO {

    private String carNumber;
    private LocalDate insuranceEndDate;
    private String model;
    private LocalDate yearManufacture;
    private UserDTO user;
}
