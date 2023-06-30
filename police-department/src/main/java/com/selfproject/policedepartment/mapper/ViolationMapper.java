package com.selfproject.policedepartment.mapper;

import com.selfproject.policedepartment.dto.ViolationDTO;
import com.selfproject.policedepartment.dto.ViolationSearchByUserDTO;
import com.selfproject.policedepartment.entity.Violation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ViolationMapper {

    ViolationDTO mapViolationToViolationDTO(Violation violation);

    ViolationSearchByUserDTO mapViolationToViolationSearchByUserDTO(Violation violation);
}
