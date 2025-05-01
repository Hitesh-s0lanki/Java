package com.hitesh.springsecurity.service;

import com.hitesh.springsecurity.model.User;
import com.hitesh.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String loginUser(User user) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        }

        return "Failed to login";
    }
}
