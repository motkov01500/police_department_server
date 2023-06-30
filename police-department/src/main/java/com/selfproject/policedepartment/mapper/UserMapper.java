package com.selfproject.policedepartment.mapper;

import com.selfproject.policedepartment.dto.RegisteredUserDTO;
import com.selfproject.policedepartment.dto.UserDTO;
import com.selfproject.policedepartment.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO mapUserToUserDTO(User user);
}
