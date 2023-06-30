package com.selfproject.policedepartment.dto;

import com.selfproject.policedepartment.enumeration.VignetteTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VignetteDTO {

    private LocalDate expiryDate;
    private VignetteTypeEnum vignetteType;
    private CarDTO car;
}
