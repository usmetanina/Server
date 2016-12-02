package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.Faculty;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
}
