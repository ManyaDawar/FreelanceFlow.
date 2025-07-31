package service;

import model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserLoginRepository;

import java.util.Optional;

@Service
public class UserService {
    private UserLoginRepository userLoginRepository;

    @Autowired
    public void UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public UserService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public UserLogin registerUser(UserLogin user) {
        // You may want to check if user already exists before saving
        return userLoginRepository.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        Optional<UserLogin> userOpt = userLoginRepository.findByEmail(email);
        return userOpt.isPresent() && userOpt.get().getPassword().equals(password);
    }
}
