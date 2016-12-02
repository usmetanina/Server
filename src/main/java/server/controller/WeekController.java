package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.WeekWithIdGroupDto;
import server.entity.*;
import server.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class WeekController {

    @Autowired
    WeekService weekService;

    @RequestMapping(value = "/weekEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<WeekWithIdGroupDto> getAllFacultiesWithoutCourses() {
        List<Week> list = weekService.getAll();
        List<WeekWithIdGroupDto> result = new ArrayList<>(list.size());
        list.forEach(timeOfLesson -> result.add(WeekWithIdGroupDto.fromModel(timeOfLesson)));
        return result;
    }

}
