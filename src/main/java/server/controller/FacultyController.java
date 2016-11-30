package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.entity.Faculty;
import server.service.FacultyService;
import java.util.List;

@RestController
@RequestMapping("/")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @RequestMapping(value = "/faculties" , method = RequestMethod.GET)
    @ResponseBody
    public List<Faculty> getAllGroups() {
        /*List<Employee> list = employeeService.getAll();
        List<EmployeeWithCabinetDto> result = new ArrayList<>(list.size());
        list.forEach(employee -> result.add(EmployeeWithCabinetDto.fromModel(employee)));*/
        return facultyService.getAll();
    }

    @RequestMapping(value = "/faculties/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public Faculty getGroup(@PathVariable int id) {
        /*Employee employee = employeeService.getByID(id);
        return EmployeeWithCabinetDto.fromModel(employee);*/
        return facultyService.getByID(id);
    }

}
