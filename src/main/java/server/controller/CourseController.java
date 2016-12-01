package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.CourseDto;
import server.entity.Course;
import server.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/courses" , method = RequestMethod.GET)
    @ResponseBody
    public List<CourseDto> getAllCourses() {
        List<Course> list = courseService.getAll();
        List<CourseDto> result = new ArrayList<>(list.size());
        list.forEach(course -> result.add(CourseDto.fromModel(course)));
        return result;
    }

    @RequestMapping(value = "/courses/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public CourseDto getCourseById(@PathVariable int id) {
        Course course = courseService.getByID(id);
        return CourseDto.fromModel(course);
    }

}