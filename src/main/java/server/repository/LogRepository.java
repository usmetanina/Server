package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Log;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
