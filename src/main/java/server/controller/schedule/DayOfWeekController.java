package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.DayOfWeekWithIdWeekDto;
import server.entity.schedule.DayOfWeek;
import server.service.schedule.DayOfWeekService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DayOfWeekController {

    @Autowired
    DayOfWeekService dayOfWeekService;

    @RequestMapping(value = "/dayofweekEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<DayOfWeekWithIdWeekDto> getAllDaysWithIdWeek() {
        List<DayOfWeek> list = dayOfWeekService.getAll();
        List<DayOfWeekWithIdWeekDto> result = new ArrayList<>(list.size());
        list.forEach(day -> result.add(DayOfWeekWithIdWeekDto.fromModel(day)));
        return result;
    }
}
