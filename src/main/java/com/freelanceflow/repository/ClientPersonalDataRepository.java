package com.freelanceflow.repository;

import com.freelanceflow.model.ClientPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientPersonalDataRepository extends JpaRepository<ClientPersonalData, Long> {
}
