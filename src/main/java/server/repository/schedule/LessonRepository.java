package server.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.schedule.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Integer>{
}
