package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Housing;

public interface HousingRepository extends JpaRepository<Housing, Integer> {
}
