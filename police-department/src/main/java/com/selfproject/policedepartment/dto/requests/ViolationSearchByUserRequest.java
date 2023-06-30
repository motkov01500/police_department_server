package com.selfproject.policedepartment.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViolationSearchByUserRequest {

    private String id;
    private String pin;
}
