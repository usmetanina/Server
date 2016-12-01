package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Cabinet;

public interface CabinetRepository extends JpaRepository<Cabinet, Integer> {
}
