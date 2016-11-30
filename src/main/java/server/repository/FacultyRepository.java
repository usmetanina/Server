package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Faculty;

public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {
}
