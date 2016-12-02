package server.controller.cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.cabinetAndHousing.FunctionCabinetWithIdCabinetDto;
import server.entity.FunctionCabinet;
import server.service.FunctionCabinetService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class FunctionCabinetController {

    @Autowired
    FunctionCabinetService functionCabinetService;

    @RequestMapping(value = "/functioncabinetEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<FunctionCabinetWithIdCabinetDto> getAllFacultiesWithoutCourses() {
        List<FunctionCabinet> list = functionCabinetService.getAll();
        List<FunctionCabinetWithIdCabinetDto> result = new ArrayList<>(list.size());
        list.forEach(function -> result.add(FunctionCabinetWithIdCabinetDto.fromModel(function)));
        return result;
    }

}
