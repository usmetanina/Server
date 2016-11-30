package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Group;

public interface GroupRepository  extends JpaRepository<Group, Integer> {
}
