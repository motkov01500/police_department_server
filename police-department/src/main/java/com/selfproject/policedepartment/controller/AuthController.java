package com.selfproject.policedepartment.controller;

import com.selfproject.policedepartment.dto.requests.AuthRequest;
import com.selfproject.policedepartment.dto.requests.LoginRequest;
import com.selfproject.policedepartment.dto.requests.RegisterRequest;
import com.selfproject.policedepartment.entity.User;
import com.selfproject.policedepartment.security.TokenProvider;
import com.selfproject.policedepartment.service.AuthService;
import com.selfproject.policedepartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final AuthService authService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, TokenProvider tokenProvider, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthRequest> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        String token = tokenProvider.generate(authentication);
        return new ResponseEntity<>(new AuthRequest(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User user = authService.registerUser(registerRequest.getUsername(),
                registerRequest.getPassword(), registerRequest.getEmail());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
