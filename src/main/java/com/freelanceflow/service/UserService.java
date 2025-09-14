package com.freelanceflow.service;

import com.freelanceflow.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.freelanceflow.repository.UserLoginRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserLoginRepository userLoginRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserLoginRepository userLoginRepository, BCryptPasswordEncoder encoder) {
        this.userLoginRepository = userLoginRepository;
        this.encoder = encoder;
    }

    public UserLogin registerUser(UserLogin user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userLoginRepository.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        Optional<UserLogin> userOpt = userLoginRepository.findByEmail(email);
        return userOpt.isPresent() && encoder.matches(password, userOpt.get().getPassword());
    }
}

