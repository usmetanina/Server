package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import server.dto.CabinetDto;
import server.dto.CabinetWithEmployeesDto;
import server.entity.Cabinet;
import server.entity.Housing;
import server.service.CabinetService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HousingController {

    @Autowired
    CabinetService cabinetService;

    /*@RequestMapping(value = "/housings" , method = RequestMethod.GET)
    @ResponseBody
    public List<Housing> getAllHousings() {
        List<Cabinet> list = cabinetService.getAll();
        List<CabinetWithEmployeesDto> result = new ArrayList<>(list.size());
        list.forEach(cabinet -> result.add(CabinetWithEmployeesDto.fromModel(cabinet)));
        return result;
    }*/
    /*
    @RequestMapping(value = "/cabinets" , method = RequestMethod.GET)
    @ResponseBody
    public List<Cabinet> getAllCabinets() {
        return cabinetService.getAll();
    }*/
/*
    @RequestMapping(value = "/cabinets/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public CabinetWithEmployeesDto getCabinets(@PathVariable int id)
    {
        Cabinet cabinet = cabinetService.getByID(id);
        return CabinetWithEmployeesDto.fromModel(cabinet);
    }


    @RequestMapping(value = "/cabinets", method = RequestMethod.POST)
    @ResponseBody
    public Cabinet saveCabinet(@RequestBody Cabinet cabinet) {
        return cabinetService.save(cabinet);
    }

    @RequestMapping(value = "/cabinets/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        cabinetService.remove(id);
    }*/
}
