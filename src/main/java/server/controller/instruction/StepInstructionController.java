package server.controller.instruction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.instruction.StepInstructionWithAllIdDto;
import server.entity.StepInstruction;
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
