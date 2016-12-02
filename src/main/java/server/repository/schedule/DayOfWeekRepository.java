package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.DayOfWeek;

public interface DayOfWeekRepository  extends JpaRepository<DayOfWeek, Integer> {
}
