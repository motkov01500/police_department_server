package com.selfproject.policedepartment.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateCarRequest {

    private String carNumber;
    private String model;
    private LocalDate insuranceEndDate;
    private LocalDate yearManufacture;
}
