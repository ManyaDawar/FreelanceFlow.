package repository;

import model.WorkerPersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerPersonalDataRepository extends JpaRepository<WorkerPersonalData, Long> {
}
