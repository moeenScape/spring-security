package com.moeen.springsecurity.service;

import com.moeen.springsecurity.entity.AuthenticationResponse;
import com.moeen.springsecurity.entity.model.AuthenticationRequest;
import com.moeen.springsecurity.entity.model.RegisterRequest;
import com.moeen.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        return null;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return null;
    }
}
