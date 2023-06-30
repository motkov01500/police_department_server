package com.selfproject.policedepartment.mapper;

import com.selfproject.policedepartment.dto.VignetteDTO;
import com.selfproject.policedepartment.entity.Vignette;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VignetteMapper {

    VignetteDTO mapVignetteToVignetteDTO(Vignette vignette);
}
