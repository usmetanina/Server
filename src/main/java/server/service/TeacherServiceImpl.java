package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.Teacher;
import server.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public Teacher getByID(int id) {
        return teacherRepository.findOne(id);
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    public void remove(int id) {
        teacherRepository.delete(id);
    }
}
