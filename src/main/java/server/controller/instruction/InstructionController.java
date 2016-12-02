package server.controller.instruction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.instruction.InstructionDto;
import server.dto.instruction.InstructionWithStepsDto;
import server.entity.Instruction;
import server.service.InstructionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class InstructionController {

    @Autowired
    InstructionService instructionService;

    @RequestMapping(value = "/instructions" , method = RequestMethod.GET)
    @ResponseBody
    public List<InstructionWithStepsDto> getAllInstructionsWithSteps() {
        List<Instruction> instructions= instructionService.getAll();
        List<InstructionWithStepsDto> result = new ArrayList<>(instructions.size());
        instructions.forEach(instruction -> result.add(InstructionWithStepsDto.fromModel(instruction)));
        return result;
    }

    @RequestMapping(value = "/instructionEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<InstructionDto> getAllInstructions() {
        List<Instruction> instructions= instructionService.getAll();
        List<InstructionDto> result = new ArrayList<>(instructions.size());
        instructions.forEach(instruction -> result.add(InstructionDto.fromModel(instruction)));
        return result;
    }

    @RequestMapping(value = "/instructions/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public InstructionWithStepsDto getInstruction(@PathVariable int id)
    {
        Instruction instruction = instructionService.getByID(id);
        return InstructionWithStepsDto.fromModel(instruction);
        //return instructionService.getByID(id);
    }

/*
    @RequestMapping(value = "/cabinets", method = RequestMethod.POST)
    @ResponseBody
    public Cabinet saveCabinet(@RequestBody CabinetWithIdHousing cabinet) {
        Cabinet saveCabinet = new Cabinet();
        saveCabinet.setTitle(cabinet.getTitle());
        if (cabinet.getId()!=0)
            saveCabinet.setId(cabinet.getId());
        saveCabinet.setNumber(cabinet.getNumber());
        saveCabinet.setFunctions(cabinet.getFunctions());
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

        Housing housing = new Housing();
        housing.setTitle(housingWithCabinetDto.getTitle());
        housing.setId(housingWithCabinetDto.getId());
        housing.setNumber(housingWithCabinetDto.getNumber());
        housing.setCity(housingWithCabinetDto.getCity());
        housing.setHouse(housingWithCabinetDto.getHouse());
        housing.setStreet(housingWithCabinetDto.getStreet());


        //saveCabinet.setHousing(housingController.getHousingById(cabinet.getHousing()));
        saveCabinet.setHousing(housing);
        return cabinetService.save(saveCabinet);
    }

    @RequestMapping(value = "/cabinets/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        cabinetService.remove(id);
    }
    */
}


