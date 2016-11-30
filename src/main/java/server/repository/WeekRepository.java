package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Week;

public interface WeekRepository extends JpaRepository<Week, Integer> {
}
