package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import server.entity.Teacher;
import server.repository.TeacherRepository;
import server.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/teachers" , method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getAllTeachers() {
        return teacherService.getAll();
    }

    @RequestMapping(value = "/teachers/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public Teacher getTeacher(@PathVariable int id) {
        return teacherService.getByID(id);
    }


    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    @ResponseBody
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        teacherService.remove(id);
    }
}
