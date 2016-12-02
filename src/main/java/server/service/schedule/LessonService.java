package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.Lesson;
import server.repository.schedule.LessonRepository;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    public Lesson getByID(int id) {
        return lessonRepository.findOne(id);
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.saveAndFlush(lesson);
    }

    public void remove(int id) {lessonRepository.delete(id);
    }
}
