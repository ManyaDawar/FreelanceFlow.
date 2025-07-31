package repository;

import model.ClientPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientPersonalDataRepository extends JpaRepository<ClientPersonalData, Long> {
}
