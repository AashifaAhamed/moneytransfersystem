package com.fidelity.mts.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fidelity.mts.entity.User;
import com.fidelity.mts.repo.UserRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


        @GetMapping("/auth")
        public ResponseEntity<User> authenticate(Authentication authentication) {
            User user = userRepository.findByUsername(authentication.getName())
                                      .orElseThrow();
            return ResponseEntity.ok(user);
        }
  

}
