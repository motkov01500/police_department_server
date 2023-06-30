package com.selfproject.policedepartment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViolationDTO {

    private String violationType;
    private String cause;
    private boolean isHandedToDriver;
    private UserDTO user;
    private PolicemanAboutDTO policemanAbout;
}
