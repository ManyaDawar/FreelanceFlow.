package com.freelanceflow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_login")
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Getters and setters
    @Setter
    @Getter
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Getter
    @Setter
    @Column(nullable = false, length = 64)
    private String password;
    @Setter
    @Getter
    @Column(nullable = false, length = 20)
    private String role;

    public UserLogin() {}

    public UserLogin(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
