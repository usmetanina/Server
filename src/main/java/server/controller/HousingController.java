package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import server.dto.CabinetDto;
import server.dto.CabinetWithEmployeesDto;
import server.dto.HousingDto;
import server.dto.HousingWithCabinetDto;
import server.entity.Cabinet;
import server.entity.Housing;
import server.service.CabinetService;
import server.service.HousingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HousingController {

    @Autowired
    HousingService housingService;

    @RequestMapping(value = "/housings" , method = RequestMethod.GET)
    @ResponseBody
    public List<HousingWithCabinetDto> getAllHousings() {
        List<Housing> list = housingService.getAll();
        List<HousingWithCabinetDto> result = new ArrayList<>(list.size());
        list.forEach(housing -> result.add(HousingWithCabinetDto.fromModel(housing)));
        return result;
    }


    @RequestMapping(value = "/housings/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public HousingWithCabinetDto getHousingWithCabinetsById(@PathVariable int id)
    {
        Housing housing = housingService.getByID(id);
        return HousingWithCabinetDto.fromModel(housing);
    }

    public Housing getHousingById(int id)
    {
        housingService = new HousingService();
        Housing housing = housingService.getByID(id);
        return housing;
    }

    @RequestMapping(value = "/housings", method = RequestMethod.POST)
    @ResponseBody
    public Housing saveHousing(@RequestBody Housing housing) {
        return housingService.save(housing);
    }

    /*
    @RequestMapping(value = "/cabinets/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        cabinetService.remove(id);
    }*/
}
