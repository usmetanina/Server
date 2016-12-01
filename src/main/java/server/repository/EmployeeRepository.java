package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
