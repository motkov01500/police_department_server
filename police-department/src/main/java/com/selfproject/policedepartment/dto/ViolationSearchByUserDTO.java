package com.selfproject.policedepartment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViolationSearchByUserDTO {

    private String id;
    private String cause;
    private String violationType;
    private UserDTO user;
}
