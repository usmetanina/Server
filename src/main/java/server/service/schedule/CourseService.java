package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.Course;
import server.repository.schedule.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course getByID(int id) {
        return courseRepository.findOne(id);
    }

    public Course save(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    public void remove(int id) {courseRepository.delete(id);
    }
}
