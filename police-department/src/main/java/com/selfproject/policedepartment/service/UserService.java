package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User is not found"));
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String getCurrentLoggedUserUserName() {
        Authentication userDetails = SecurityContextHolder.getContext().getAuthentication();
        return userDetails.getName();
    }

    public User currentLoggedUser() {
        return  getUserByUsername(getCurrentLoggedUserUserName());
    }

    public User getUserByPIN(String pin) {
        return userRepository
                .findByPIN(pin)
                .orElseThrow();
    }
}
