package com.selfproject.policedepartment.dto.requests;

import com.selfproject.policedepartment.enumeration.VignetteTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateVignetteRequest {

    private String carNumber;
    private LocalDate expiryDate;
    private VignetteTypeEnum vignetteTypeEnum;
}
