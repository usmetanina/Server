package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.DayOfWeek;

public interface DayOfWeekRepository  extends JpaRepository<DayOfWeek, Integer> {
}
