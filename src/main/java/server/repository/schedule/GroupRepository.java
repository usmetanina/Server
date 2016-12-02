package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.Group;

public interface GroupRepository  extends JpaRepository<Group, Integer> {
}
