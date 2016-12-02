package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.TimeOfLesson;

public interface TimeOfLessonRepository extends JpaRepository<TimeOfLesson,Integer>{
}
