package server.service;

import server.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getByID(int id);
    Employee save(Employee employee);
    void remove(int id);
}
