package server.controller.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.schedule.FacultyDto;
import server.dto.schedule.FacultyWithoutCoursesDto;
import server.entity.schedule.Faculty;
import server.service.schedule.FacultyService;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/faculties" , method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyDto> getAllFaculties() {
        List<Faculty> list = facultyService.getAll();
        List<FacultyDto> result = new ArrayList<>(list.size());
        list.forEach(faculty -> result.add(FacultyDto.fromModel(faculty)));
        return result;
    }

    @RequestMapping(value = "/facultyEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyWithoutCoursesDto> getAllFacultiesWithoutCourses() {
        List<Faculty> list = facultyService.getAll();
        List<FacultyWithoutCoursesDto> result = new ArrayList<>(list.size());
        list.forEach(faculty -> result.add(FacultyWithoutCoursesDto.fromModel(faculty)));
        return result;
    }

    @RequestMapping(value = "/faculties/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public FacultyDto getFacultyById(@PathVariable int id) {
        Faculty faculty = facultyService.getByID(id);
        return FacultyDto.fromModel(faculty);
    }

}
