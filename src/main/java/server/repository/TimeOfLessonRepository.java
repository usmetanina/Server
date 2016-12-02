package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.TimeOfLesson;

public interface TimeOfLessonRepository extends JpaRepository<TimeOfLesson,Integer>{
}
