package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.Week;

public interface WeekRepository extends JpaRepository<Week, Integer> {
}
