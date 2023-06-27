package com.selfproject.policedepartment.service;

import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<String> getAllUsersUsername() {
        List<User> users = userRepository.findAll();
        List<String> usernames = new ArrayList<>();
        users.forEach(user -> usernames.add(user.getUsername()));
        return usernames;
    }
}
