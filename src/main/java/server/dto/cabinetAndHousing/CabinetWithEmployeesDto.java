package server.dto.cabinetAndHousing;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.employee.EmployeeDto;
import server.entity.Cabinet;
import server.entity.Employee;
import server.entity.FunctionCabinet;

import java.util.LinkedList;

public class CabinetWithEmployeesDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("number")
    private String number;

    @JsonProperty("housing")
    private HousingDto housing;

    @JsonProperty("title")
    private String title;

    @JsonProperty("functions")
    private LinkedList<FunctionCabinetDto> functions = new LinkedList<>();

    @JsonProperty("workHours")
    private String workHours;

    @JsonProperty("lunchHours")
    private String lunchHours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public HousingDto getHousing() {
        return housing;
    }

    public void setHousing(HousingDto housing) {
        this.housing = housing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<FunctionCabinetDto> getFunctions() {
        return functions;
    }

    public void setFunctions(LinkedList<FunctionCabinetDto> functions) {
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
        dto.setId(cabinet.getId());
        dto.setHousing(HousingDto.fromModel(cabinet.getHousing()));
        dto.setNumber(cabinet.getNumber());
        dto.setWorkHours(cabinet.getWorkHours());
        dto.setLunchHours(cabinet.getLunchHours());

        LinkedList<FunctionCabinetDto> functonsDto = new LinkedList<>();

        for (FunctionCabinet functionCabinet : cabinet.getFunctions()) {
            functonsDto.add(FunctionCabinetDto.fromModel(functionCabinet));
        }
        dto.setFunctions(functonsDto);

        dto.setTitle(cabinet.getTitle());

        LinkedList<EmployeeDto> employeeDtos = new LinkedList<>();

        for (Employee employee : cabinet.getEmployees()) {
            employeeDtos.add(EmployeeDto.fromModel(employee));
        }
        dto.setEmployees(employeeDtos);

        return dto;
    }
}
