package server.controller.cabinet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.cabinetAndHousing.CabinetWithEmployeesDto;
import server.dto.cabinetAndHousing.CabinetWithIdHousing;
import server.dto.cabinetAndHousing.CabinetWithIdHousingDto;
import server.entity.Cabinet;
import server.entity.Housing;
import server.service.CabinetService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class CabinetController {

    @Autowired
    CabinetService cabinetService;

    @RequestMapping(value = "/cabinets" , method = RequestMethod.GET)
    @ResponseBody
    public List<CabinetWithEmployeesDto> getAllCabinets() {
        List<Cabinet> list = cabinetService.getAll();
        List<CabinetWithEmployeesDto> result = new ArrayList<>(list.size());
        list.forEach(cabinet -> result.add(CabinetWithEmployeesDto.fromModel(cabinet)));
        return result;
    }

    @RequestMapping(value = "/cabinetEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<CabinetWithIdHousingDto> getAllCabinetsWithHousing() {
        List<Cabinet> list = cabinetService.getAll();
        List<CabinetWithIdHousingDto> result = new ArrayList<>(list.size());
        list.forEach(cabinet -> result.add(CabinetWithIdHousingDto.fromModel(cabinet)));
        return result;
    }
    /*
    @RequestMapping(value = "/cabinets" , method = RequestMethod.GET)
    @ResponseBody
    public List<Cabinet> getAllCabinets() {
        return cabinetService.getAll();
    }*/

    @RequestMapping(value = "/cabinets/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public CabinetWithEmployeesDto getCabinets(@PathVariable int id)
    {
        Cabinet cabinet = cabinetService.getByID(id);
        return CabinetWithEmployeesDto.fromModel(cabinet);
    }


    @RequestMapping(value = "/cabinets", method = RequestMethod.POST)
    @ResponseBody
    public Cabinet saveCabinet(@RequestBody CabinetWithIdHousing cabinet) {
        Cabinet saveCabinet = new Cabinet();
        saveCabinet.setTitle(cabinet.getTitle());
        if (cabinet.getId()!=0)
            saveCabinet.setId(cabinet.getId());
        saveCabinet.setNumber(cabinet.getNumber());
        //saveCabinet.setFunctions(cabinet.getFunctions());
        saveCabinet.setWorkHours(cabinet.getWorkHours());
        saveCabinet.setLunchHours(cabinet.getLunchHours());
        Housing housing = new Housing();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csu", "root", "root");
            Statement st = connection.createStatement();
            int id=cabinet.getHousing();
            ResultSet rs = st.executeQuery("SELECT * FROM HOUSING WHERE ID="+id);
            while (rs.next())
            {
                String str = rs.getString("title");
                housing.setId(rs.getInt("id"));
                housing.setTitle(rs.getString("title"));
                housing.setNumber(rs.getString("number"));
                housing.setCity(rs.getString("city"));
                housing.setHouse(rs.getString("house"));
                housing.setStreet(rs.getString("street"));
                //ResultSet rss=rs;
            }
        }
        catch (SQLException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        HousingController housingController = new HousingController();
        //HousingWithCabinetDto housingWithCabinetDto = housingController.getHousingById(cabinet.getHousing());
/*
        Housing housing = new Housing();
        housing.setTitle(housingWithCabinetDto.getTitle());
        housing.setId(housingWithCabinetDto.getId());
        housing.setNumber(housingWithCabinetDto.getNumber());
        housing.setCity(housingWithCabinetDto.getCity());
        housing.setHouse(housingWithCabinetDto.getHouse());
        housing.setStreet(housingWithCabinetDto.getStreet());
*/

        //saveCabinet.setHousing(housingController.getHousingById(cabinet.getHousing()));
        saveCabinet.setHousing(housing);
        return cabinetService.save(saveCabinet);
    }

    @RequestMapping(value = "/cabinets/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        cabinetService.remove(id);
    }
}
