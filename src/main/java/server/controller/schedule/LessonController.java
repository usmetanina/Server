package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.LessonWithAllIdDto;
import server.entity.schedule.Lesson;
import server.service.schedule.LessonService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @RequestMapping(value = "/lessonEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<LessonWithAllIdDto> getAllFacultiesWithoutCourses() {
        List<Lesson> list = lessonService.getAll();
        List<LessonWithAllIdDto> result = new ArrayList<>(list.size());
        list.forEach(lesson -> result.add(LessonWithAllIdDto.fromModel(lesson)));
        return result;
    }

}
