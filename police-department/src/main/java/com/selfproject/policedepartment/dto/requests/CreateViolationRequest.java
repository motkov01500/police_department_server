package com.selfproject.policedepartment.dto.requests;

import com.selfproject.policedepartment.enumeration.ViolationTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateViolationRequest {

    private String cause;
    private ViolationTypeEnum violationType;
    private String pin;
}
