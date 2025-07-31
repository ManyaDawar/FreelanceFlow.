package controller;

import model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    public void UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserLogin user) {
        userService.registerUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserLogin user) {
        boolean authenticated = userService.authenticateUser(user.getEmail(), user.getPassword());
        return authenticated ? "Login successful" : "Invalid credentials";
    }
}
