package server.service;

import server.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAll();
    Teacher getByID(int id);
    Teacher save(Teacher teacher);
    void remove(int id);
}
