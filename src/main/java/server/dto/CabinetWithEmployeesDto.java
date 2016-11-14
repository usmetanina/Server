package server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.entity.Cabinet;
import server.entity.Employee;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CabinetWithEmployeesDto {
    @JsonProperty("number")
    private int number;

    @JsonProperty("title")
    private String title;

    @JsonProperty("functions")
    private String functions;

    @JsonProperty("workHours")
    private String workHours;

    @JsonProperty("lunchHours")
    private String lunchHours;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFunctions() {
        return functions;
    }

    public void setFunctions(String functions) {
        this.functions = functions;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    @JsonProperty("employees")
    private LinkedList<EmployeeDto> employees = new LinkedList<>();

    public LinkedList<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(LinkedList<EmployeeDto> employees) {
        this.employees = employees;
    }

    public static CabinetWithEmployeesDto fromModel(Cabinet cabinet) {
        CabinetWithEmployeesDto dto = new CabinetWithEmployeesDto();
        dto.setNumber(cabinet.getNumber());
        dto.setWorkHours(cabinet.getWorkHours());
        dto.setLunchHours(cabinet.getLunchHours());
        dto.setFunctions(cabinet.getFunctions());
        dto.setTitle(cabinet.getTitle());

        LinkedList<EmployeeDto> employeeDtos = new LinkedList<>();

        for (Employee employee : cabinet.getEmployees()) {
            employeeDtos.add(EmployeeDto.fromModel(employee));
        }
        dto.setEmployees(employeeDtos);

        return dto;
    }
}
