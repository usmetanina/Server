package server.dto.schedule;

import com.fasterxml.jackson.annotation.JsonProperty;
import server.dto.EmployeeWithCabinetDto;
import server.dto.cabinetAndHousing.CabinetDto;
import server.dto.cabinetAndHousing.CabinetWithEmployeesDto;
import server.dto.cabinetAndHousing.FunctionCabinetDto;
import server.dto.cabinetAndHousing.HousingDto;
import server.entity.*;

import java.util.LinkedList;

public class LessonDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("typeOfLesson")
    private String typeOfLesson;

    @JsonProperty("nameOfSubject")
    private String nameOfSubject;

    @JsonProperty("employee")
    private EmployeeWithCabinetDto employee;

    @JsonProperty("cabinet")
    private CabinetWithEmployeesDto cabinet;

    @JsonProperty("time")
    private TimeOfLessonDto time;

    public LessonDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfLesson() {
        return typeOfLesson;
    }

    public void setTypeOfLesson(String typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    public EmployeeWithCabinetDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeWithCabinetDto employee) {
        this.employee = employee;
    }

    public CabinetWithEmployeesDto getCabinet() {
        return cabinet;
    }

    public void setCabinet(CabinetWithEmployeesDto cabinet) {
        this.cabinet = cabinet;
    }

    public TimeOfLessonDto getTime() {
        return time;
    }

    public void setTime(TimeOfLessonDto time) {
        this.time = time;
    }

    public static LessonDto fromModel(Lesson lesson) {
        if (lesson!=null) {
            LessonDto dto = new LessonDto();

            dto.setId((lesson.getId()));
            dto.setCabinet(CabinetWithEmployeesDto.fromModel(lesson.getCabinet()));
            dto.setEmployee(EmployeeWithCabinetDto.fromModel(lesson.getEmployee()));
            dto.setNameOfSubject(lesson.getNameOfSubject());
            dto.setTime(TimeOfLessonDto.fromModel(lesson.getTime()));
            dto.setTypeOfLesson(lesson.getTypeOfLesson());

            return dto;
        }
        return null;
    }
}
