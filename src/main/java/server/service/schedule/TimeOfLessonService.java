package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.TimeOfLesson;
import server.repository.schedule.TimeOfLessonRepository;

import java.util.List;

@Service
public class TimeOfLessonService {
    @Autowired
    private TimeOfLessonRepository timeOfLessonRepository;

    public List<TimeOfLesson> getAll() {
        return timeOfLessonRepository.findAll();
    }

    public TimeOfLesson getByID(int id) {
        return timeOfLessonRepository.findOne(id);
    }

    public TimeOfLesson save(TimeOfLesson timeOfLesson) {
        return timeOfLessonRepository.saveAndFlush(timeOfLesson);
    }

    public void remove(int id) {timeOfLessonRepository.delete(id);
    }
}
