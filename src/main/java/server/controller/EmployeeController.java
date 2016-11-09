package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import server.dto.CabinetWithEmployeesDto;
import server.dto.EmployeeWithCabinetDto;
import server.entity.Cabinet;
import server.entity.Employee;
import server.repository.EmployeeRepository;
import server.service.EmployeeService;
import server.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    /*@RequestMapping(value = "/employees" , method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }*/

    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeWithCabinetDto> getAllEmployees() {
        List<Employee> list = employeeService.getAll();
        List<EmployeeWithCabinetDto> result = new ArrayList<>(list.size());
        list.forEach(employee -> result.add(EmployeeWithCabinetDto.fromModel(employee)));
        return result;
    }

    @RequestMapping(value = "/employees/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployees(@PathVariable int id) {
        return employeeService.getByID(id);
    }


    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    @ResponseBody
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable int id) {
        employeeService.remove(id);
    }
}
