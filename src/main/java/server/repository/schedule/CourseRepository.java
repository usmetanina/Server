package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.Course;

public interface CourseRepository  extends JpaRepository<Course, Integer> {
}
