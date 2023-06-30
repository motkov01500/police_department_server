package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.UserDTO;
import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.mapper.UserMapper;
import com.selfproject.policedepartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("get-all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUser();
        List<UserDTO> mappedUsers = users.stream()
                .map(userMapper::mapUserToUserDTO)
                .toList();

        return new ResponseEntity<>(mappedUsers, HttpStatus.OK);
    }
}