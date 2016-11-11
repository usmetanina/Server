package server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import server.entity.Cabinet;
import server.entity.Employee;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class CabinetDto {
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

    public static CabinetDto fromModel(Cabinet cabinet) {
        if (cabinet!=null) {
            CabinetDto dto = new CabinetDto();
            dto.setNumber(cabinet.getNumber());
            dto.setTitle(cabinet.getTitle());
            dto.setFunctions(cabinet.getFunctions());
            dto.setLunchHours(cabinet.getLunchHours());
            dto.setWorkHours(cabinet.getWorkHours());
            return dto;
        }
        return null;
    }
}
