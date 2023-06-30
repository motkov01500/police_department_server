package com.selfproject.policedepartment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarSearchByUserDTO {

    private String carNumber;
    private LocalDateTime insuranceEndDate;
    private String model;
    private LocalDate yearManufacture;
}
