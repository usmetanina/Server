package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Integer>{
}
