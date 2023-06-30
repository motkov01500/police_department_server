package com.selfproject.policedepartment.mapper;

import com.selfproject.policedepartment.dto.DrivingLicenseDTO;
import com.selfproject.policedepartment.entity.DrivingLicense;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DrivingLicenseMapper {

    DrivingLicenseDTO mapDrivingLicenseToDrivingLicenseDTO(DrivingLicense drivingLicense);
}
