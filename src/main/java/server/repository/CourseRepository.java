package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Course;

public interface CourseRepository  extends JpaRepository<Course, Integer> {
}
