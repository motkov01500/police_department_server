package com.selfproject.policedepartment.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarUserGetRequest {

    private String carNumber;
    private String pin;
}
