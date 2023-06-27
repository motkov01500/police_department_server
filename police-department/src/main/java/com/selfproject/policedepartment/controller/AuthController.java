package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.auth.AuthRequest;
import com.selfproject.policedepartment.dto.auth.LoginRequest;
import com.selfproject.policedepartment.security.TokenProvider;
import com.selfproject.policedepartment.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, TokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    @GetMapping("/get-user")
    public ResponseEntity<List<String>> getUsersUsernames() {
        return new ResponseEntity<>(userService.getAllUsersUsername(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthRequest> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        String token = tokenProvider.generate(authentication);
        return new ResponseEntity<>(new AuthRequest(token), HttpStatus.OK);
    }
}
