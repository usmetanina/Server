package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.cabinetAndHousing.FunctionCabinetWithIdCabinetDto;
import server.dto.schedule.FacultyDto;
import server.dto.schedule.FacultyWithoutCoursesDto;
import server.dto.schedule.LessonWithAllIdDto;
import server.entity.Faculty;
import server.entity.FunctionCabinet;
import server.entity.Lesson;
import server.service.FacultyService;
import server.service.FunctionCabinetService;
import server.service.LessonService;

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
