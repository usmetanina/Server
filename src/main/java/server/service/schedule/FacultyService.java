package server.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.schedule.Faculty;
import server.repository.schedule.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Faculty getByID(int id) {
        return facultyRepository.findOne(id);
    }

    public Faculty save(Faculty faculty) {
        return facultyRepository.saveAndFlush(faculty);
    }

    public void remove(int id) {facultyRepository.delete(id);
    }
}
