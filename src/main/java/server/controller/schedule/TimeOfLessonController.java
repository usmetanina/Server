package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.TimeOfLessonDto;
import server.entity.schedule.TimeOfLesson;
import server.service.schedule.TimeOfLessonService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class TimeOfLessonController {

    @Autowired
    TimeOfLessonService timeOfLessonService;

    @RequestMapping(value = "/timeoflessonEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<TimeOfLessonDto> getAllFacultiesWithoutCourses() {
        List<TimeOfLesson> list = timeOfLessonService.getAll();
        List<TimeOfLessonDto> result = new ArrayList<>(list.size());
        list.forEach(timeOfLesson -> result.add(TimeOfLessonDto.fromModel(timeOfLesson)));
        return result;
    }

}
