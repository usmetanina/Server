package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.cabinetAndHousing.FunctionCabinetWithIdCabinetDto;
import server.dto.instruction.StepInstructionWithAllIdDto;
import server.dto.schedule.FacultyDto;
import server.dto.schedule.FacultyWithoutCoursesDto;
import server.dto.schedule.LessonWithAllIdDto;
import server.entity.Faculty;
import server.entity.FunctionCabinet;
import server.entity.Lesson;
import server.entity.StepInstruction;
import server.service.FacultyService;
import server.service.FunctionCabinetService;
import server.service.LessonService;
import server.service.StepInstructionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class StepInstructionController {

    @Autowired
    StepInstructionService stepInstructionService;

    @RequestMapping(value = "/stepinstructionEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<StepInstructionWithAllIdDto> getAllFacultiesWithoutCourses() {
        List<StepInstruction> list = stepInstructionService.getAll();
        List<StepInstructionWithAllIdDto> result = new ArrayList<>(list.size());
        list.forEach(step -> result.add(StepInstructionWithAllIdDto.fromModel(step)));
        return result;
    }

}
