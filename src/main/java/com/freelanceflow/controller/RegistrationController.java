package com.freelanceflow.controller;

import com.freelanceflow.model.UserLogin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.freelanceflow.repository.UserLoginRepository;

@Controller
@RequestMapping("/api/auth")
public class RegistrationController {

    private final UserLoginRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserLoginRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserLogin user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return "redirect:/register?error=email";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login?registered";
    }
}




