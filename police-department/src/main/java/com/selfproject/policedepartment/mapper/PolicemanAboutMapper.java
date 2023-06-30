package com.selfproject.policedepartment.mapper;

import com.selfproject.policedepartment.dto.PolicemanAboutDTO;
import com.selfproject.policedepartment.entity.PolicemanAbout;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PolicemanAboutMapper {

    PolicemanAboutDTO mapPolicemanAboutToPolicemanAboutDTO(PolicemanAbout policemanAbout);
}
