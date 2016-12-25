package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.WeekLikeInDB;
import server.entity.schedule.Week;
import server.service.schedule.WeekService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class WeekController {

    @Autowired
    WeekService weekService;

    @RequestMapping(value = "/weekEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<WeekLikeInDB> getAllFacultiesWithoutCourses() {
        List<Week> list = weekService.getAll();
        List<WeekLikeInDB> result = new ArrayList<>(list.size());
        list.forEach(timeOfLesson -> result.add(WeekLikeInDB.fromModel(timeOfLesson)));
        return result;
    }

}
