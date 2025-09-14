package com.freelanceflow.repository;

import com.freelanceflow.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    boolean existsByEmail(String email);
    Optional<UserLogin> findByEmail(String email);
    Optional<UserLogin> findByEmailIgnoreCase(String email);
}


