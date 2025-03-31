package com.kdu.sms.controller;

import com.kdu.sms.entity.model.Users;
import com.kdu.sms.service.MyUserDetailsService;
import com.kdu.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        String token = userService.verify(user);

        if (token.equals("Invalid username or password") || token.equals("Authentication failed")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Collections.singletonMap("message", "Invalid credentials"));
        }

        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

    @GetMapping("/profile")
    public ResponseEntity<Users> getProfile(Authentication authentication) {
        String username = authentication.getName(); // Extract username from authentication context
        Users user = userService.getProfile(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/editProfile/{id}")
    public ResponseEntity<String> editProfile(@PathVariable int id,
                                              @RequestBody Users updatedUser,
                                              Principal principal) {
        try {
            String currentUsername = principal.getName();
            Users currentUser = userService.findByUsername(currentUsername);

            // Verify the user is editing their own profile
            if (currentUser == null || currentUser.getId() != id) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Unauthorized access");
            }

            // Update only allowed fields
            currentUser.setFirstname(updatedUser.getFirstname());
            currentUser.setLastname(updatedUser.getLastname());

            userService.save(currentUser);
            return ResponseEntity.ok("User updated successfully");
        } catch(RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }



}
