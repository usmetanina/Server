package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.cabinetAndHousing.FunctionCabinetWithIdCabinetDto;
import server.dto.instruction.StepInstructionWithAllIdDto;
import server.dto.schedule.FacultyDto;
import server.dto.schedule.FacultyWithoutCoursesDto;
import server.dto.schedule.LessonWithAllIdDto;
import server.dto.schedule.TimeOfLessonDto;
import server.entity.*;
import server.service.*;

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
