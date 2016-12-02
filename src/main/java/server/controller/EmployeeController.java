package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.employee.EmployeeWithCabinetDto;
import server.dto.employee.EmployeeWithIdCabinetDto;
import server.entity.Employee;
import server.service.EmployeeServiceImpl;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @RequestMapping(value = "/employeeEntity" , method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeWithIdCabinetDto> getAllEmployeesWithIdCabinets() {
        List<Employee> list = employeeService.getAll();
        List<EmployeeWithIdCabinetDto> result = new ArrayList<>(list.size());
        list.forEach(employee -> result.add(EmployeeWithIdCabinetDto.fromModel(employee)));
        return result;
    }

    @RequestMapping(value = "/employees/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public EmployeeWithCabinetDto getEmployees(@PathVariable int id) {
        Employee employee = employeeService.getByID(id);
        return EmployeeWithCabinetDto.fromModel(employee);
    }

    @RequestMapping(value = "/employees/photo/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public void getPhotoEmployee(@PathVariable int id, HttpServletResponse response) throws IOException {

        Employee employee = employeeService.getByID(id);
        byte[] photo = employee.getPhoto();
        response.setContentLength((int) photo.length);
        // получаете поток для своих нужд
        ServletOutputStream outStream = response.getOutputStream();
        // отсылаете картинку на клиента
        outStream.write(photo);
        // закрываете поток
        outStream.close();
        /*
        Employee employee = employeeService.getByID(id);
        byte[] ph = employee.getPhoto();
        return employee.getPhoto();*/
    }
/*
    @RequestMapping(value = "/employees/{surname}" , method = RequestMethod.GET)
    @ResponseBody
    public EmployeeWithCabinetDto getEmployees(@PathVariable String surname) {
        Employee employee = employeeService.getBySurname(surname);
        return EmployeeWithCabinetDto.fromModel(employee);
    }*/


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
