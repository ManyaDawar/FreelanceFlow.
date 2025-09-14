package com.freelanceflow.repository;

import com.freelanceflow.model.UserPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonalDataRepository extends JpaRepository<UserPersonalData, Long> {
}
