package com.kdu.sms.service;

import com.kdu.sms.entity.model.Users;
import com.kdu.sms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){

        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    public String verify(Users user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

            if (authentication.isAuthenticated()) {
                System.out.println("Authentication successful");
                return jwtService.generateToken(user.getUsername());
            }
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return "Authentication failed";
        }
        return "Authentication failed";
    }

    public Users getProfile(String username) {
        return userRepository.findByUsername(username); // Fetch the user from the repository
    }

//    public void editProfile(Users user) {
//        userRepository.save(user);
//    }

    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(Users user) {
        userRepository.save(user);
    }
}

