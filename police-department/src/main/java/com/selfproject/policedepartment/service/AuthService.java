package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.Role;
import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;
    private final UserRepository userRepository;

    @Autowired
    public AuthService(BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
        this.userRepository = userRepository;
    }

    @Transactional
    public User registerUser(String username, String password, String email) {
        Role role = roleService.getRoleByName("USER");
        User user = new User();
        user.setRole(role);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(encodedPassword(password));
        userRepository.save(user);
        return user;
    }

    private String encodedPassword(String password) {
        return bCryptPasswordEncoder
                .encode(password);
    }
}
