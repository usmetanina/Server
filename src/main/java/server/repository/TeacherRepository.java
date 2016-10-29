package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import server.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
