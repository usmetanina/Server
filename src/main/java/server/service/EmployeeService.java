package server.service;

import server.entity.Employee;

import java.util.List;
import java.util.Objects;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getByID(int id);
    Employee save(Employee employee);
    void remove(int id);
}
