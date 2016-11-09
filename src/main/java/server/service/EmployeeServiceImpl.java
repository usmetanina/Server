package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.entity.Employee;
import server.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getByID(int id) {
        return employeeRepository.findOne(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    public void remove(int id) {
        employeeRepository.delete(id);
    }
}
