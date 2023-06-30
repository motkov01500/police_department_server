package com.selfproject.policedepartment.mapper;

import com.selfproject.policedepartment.dto.CarDTO;
import com.selfproject.policedepartment.dto.CarSearchByUserDTO;
import com.selfproject.policedepartment.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO mapCarToCarDTO(Car car);

    CarSearchByUserDTO mapCarToCarSearchByUserDTO(Car car);
}
